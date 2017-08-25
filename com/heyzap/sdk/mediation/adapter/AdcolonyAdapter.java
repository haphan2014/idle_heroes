package com.heyzap.sdk.mediation.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyUserMetadata;
import com.adcolony.sdk.AdColonyZone;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.PausableRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.AdUnitNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.adapter.AdUnitAliasMap;
import com.heyzap.mediation.adapter.AdUnitStateManager;
import com.heyzap.mediation.adapter.FetchStateManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.DemographicInfo;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class AdcolonyAdapter extends AdUnitNetworkAdapter {
    private AdUnitAliasMap adUnitAliasMap;
    private final AdUnitStateManager adUnitStateManager = new AdUnitStateManager();
    private String appId;
    private final EnumSet<AdUnit> enabledAdUnits = EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED, AdUnit.VIDEO);
    private final FetchStateManager<AdWrapper> fetchStateManager = new FetchStateManager();
    private String incentivizedZoneId;
    private String interstitialZoneId;
    private ArrayDeque<AdDisplay> unrewardedIncentivizedDisplays = new ArrayDeque();
    private HashMap<String, AdUnit> zoneToAdUnitMap;

    private class AdListener extends AdColonyInterstitialListener {
        private final AdWrapper adWrapper;
        private final NetworkAdapter adapter;

        AdListener(AdWrapper wrapper, NetworkAdapter adapter) {
            this.adWrapper = wrapper;
            this.adapter = adapter;
        }

        public void onOpened(AdColonyInterstitial ad) {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
        }

        public void onClosed(AdColonyInterstitial ad) {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
            this.adWrapper.closeListener.set(Boolean.valueOf(true));
        }

        public void onRequestFilled(AdColonyInterstitial ad) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            this.adWrapper.fetchFuture.set(FetchResult.SUCCESS);
            this.adWrapper.setAd(ad);
        }

        public void onRequestNotFilled(AdColonyZone zone) {
            this.adWrapper.fetchFuture.set(FetchResult.NO_FILL);
        }

        public void onExpiring(AdColonyInterstitial ad) {
            if (AdcolonyAdapter.this.zoneToAdUnitMap.get(ad.getZoneID()) != null) {
                AdUnit adUnit = AdcolonyAdapter.this.adUnitAliasMap.translate((AdUnit) AdcolonyAdapter.this.zoneToAdUnitMap.get(ad.getZoneID()));
                AdcolonyAdapter.this.fetchStateManager.set(adUnit, new AdWrapper());
                AdcolonyAdapter.this.attemptNextFetch(adUnit);
            }
        }
    }

    private class AdWrapper extends AdDisplay {
        private AdColonyInterstitial ad;
        public final SettableFuture<FetchResult> fetchFuture;

        private AdWrapper() {
            this.fetchFuture = SettableFuture.create();
            this.ad = null;
        }

        @Nullable
        public AdColonyInterstitial getAd() {
            return this.ad;
        }

        public void setAd(AdColonyInterstitial ad) {
            this.ad = ad;
        }
    }

    private class IncentiveListener implements AdColonyRewardListener {
        private final NetworkAdapter adapter;

        IncentiveListener(NetworkAdapter adapter) {
            this.adapter = adapter;
        }

        public void onReward(AdColonyReward adColonyReward) {
            if (!AdcolonyAdapter.this.unrewardedIncentivizedDisplays.isEmpty()) {
                ((AdDisplay) AdcolonyAdapter.this.unrewardedIncentivizedDisplays.remove()).incentiveListener.set(Boolean.valueOf(adColonyReward.success()));
            }
            this.adapter.onCallbackEvent(adColonyReward.success() ? NetworkCallback.INCENTIVIZED_RESULT_COMPLETE : NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
        }
    }

    public boolean isInterstitialVideo() {
        return this.adUnitAliasMap.translate(AdUnit.INTERSTITIAL) == AdUnit.VIDEO;
    }

    public Boolean isOnBoard() {
        if (Utils.classExists("com.adcolony.sdk.AdColony").booleanValue()) {
            return Boolean.valueOf(true);
        }
        if (Utils.classExists("com.jirbo.adcolony.AdColony").booleanValue()) {
            DevLogger.warn("AdColony 2.x not supported, please update to AdColony 3.x");
        }
        return Boolean.valueOf(false);
    }

    public String getMarketingName() {
        return "AdColony";
    }

    public String getMarketingVersion() {
        return "3.1.0";
    }

    public String getCanonicalName() {
        return Network.ADCOLONY;
    }

    public void onInit() throws ConfigurationError {
        this.adUnitAliasMap = new AdUnitAliasMap();
        this.adUnitAliasMap.add(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
        AdWrapper unsupportedWrapper = new AdWrapper();
        unsupportedWrapper.fetchFuture.set(new FetchResult(FetchFailureReason.CONFIGURATION_ERROR, "Unsupported Ad Unit"));
        this.fetchStateManager.setDefaultValue(unsupportedWrapper);
        this.fetchStateManager.set(AdUnit.VIDEO, new AdWrapper());
        this.fetchStateManager.set(AdUnit.INCENTIVIZED, new AdWrapper());
        this.adUnitStateManager.setAliasMap(this.adUnitAliasMap);
        if (getContextRef().getActivity() == null) {
            throw new ConfigurationError("Context is not an Activity. Please pass an Activity to HeyzapAds.start to enable adcolony.");
        }
        this.appId = getConfiguration().getValue("app_id");
        if (this.appId == null || this.appId.equals("")) {
            throw new ConfigurationError("No App ID for AdColony");
        }
        this.interstitialZoneId = getConfiguration().getValue("interstitial_zone_id");
        this.incentivizedZoneId = getConfiguration().getValue("incentivized_zone_id");
        if (this.interstitialZoneId == null && this.incentivizedZoneId == null) {
            throw new ConfigurationError("No Zone ID for AdColony");
        }
        this.zoneToAdUnitMap = new HashMap();
        this.zoneToAdUnitMap.put(this.interstitialZoneId, AdUnit.VIDEO);
        this.zoneToAdUnitMap.put(this.incentivizedZoneId, AdUnit.INCENTIVIZED);
        if (this.interstitialZoneId == null) {
            this.enabledAdUnits.remove(AdUnit.INTERSTITIAL);
            this.enabledAdUnits.remove(AdUnit.VIDEO);
        }
        if (this.incentivizedZoneId == null) {
            this.enabledAdUnits.remove(AdUnit.INCENTIVIZED);
        }
    }

    protected void onStart() {
        AdColonyAppOptions options = new AdColonyAppOptions();
        if (Utils.isAmazon()) {
            options.setOriginStore("amazon");
        }
        AdColonyUserMetadata meta = new AdColonyUserMetadata();
        DemographicInfo info = HeyzapAds.getDemographicInfo();
        if (info.getUserAgeFromBirthdate() != null) {
            meta.setUserAge(info.getUserAgeFromBirthdate().intValue());
        }
        if (info.getUserHouseholdIncome() != null) {
            meta.setUserAnnualHouseholdIncome(info.getUserHouseholdIncome().intValue());
        }
        if (info.getLocation() != null) {
            meta.setUserLocation(info.getLocation());
        }
        if (info.getUserPostalCode() != null) {
            meta.setUserZipCode(info.getUserPostalCode());
        }
        meta.setUserMaritalStatus(info.getUserMaritalStatus().getAdColonyString()).setUserEducation(info.getUserEducationLevel().getAdColonyString()).setUserGender(info.getUserGender().getAdColonyString());
        for (String interest : info.getUserInterests() == null ? Collections.EMPTY_LIST : info.getUserInterests()) {
            meta.addUserInterest(interest);
        }
        options.setUserMetadata(meta);
        if (!TextUtils.isEmpty(this.interstitialZoneId) && !TextUtils.isEmpty(this.incentivizedZoneId)) {
            AdColony.configure(getContextRef().getActivity(), options, this.appId, new String[]{this.interstitialZoneId, this.incentivizedZoneId});
        } else if (!TextUtils.isEmpty(this.interstitialZoneId)) {
            AdColony.configure(getContextRef().getActivity(), options, this.appId, new String[]{this.interstitialZoneId});
        } else if (!TextUtils.isEmpty(this.incentivizedZoneId)) {
            AdColony.configure(getContextRef().getActivity(), options, this.appId, new String[]{this.incentivizedZoneId});
        }
        AdColony.setRewardListener(new IncentiveListener(this));
        onCallbackEvent(NetworkCallback.INITIALIZED);
    }

    public SettableFuture<FetchResult> awaitAvailability(AdUnit inboundAdUnit) {
        return ((AdWrapper) this.fetchStateManager.get(this.adUnitAliasMap.translate(inboundAdUnit))).fetchFuture;
    }

    public SettableFuture<FetchResult> startAdUnits(Collection<AdUnit> adUnits) {
        final SettableFuture<FetchResult> retFuture = SettableFuture.create();
        Set<AdUnit> startedUnits = this.adUnitStateManager.start(this.adUnitAliasMap.translate((Collection) adUnits));
        startedUnits.retainAll(this.enabledAdUnits);
        if (startedUnits.isEmpty()) {
            retFuture.set(new FetchResult());
        } else {
            List<SettableFuture<FetchResult>> pendingFetches = new ArrayList(startedUnits.size());
            for (AdUnit adUnit : startedUnits) {
                attemptNextFetch(adUnit);
                pendingFetches.add(awaitAvailability(adUnit));
            }
            FutureUtils.allOf(pendingFetches, this.executorService).addListener(new Runnable() {
                public void run() {
                    retFuture.set(new FetchResult());
                }
            }, this.executorService);
        }
        return retFuture;
    }

    public boolean isAdUnitStarted(Collection<AdUnit> adUnitList) {
        return this.adUnitStateManager.allStarted(this.adUnitAliasMap.translate((Collection) adUnitList));
    }

    public void attemptNextFetch(AdUnit adUnit) {
        final NetworkAdapter adapter = this;
        final AdUnit translatedAdUnit = this.adUnitAliasMap.translate(adUnit);
        final AdUnit adUnit2 = adUnit;
        getFetchConsumer().consumeAny(this.adUnitAliasMap.getAliases(adUnit), new PausableRunnable(this.pauseSignal, this.executorService) {

            class C15141 extends RetryableTask {
                C15141() {
                }

                public void run() {
                    AdcolonyAdapter.this.fetchStateManager.start(translatedAdUnit);
                    final AdWrapper wrapper = (AdWrapper) AdcolonyAdapter.this.fetchStateManager.get(translatedAdUnit);
                    switch (translatedAdUnit) {
                        case INCENTIVIZED:
                            AdColony.requestInterstitial(AdcolonyAdapter.this.incentivizedZoneId, new AdListener(wrapper, adapter));
                            break;
                        case VIDEO:
                            AdColony.requestInterstitial(AdcolonyAdapter.this.interstitialZoneId, new AdListener(wrapper, adapter));
                            break;
                    }
                    wrapper.fetchFuture.addListener(new Runnable() {
                        public void run() {
                            FetchResult fetchResult = (FetchResult) FutureUtils.getImmediatelyOrDefault(wrapper.fetchFuture, FetchResult.NOT_READY);
                            if (!fetchResult.success) {
                                AdcolonyAdapter.this.onCallbackEvent(NetworkCallback.FETCH_FAILED);
                                AdcolonyAdapter.this.setLastFailure(adUnit2, fetchResult.fetchFailure);
                                AdcolonyAdapter.this.fetchStateManager.set(translatedAdUnit, new AdWrapper());
                                C15141.this.retry();
                            }
                        }
                    }, AdcolonyAdapter.this.executorService);
                }
            }

            public void runWhenUnpaused() {
                new RetryManager(new C15141(), new ExponentialSchedule(2.0d, 4, TimeUnit.SECONDS), AdcolonyAdapter.this.executorService).start();
            }
        }, this.executorService);
    }

    public AdDisplay show(final MediationRequest mediationRequest, MediationResult mediationResult) {
        final AdDisplay adDisplay = new AdDisplay();
        NetworkAdapter adapter = this;
        mediationRequest.getRequestingActivity().runOnUiThread(new Runnable() {
            public void run() {
                AdUnit adUnit = AdcolonyAdapter.this.adUnitAliasMap.translate(mediationRequest.getAdUnit());
                AdWrapper wrapper = (AdWrapper) AdcolonyAdapter.this.fetchStateManager.get(adUnit);
                if (wrapper.getAd() != null) {
                    switch (adUnit) {
                        case INCENTIVIZED:
                            if (!wrapper.getAd().show()) {
                                adDisplay.displayEventStream.sendEvent(DisplayResult.UNKNOWN_FAILURE);
                                break;
                            }
                            AdcolonyAdapter.this.unrewardedIncentivizedDisplays.add(adDisplay);
                            adDisplay.displayEventStream.sendEvent(DisplayResult.SUCCESS);
                            break;
                        case VIDEO:
                            if (!wrapper.getAd().show()) {
                                adDisplay.displayEventStream.sendEvent(DisplayResult.UNKNOWN_FAILURE);
                                break;
                            } else {
                                adDisplay.displayEventStream.sendEvent(DisplayResult.SUCCESS);
                                break;
                            }
                        default:
                            adDisplay.displayEventStream.sendEvent(DisplayResult.NOT_READY);
                            break;
                    }
                }
                adDisplay.displayEventStream.sendEvent(DisplayResult.NOT_READY);
                AdcolonyAdapter.this.fetchStateManager.set(adUnit, new AdWrapper());
                AdcolonyAdapter.this.attemptNextFetch(adUnit);
            }
        });
        return adDisplay;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED, AdUnit.VIDEO);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return this.enabledAdUnits;
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case VIDEO:
                return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    public void addFetchStartedListener(final FetchStartedListener fetchStartedListener, ExecutorService executorService) {
        this.fetchStateManager.addFetchStartedListener(new FetchStateManager.FetchStartedListener<AdWrapper>() {
            public void onFetchStarted(AdUnit adUnit, AdWrapper value) {
                fetchStartedListener.onFetchStarted(adUnit, value.fetchFuture);
            }
        }, executorService);
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.adcolony.sdk.AdColonyInterstitialActivity", "com.adcolony.sdk.AdColonyAdViewActivity"});
    }

    public boolean onBackPressed() {
        return false;
    }
}
