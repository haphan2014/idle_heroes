package com.heyzap.sdk.mediation.adapter;

import android.app.Activity;
import android.view.View;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.PausableRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.AdUnitNetworkAdapter;
import com.heyzap.mediation.abstr.NativeNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdUnitStateManager;
import com.heyzap.mediation.adapter.FetchStateManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import com.heyzap.sdk.ads.NativeAd.Image;
import com.heyzap.sdk.ads.NativeAd.NativeAdWrapper;
import com.heyzap.sdk.ads.NativeAdResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ApplovinAdapter extends AdUnitNetworkAdapter implements NativeNetworkAdapter {
    private static final boolean PRECACHE_ADS = false;
    private static AppLovinSdk sdk = null;
    private AdUnitStateManager adUnitStateManager = new AdUnitStateManager();
    private final FetchStateManager<SettableFuture<ApplovinFetchResult>> fetchStateManager = new FetchStateManager();
    private final SettableFuture<Boolean> setupCompleted = SettableFuture.create();
    private final AtomicBoolean setupStarted = new AtomicBoolean(false);

    private static class AdDisplayListener implements AppLovinAdClickListener, AppLovinAdVideoPlaybackListener, AppLovinAdDisplayListener, AppLovinAdRewardListener {
        private final AdWrapper adWrapper;
        private final NetworkAdapter adapter;
        boolean displayFinished;
        boolean userVerified;

        private AdDisplayListener(AdWrapper adWrapper, NetworkAdapter adapter) {
            this.displayFinished = false;
            this.userVerified = false;
            this.adWrapper = adWrapper;
            this.adapter = adapter;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            this.adapter.onCallbackEvent("click");
            this.adWrapper.clickEventStream.sendEvent(Boolean.valueOf(true));
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            this.adWrapper.displayEventStream.sendEvent(new DisplayResult());
        }

        public void adHidden(AppLovinAd appLovinAd) {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
            this.adWrapper.closeListener.set(Boolean.valueOf(true));
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_COMPLETE);
            this.userVerified = true;
            checkIncentiveComplete();
        }

        private void checkIncentiveComplete() {
            if (this.userVerified && this.displayFinished) {
                this.adWrapper.incentiveListener.set(Boolean.valueOf(true));
            }
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
            this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }

        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
            this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            this.adapter.onCallbackEvent(NetworkCallback.AUDIO_STARTING);
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double v, boolean fullyWatched) {
            this.adapter.onCallbackEvent(NetworkCallback.AUDIO_FINISHED);
            if (fullyWatched) {
                this.displayFinished = true;
                checkIncentiveComplete();
                return;
            }
            this.adWrapper.incentiveListener.set(Boolean.valueOf(false));
        }
    }

    private static class AdFetchListener implements AppLovinAdLoadListener {
        private final NetworkAdapter adapter;
        private final SettableFuture<ApplovinFetchResult> fetchFuture;
        private final AppLovinIncentivizedInterstitial incentivizedAd;

        public AdFetchListener(SettableFuture<ApplovinFetchResult> fetchFuture, AppLovinIncentivizedInterstitial incentivizedAd, NetworkAdapter adapter) {
            this.fetchFuture = fetchFuture;
            this.incentivizedAd = incentivizedAd;
            this.adapter = adapter;
        }

        public void adReceived(AppLovinAd appLovinAd) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            this.fetchFuture.set(new ApplovinFetchResult(appLovinAd, this.incentivizedAd));
        }

        public void failedToReceiveAd(int errorCode) {
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            this.fetchFuture.set(new ApplovinFetchResult(getFetchFailureReason(errorCode), String.valueOf(errorCode)));
        }

        private FetchFailureReason getFetchFailureReason(int errorCode) {
            switch (errorCode) {
                case AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT /*-500*/:
                case AppLovinErrorCodes.FETCH_AD_TIMEOUT /*-102*/:
                    return FetchFailureReason.REMOTE_ERROR;
                case AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR /*-400*/:
                    return FetchFailureReason.REMOTE_ERROR;
                case AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED /*-300*/:
                case AppLovinErrorCodes.NO_FILL /*204*/:
                    return FetchFailureReason.NO_FILL;
                case AppLovinErrorCodes.UNABLE_TO_RENDER_AD /*-6*/:
                    return FetchFailureReason.CONFIGURATION_ERROR;
                case -1:
                    return FetchFailureReason.UNKNOWN;
                default:
                    return FetchFailureReason.UNKNOWN;
            }
        }
    }

    private static class AdWrapper extends AdDisplay {
    }

    private static class ApplovinFetchResult extends FetchResult {
        public final AppLovinAd cachedAd;
        public final AppLovinIncentivizedInterstitial incentivizedInterstitial;

        public ApplovinFetchResult(FetchFailureReason errorCode, String errorMessage) {
            this.fetchFailure = new FetchFailure(errorCode, errorMessage);
            this.success = false;
            this.cachedAd = null;
            this.incentivizedInterstitial = null;
        }

        public ApplovinFetchResult(AppLovinAd cachedAd, AppLovinIncentivizedInterstitial incentivizedInterstitial) {
            this.cachedAd = cachedAd;
            this.incentivizedInterstitial = incentivizedInterstitial;
            this.success = true;
        }
    }

    private class ApplovinNativeAdResult extends NativeAdResult {
        private AppLovinNativeAd ad;

        class C15331 implements Image {
            C15331() {
            }

            public int getWidth() {
                return 0;
            }

            public String getUrl() {
                return ApplovinNativeAdResult.this.ad.getIconUrl();
            }

            public int getHeight() {
                return 0;
            }
        }

        class C15342 implements Image {
            C15342() {
            }

            public int getWidth() {
                return 0;
            }

            public String getUrl() {
                return ApplovinNativeAdResult.this.ad.getImageUrl();
            }

            public int getHeight() {
                return 0;
            }
        }

        class C15353 implements AppLovinPostbackListener {
            C15353() {
            }

            public void onPostbackSuccess(String s) {
            }

            public void onPostbackFailure(String s, int i) {
                Logger.error("Could not track Applovin Native Impression: " + s);
            }
        }

        public ApplovinNativeAdResult(AppLovinNativeAd ad) {
            this.ad = ad;
        }

        public String getTitle() {
            return this.ad.getTitle();
        }

        public Image getIcon() {
            return new C15331();
        }

        public Image getCoverImage() {
            return new C15342();
        }

        public String getBody() {
            return this.ad.getDescriptionText();
        }

        public String getCallToAction() {
            return this.ad.getCtaText();
        }

        public String getSocialContext() {
            return null;
        }

        public Image getAdChoicesImage() {
            return null;
        }

        public String getAdChoicesUrl() {
            return null;
        }

        public Object getNativeAdObject() {
            return this.ad;
        }

        public void onClick(View view) {
            this.ad.launchClickTarget(ApplovinAdapter.this.getContextRef().getActivity());
        }

        public void onImpression() {
            ApplovinAdapter.sdk.getPostbackService().dispatchPostbackAsync(this.ad.getImpressionTrackingUrl(), new C15353());
        }

        public void registerView(View view) {
        }

        public FetchFailure getFetchFailure() {
            return null;
        }
    }

    public Boolean isOnBoard() {
        return Utils.classExists("com.applovin.sdk.AppLovinSdk");
    }

    public String getMarketingName() {
        return "AppLovin";
    }

    public String getMarketingVersion() {
        return AppLovinSdk.VERSION;
    }

    public String getCanonicalName() {
        return "applovin";
    }

    private SettableFuture<ApplovinFetchResult> createFetchFuture() {
        return SettableFuture.create();
    }

    public void onInit() {
        SettableFuture<ApplovinFetchResult> future = SettableFuture.create();
        future.set(new ApplovinFetchResult(FetchFailureReason.CONFIGURATION_ERROR, "unsupported ad unit"));
        this.fetchStateManager.setDefaultValue(future);
        this.fetchStateManager.set(AdUnit.INTERSTITIAL, createFetchFuture());
        this.fetchStateManager.set(AdUnit.INCENTIVIZED, createFetchFuture());
    }

    protected void onStart() {
        AppLovinSdkSettings settings = new AppLovinSdkSettings();
        settings.setVerboseLogging(HeyzapAds.isThirdPartyVerboseLogging());
        settings.setAutoPreloadSizes("INTER");
        settings.setAutoPreloadTypes("REGULAR,REWARD");
        sdk = AppLovinSdk.getInstance(getConfiguration().getValue("sdk_key"), settings, getContextRef().getApp());
        onCallbackEvent(NetworkCallback.INITIALIZED);
    }

    public SettableFuture<FetchResult> startAdUnits(Collection<AdUnit> adUnitList) {
        Set<AdUnit> startedUnits = this.adUnitStateManager.start(adUnitList);
        startedUnits.retainAll(getConfiguredAdUnitCapabilities());
        final SettableFuture<FetchResult> result = SettableFuture.create();
        if (startedUnits.isEmpty()) {
            result.set(new FetchResult());
        } else {
            List<SettableFuture<FetchResult>> futures = new ArrayList(startedUnits.size());
            for (AdUnit adUnit : startedUnits) {
                attemptNextFetch(adUnit);
                futures.add(awaitAvailability(adUnit));
            }
            FutureUtils.allOf(futures, this.executorService).addListener(new Runnable() {
                public void run() {
                    result.set(new FetchResult());
                }
            }, this.executorService);
        }
        return result;
    }

    public SettableFuture<FetchResult> awaitAvailability(AdUnit adUnit) {
        return (SettableFuture) this.fetchStateManager.get(adUnit);
    }

    public boolean isAdUnitStarted(Collection<AdUnit> adUnits) {
        return this.adUnitStateManager.allStarted(adUnits);
    }

    private void attemptNextFetch(AdUnit adUnit) {
        final SettableFuture<ApplovinFetchResult> fetchResultFuture = (SettableFuture) this.fetchStateManager.get(adUnit);
        final AdUnit adUnit2 = adUnit;
        getFetchConsumer().consumeAny(Arrays.asList(new AdUnit[]{adUnit}), new PausableRunnable(this.pauseSignal, this.executorService) {

            class C15271 extends RetryableTask {

                class C15261 implements Runnable {
                    C15261() {
                    }

                    public void run() {
                        FetchResult fetchResult = (FetchResult) FutureUtils.getImmediatelyOrDefault(fetchResultFuture, FetchResult.NOT_READY);
                        if (!fetchResult.success) {
                            ApplovinAdapter.this.setLastFailure(adUnit2, fetchResult.fetchFailure);
                            ApplovinAdapter.this.fetchStateManager.set(adUnit2, ApplovinAdapter.this.createFetchFuture());
                            C15271.this.retry();
                        }
                    }
                }

                C15271() {
                }

                public void run() {
                    ApplovinAdapter.this.fetchStateManager.start(adUnit2);
                    FutureUtils.bind(ApplovinAdapter.this.fetch(adUnit2), fetchResultFuture, ApplovinAdapter.this.executorService);
                    fetchResultFuture.addListener(new C15261(), ApplovinAdapter.this.executorService);
                }
            }

            public void runWhenUnpaused() {
                new RetryManager(new C15271(), new ExponentialSchedule(2.0d, 4, TimeUnit.SECONDS), ApplovinAdapter.this.executorService).start();
            }
        }, this.executorService);
    }

    public SettableFuture<ApplovinFetchResult> fetch(AdUnit adUnit) {
        SettableFuture<ApplovinFetchResult> fetchFuture = SettableFuture.create();
        switch (adUnit) {
            case INTERSTITIAL:
                sdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new AdFetchListener(fetchFuture, null, this));
                break;
            case INCENTIVIZED:
                AppLovinIncentivizedInterstitial incentivizedAd = AppLovinIncentivizedInterstitial.create(sdk);
                incentivizedAd.preload(new AdFetchListener(fetchFuture, incentivizedAd, this));
                break;
            default:
                fetchFuture.set(new ApplovinFetchResult(FetchFailureReason.CONFIGURATION_ERROR, "ad unit not supported"));
                break;
        }
        return fetchFuture;
    }

    public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult) {
        Activity activity = mediationRequest.getRequestingActivity();
        AdUnit adUnit = mediationRequest.getAdUnit();
        String tag = mediationRequest.getTag();
        AdWrapper adWrapper = new AdWrapper();
        AdDisplayListener displayListener = new AdDisplayListener(adWrapper, this);
        SettableFuture<ApplovinFetchResult> localFetch = (SettableFuture) this.fetchStateManager.get(adUnit);
        ApplovinFetchResult fetchResult = null;
        if (localFetch.isDone()) {
            try {
                fetchResult = (ApplovinFetchResult) localFetch.get();
            } catch (Throwable e) {
                Logger.trace(e);
            }
        }
        if (fetchResult == null || !fetchResult.success) {
            adWrapper.displayEventStream.sendEvent(DisplayResult.NOT_READY);
        } else {
            switch (adUnit) {
                case INTERSTITIAL:
                    AppLovinInterstitialAdDialog adDialog = AppLovinInterstitialAd.create(sdk, activity);
                    adDialog.setAdClickListener(displayListener);
                    adDialog.setAdVideoPlaybackListener(displayListener);
                    adDialog.setAdDisplayListener(displayListener);
                    adDialog.showAndRender(fetchResult.cachedAd);
                    break;
                case INCENTIVIZED:
                    if (fetchResult.incentivizedInterstitial != null) {
                        fetchResult.incentivizedInterstitial.show(activity, displayListener, displayListener, displayListener, displayListener);
                        break;
                    }
                    break;
                default:
                    adWrapper.displayEventStream.sendEvent(DisplayResult.UNSUPPORTED_AD_UNIT);
                    break;
            }
            if (localFetch.isDone()) {
                this.fetchStateManager.set(adUnit, createFetchFuture());
                attemptNextFetch(adUnit);
            }
        }
        return adWrapper;
    }

    public boolean isInterstitialVideo() {
        return false;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED, AdUnit.NATIVE);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED, AdUnit.NATIVE);
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case STATIC:
                return EnumSet.of(AdUnit.INTERSTITIAL);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            case NATIVE:
                return EnumSet.of(AdUnit.NATIVE);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    public void addFetchStartedListener(final FetchStartedListener fetchStartedListener, ExecutorService executorService) {
        this.fetchStateManager.addFetchStartedListener(new FetchStateManager.FetchStartedListener<SettableFuture<ApplovinFetchResult>>() {
            public void onFetchStarted(AdUnit adUnit, SettableFuture<ApplovinFetchResult> future) {
                fetchStartedListener.onFetchStarted(adUnit, future);
            }
        }, executorService);
    }

    public NativeAdWrapper fetchNative(FetchOptions options) {
        final NativeAdWrapper nativeAdWrapper = new NativeAdWrapper();
        startAdUnits(EnumSet.of(AdUnit.NATIVE)).addListener(new Runnable() {

            class C15301 implements AppLovinNativeAdLoadListener {
                C15301() {
                }

                public void onNativeAdsLoaded(List list) {
                    FetchResult f = new FetchResult();
                    f.setNativeAdResult(new ApplovinNativeAdResult((AppLovinNativeAd) list.get(0)));
                    f.success = true;
                    nativeAdWrapper.fetchListener.set(f);
                }

                public void onNativeAdsFailedToLoad(int errorCode) {
                    switch (errorCode) {
                        case AppLovinErrorCodes.NO_FILL /*204*/:
                            nativeAdWrapper.fetchListener.set(new FetchResult(FetchFailureReason.NO_FILL, "NO_FILL"));
                            return;
                        default:
                            nativeAdWrapper.fetchListener.set(new FetchResult(FetchFailureReason.UNKNOWN, "UNKNOWN"));
                            return;
                    }
                }
            }

            public void run() {
                ApplovinAdapter.sdk.getNativeAdService().loadNativeAds(1, new C15301());
            }
        }, this.executorService);
        return nativeAdWrapper;
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.applovin.adview.AppLovinInterstitialActivity", "com.applovin.adview.AppLovinConfirmationActivity"});
    }

    public boolean onBackPressed() {
        return false;
    }
}
