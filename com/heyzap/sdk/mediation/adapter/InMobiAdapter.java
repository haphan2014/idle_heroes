package com.heyzap.sdk.mediation.adapter;

import android.location.Location;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.common.banner.BannerWrapper.OnSizeChangeListener;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.LocationProvider.LocationListener;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.BannerNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.CachedAd.ExpiryListener;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.DisplayableFetchResult;
import com.heyzap.mediation.abstr.NativeNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.adapter.AdUnitAliasMap;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.DemographicInfo;
import com.heyzap.sdk.ads.DemographicInfo.EducationLevel;
import com.heyzap.sdk.ads.DemographicInfo.Gender;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import com.heyzap.sdk.ads.HeyzapAds.CreativeSize;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.NativeAd.Image;
import com.heyzap.sdk.ads.NativeAd.NativeAdWrapper;
import com.heyzap.sdk.ads.NativeAdResult;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAdRequestStatus.StatusCode;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiBanner.BannerAdListener;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiInterstitial.InterstitialAdListener2;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.InMobiSdk.Education;
import com.inmobi.sdk.InMobiSdk.LogLevel;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class InMobiAdapter extends FetchBackedNetworkAdapter implements NativeNetworkAdapter, BannerNetworkAdapter {
    private static final AuctionType AUCTION_TYPE = AuctionType.MONETIZATION;
    private String accountId;
    protected AdUnitAliasMap adUnitAliasMap = new AdUnitAliasMap();
    private InMobiCachedBannerAd cachedBannerAd = null;
    private final EnumSet<AdUnit> configuredAdUnits = EnumSet.noneOf(AdUnit.class);
    private final Map<CreativeType, Long> placementIds = new HashMap();

    class C15721 implements LocationListener {
        C15721() {
        }

        public void onLocationUpdate(Location location) {
            InMobiSdk.setLocation(location);
        }
    }

    static /* synthetic */ class C15765 {
        static final /* synthetic */ int[] $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode = new int[StatusCode.values().length];

        static {
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.NO_FILL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.REQUEST_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.REQUEST_INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.NETWORK_UNREACHABLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.REQUEST_TIMED_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.EARLY_REFRESH_REQUEST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.SERVER_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.INTERNAL_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.AD_NO_LONGER_AVAILABLE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[StatusCode.MISSING_REQUIRED_DEPENDENCIES.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            $SwitchMap$com$heyzap$internal$Constants$CreativeType = new int[CreativeType.values().length];
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.INCENTIVIZED.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.NATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.BANNER.ordinal()] = 5;
            } catch (NoSuchFieldError e15) {
            }
            $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$Gender = new int[Gender.values().length];
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$Gender[Gender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$Gender[Gender.FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError e17) {
            }
            $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel = new int[EducationLevel.values().length];
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.ASSOCIATE_DEGREE.ordinal()] = 1;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.BACHELORS_DEGREE.ordinal()] = 2;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.COLLEGE_UNFINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.GRADUATE_DEGREE.ordinal()] = 4;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.POST_GRADUATE_DEGREE.ordinal()] = 5;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.UNKNOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.GRADE_SCHOOL.ordinal()] = 7;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.HIGH_SCHOOL_FINISHED.ordinal()] = 8;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$com$heyzap$sdk$ads$DemographicInfo$EducationLevel[EducationLevel.HIGH_SCHOOL_UNFINISHED.ordinal()] = 9;
            } catch (NoSuchFieldError e26) {
            }
        }
    }

    public class HZInterstitialAdListener implements InterstitialAdListener2 {
        private final AdDisplay adDisplay = new AdDisplay(false);
        private final SettableFuture<DisplayableFetchResult> fetchResultFuture = SettableFuture.create();

        public HZInterstitialAdListener() {
            this.adDisplay.setRefetchDelay(60);
        }

        public void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
            this.adDisplay.incentiveListener.set(Boolean.valueOf(true));
        }

        public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
            this.adDisplay.displayEventStream.sendEvent(new DisplayResult("Ad Failed to Show"));
        }

        public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
        }

        public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
            this.adDisplay.displayEventStream.sendEvent(new DisplayResult());
        }

        public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
            this.adDisplay.closeListener.set(Boolean.valueOf(true));
            this.adDisplay.impressionRegisteredListener.set(Boolean.valueOf(true));
        }

        public void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
        }

        public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
            this.fetchResultFuture.set(new DisplayableFetchResult(new InMobiCachedAd(inMobiInterstitial, this.adDisplay)));
        }

        public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
            if (inMobiAdRequestStatus.getStatusCode() != StatusCode.REQUEST_PENDING || inMobiInterstitial == null) {
                this.fetchResultFuture.set(new DisplayableFetchResult(InMobiAdapter.this.failureForStatus(inMobiAdRequestStatus)));
            } else if (inMobiInterstitial != null) {
                this.fetchResultFuture.set(new DisplayableFetchResult(new InMobiCachedAd(inMobiInterstitial, this.adDisplay)));
            }
        }

        public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
        }

        public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
            this.adDisplay.clickEventStream.sendEvent(Boolean.valueOf(true));
        }

        public SettableFuture<DisplayableFetchResult> getFetchResultFuture() {
            return this.fetchResultFuture;
        }
    }

    public class InMobiBannerListener implements BannerAdListener {
        private final AdDisplay adDisplay = new AdDisplay();

        public InMobiBannerListener(RelativeLayout bannerFrame, InMobiBanner banner) {
            DisplayResult displayResult = new DisplayResult();
            displayResult.bannerWrapper = new InMobiBannerWrapper(bannerFrame, banner);
            this.adDisplay.displayEventStream.sendEvent(displayResult);
        }

        public void onAdLoadSucceeded(InMobiBanner inMobiBanner) {
            this.adDisplay.displayEventStream.sendEvent(new DisplayResult());
        }

        public void onAdLoadFailed(InMobiBanner inMobiBanner, InMobiAdRequestStatus inMobiAdRequestStatus) {
            FetchFailure f = InMobiAdapter.this.failureForStatus(inMobiAdRequestStatus);
            this.adDisplay.displayEventStream.sendEvent(new DisplayResult(f.getMessage(), f.getErrorType()));
        }

        public void onAdDisplayed(InMobiBanner inMobiBanner) {
        }

        public void onAdDismissed(InMobiBanner inMobiBanner) {
        }

        public void onAdInteraction(InMobiBanner inMobiBanner, Map<Object, Object> map) {
            this.adDisplay.clickEventStream.sendEvent(Boolean.valueOf(true));
        }

        public void onUserLeftApplication(InMobiBanner inMobiBanner) {
        }

        public void onAdRewardActionCompleted(InMobiBanner inMobiBanner, Map<Object, Object> map) {
        }
    }

    public class InMobiBannerWrapper implements BannerWrapper {
        private final InMobiBanner banner;
        private final RelativeLayout bannerFrame;
        public String network = "";

        public InMobiBannerWrapper(RelativeLayout bannerFrame, InMobiBanner banner) {
            this.bannerFrame = bannerFrame;
            this.banner = banner;
        }

        public View getRealBannerView() {
            return this.bannerFrame;
        }

        public int getAdHeight() {
            return this.banner.getLayoutParams().height;
        }

        public int getAdWidth() {
            return this.banner.getLayoutParams().width;
        }

        public boolean destroyBanner(boolean permaDeath) {
            this.bannerFrame.removeView(this.banner);
            if (InMobiAdapter.this.cachedBannerAd == null) {
                return false;
            }
            InMobiAdapter.this.cachedBannerAd = null;
            return true;
        }

        public void setSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        }
    }

    public class InMobiCachedAd implements CachedAd {
        private final AdDisplay adDisplay;
        private final InMobiInterstitial inMobiInterstitial;

        class C15771 implements Runnable {
            C15771() {
            }

            public void run() {
                InMobiCachedAd.this.inMobiInterstitial.show();
            }
        }

        public InMobiCachedAd(InMobiInterstitial inMobiInterstitial, AdDisplay adDisplay) {
            this.inMobiInterstitial = inMobiInterstitial;
            this.adDisplay = adDisplay;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            InMobiAdapter.this.uiThreadExecutorService.execute(new C15771());
            return this.adDisplay;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    public class InMobiCachedBannerAd implements CachedAd {
        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            return InMobiAdapter.this.fetchAndShowBanner(mediationRequest.getBannerOptions());
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    private class InMobiNativeAdResult extends NativeAdResult {
        InMobiNative ad;
        JSONObject json;

        public InMobiNativeAdResult(InMobiNative ad) {
            this.ad = ad;
            try {
                this.json = new JSONObject((String) ad.getAdContent());
            } catch (JSONException e) {
                Logger.error("Problem deserializing InMobi Native Ad", e);
                this.json = new JSONObject();
            }
        }

        public String getTitle() {
            return this.json.optString("title");
        }

        public Image getIcon() {
            String url;
            int width;
            int height;
            try {
                JSONObject iconImage = this.json.getJSONObject("icon");
                url = iconImage.getString("url");
                width = iconImage.getInt("width");
                height = iconImage.getInt("height");
            } catch (JSONException e) {
                url = "";
                width = 0;
                height = 0;
            }
            final String u = url;
            final int w = width;
            final int h = height;
            return new Image() {
                public int getWidth() {
                    return w;
                }

                public String getUrl() {
                    return u;
                }

                public int getHeight() {
                    return h;
                }
            };
        }

        public Image getCoverImage() {
            String url;
            int width;
            int height;
            try {
                JSONObject coverImage = this.json.getJSONObject("cover");
                url = coverImage.getString("url");
                width = coverImage.getInt("width");
                height = coverImage.getInt("height");
            } catch (JSONException e) {
                url = "";
                width = 0;
                height = 0;
            }
            final String u = url;
            final int w = width;
            final int h = height;
            return new Image() {
                public int getWidth() {
                    return w;
                }

                public String getUrl() {
                    return u;
                }

                public int getHeight() {
                    return h;
                }
            };
        }

        public String getBody() {
            return this.json.optString("description");
        }

        public String getCallToAction() {
            return this.json.optString("cta");
        }

        public String getSocialContext() {
            return "";
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
            this.ad.reportAdClickAndOpenLandingPage(new HashMap());
        }

        public void onImpression() {
        }

        public void registerView(View view) {
            InMobiNative.bind(view, this.ad);
        }

        public FetchFailure getFetchFailure() {
            return null;
        }
    }

    private class InMobiNativeListener implements NativeAdListener {
        private InMobiAdapter inMobiAdapter;
        private NativeAdWrapper nativeAdWrapper;

        public InMobiNativeListener(NativeAdWrapper nativeAdWrapper, InMobiAdapter inMobiAdapter) {
            this.nativeAdWrapper = nativeAdWrapper;
            this.inMobiAdapter = inMobiAdapter;
        }

        public void onAdLoadSucceeded(InMobiNative ad) {
            FetchResult fetchResult = new FetchResult();
            fetchResult.setNativeAdResult(new InMobiNativeAdResult(ad));
            fetchResult.success = true;
            this.nativeAdWrapper.fetchListener.set(fetchResult);
        }

        public void onAdLoadFailed(InMobiNative ad, InMobiAdRequestStatus status) {
            this.nativeAdWrapper.fetchListener.set(new FetchResult(InMobiAdapter.this.failureForStatus(status)));
        }

        public void onAdDisplayed(InMobiNative ad) {
            this.nativeAdWrapper.clickEventListener.sendEvent(Boolean.valueOf(true));
        }

        public void onAdDismissed(InMobiNative ad) {
        }

        public void onUserLeftApplication(InMobiNative ad) {
        }
    }

    public Boolean isOnBoard() {
        return Utils.classExists("com.inmobi.sdk.InMobiSdk");
    }

    public String getMarketingName() {
        return "InMobi";
    }

    public String getMarketingVersion() {
        return InMobiSdk.getVersion();
    }

    public String getCanonicalName() {
        return Network.INMOBI;
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});
    }

    public List<String> getActivities() {
        return Collections.singletonList("com.inmobi.rendering.InMobiAdActivity");
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onInit() throws ConfigurationError {
        this.adUnitAliasMap = new AdUnitAliasMap();
        this.adUnitAliasMap.add(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
        if (getContextRef().getActivity() == null) {
            throw new ConfigurationError("Context is not an Activity. Please pass an Activity to HeyzapAds.start to enable InMobi.");
        }
        this.accountId = getConfiguration().getValue("account_id");
        if (this.accountId == null || this.accountId.equals("")) {
            throw new ConfigurationError("No account_id for InMobi");
        }
        for (CreativeType creativeType : CreativeType.values()) {
            String ctString = creativeType.toString().toLowerCase();
            if (creativeType == CreativeType.INCENTIVIZED) {
                ctString = "rewarded_video";
            }
            String idString = getConfiguration().getValue(ctString + "_placement_id");
            if (idString != null) {
                try {
                    Long id = Long.valueOf(idString);
                    if (id.longValue() > 0) {
                        this.placementIds.put(creativeType, id);
                        this.configuredAdUnits.addAll(creativeType.adUnits());
                    }
                } catch (IllegalArgumentException e) {
                    throw new ConfigurationError("Invalid placementId: " + idString);
                }
            }
        }
        if (Utils.isDebug(getContextRef().getActivity()).booleanValue()) {
            InMobiSdk.setLogLevel(LogLevel.DEBUG);
        }
    }

    protected void onStart() {
        InMobiSdk.init(getContextRef().getActivity(), this.accountId);
        this.locationProvider.addLocationListener(new C15721(), this.uiThreadExecutorService);
        DemographicInfo info = HeyzapAds.getDemographicInfo();
        if (info.getUserAgeFromBirthdate() != null) {
            InMobiSdk.setAge(info.getUserAgeFromBirthdate().intValue());
        }
        if (info.getUserHouseholdIncome() != null) {
            InMobiSdk.setIncome(info.getUserHouseholdIncome().intValue());
        }
        if (info.getUserPostalCode() != null) {
            InMobiSdk.setPostalCode(info.getUserPostalCode());
        }
        Education e;
        switch (info.getUserEducationLevel()) {
            case ASSOCIATE_DEGREE:
            case BACHELORS_DEGREE:
            case COLLEGE_UNFINISHED:
            case GRADUATE_DEGREE:
                e = Education.COLLEGE_OR_GRADUATE;
                break;
            case POST_GRADUATE_DEGREE:
                e = Education.POST_GRADUATE_OR_ABOVE;
                break;
            default:
                e = Education.HIGH_SCHOOL_OR_LESS;
                break;
        }
        if (info.getUserInterests() != null) {
            InMobiSdk.setInterests(TextUtils.join(",", info.getUserInterests()));
        }
        switch (info.getUserGender()) {
            case MALE:
                InMobiSdk.setGender(InMobiSdk.Gender.MALE);
                break;
            case FEMALE:
                break;
        }
        InMobiSdk.setGender(InMobiSdk.Gender.FEMALE);
        if (this.configuredAdUnits.contains(AdUnit.BANNER)) {
            start(FetchOptions.builder(Network.INMOBI, CreativeType.BANNER, AuctionType.MONETIZATION).setAdUnit(LargeSet.of(AdUnit.BANNER)).build());
        }
    }

    protected SettableFuture<DisplayableFetchResult> fetch(FetchOptions fetchOptions) {
        Long placementId = (Long) this.placementIds.get(fetchOptions.getCreativeType());
        if (placementId == null) {
            SettableFuture<DisplayableFetchResult> failedFuture = SettableFuture.create();
            failedFuture.set(new DisplayableFetchResult(new FetchFailure(FetchFailureReason.CONFIGURATION_ERROR, "Unsupported ad type: " + fetchOptions.getCreativeType())));
            return failedFuture;
        } else if (fetchOptions.getCreativeType() == CreativeType.BANNER) {
            if (this.cachedBannerAd == null) {
                this.cachedBannerAd = new InMobiCachedBannerAd();
            }
            SettableFuture<DisplayableFetchResult> future = SettableFuture.create();
            future.set(new DisplayableFetchResult(this.cachedBannerAd));
            return future;
        } else {
            HZInterstitialAdListener adListener = new HZInterstitialAdListener();
            final InMobiInterstitial interstitial = new InMobiInterstitial(getContextRef().getActivity(), placementId.longValue(), adListener);
            interstitial.setExtras(getInmobiExtras());
            this.uiThreadExecutorService.submit(new Runnable() {
                public void run() {
                    interstitial.load();
                }
            });
            return adListener.getFetchResultFuture();
        }
    }

    public NativeAdWrapper fetchNative(FetchOptions options) {
        NativeAdWrapper nativeAdWrapper = new NativeAdWrapper();
        final InMobiNativeListener nativeAdListener = new InMobiNativeListener(nativeAdWrapper, this);
        final Long placementId = (Long) this.placementIds.get(options.getCreativeType());
        if (placementId == null) {
            nativeAdWrapper.fetchListener.set(new FetchResult(new FetchFailure(FetchFailureReason.CONFIGURATION_ERROR, "No placement id provided for ad type native")));
        } else {
            this.uiThreadExecutorService.submit(new Runnable() {
                public void run() {
                    new InMobiNative(placementId.longValue(), nativeAdListener).load();
                }
            });
        }
        return nativeAdWrapper;
    }

    public FetchOptions canonizeFetch(FetchOptions fetchOptions) {
        return FetchOptions.builder(fetchOptions.getNetwork(), fetchOptions.getCreativeType(), fetchOptions.getAuctionType()).build();
    }

    public AuctionType getAuctionType() {
        return AUCTION_TYPE;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.INCENTIVIZED, AdUnit.BANNER, AdUnit.NATIVE);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return this.configuredAdUnits;
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case STATIC:
                return EnumSet.of(AdUnit.INTERSTITIAL);
            case VIDEO:
                return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            case NATIVE:
                return EnumSet.of(AdUnit.NATIVE);
            case BANNER:
                return EnumSet.of(AdUnit.BANNER);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    private Map<String, String> getInmobiExtras() {
        Map<String, String> map = new HashMap();
        map.put("tp", "c_heyzap");
        map.put("tp-ver", "9.11.3");
        return map;
    }

    public AdDisplay fetchAndShowBanner(final BannerOptions options) {
        final AdDisplay display = new AdDisplay();
        this.uiThreadExecutorService.execute(new Runnable() {
            public void run() {
                try {
                    int widthDp;
                    int heightDp;
                    int widthPx;
                    InMobiBanner banner = new InMobiBanner(InMobiAdapter.this.getContextRef().getActivity(), ((Long) InMobiAdapter.this.placementIds.get(CreativeType.BANNER)).longValue());
                    banner.setExtras(InMobiAdapter.this.getInmobiExtras());
                    RelativeLayout bannerFrame = new RelativeLayout(InMobiAdapter.this.getContextRef().getActivity());
                    CreativeSize bannerSize;
                    if (options.getContainerViewSize() != null) {
                        bannerSize = options.getContainerViewSize();
                        widthDp = bannerSize.getWidth() > 0 ? Utils.getInverseScaledSize(InMobiAdapter.this.getContextRef().getActivity(), bannerSize.getWidth()) : bannerSize.getWidth();
                        heightDp = bannerSize.getHeight() > 0 ? Utils.getInverseScaledSize(InMobiAdapter.this.getContextRef().getActivity(), bannerSize.getHeight()) : bannerSize.getHeight();
                    } else {
                        bannerSize = options.getGenericBannerSize();
                        widthDp = bannerSize.getWidth();
                        heightDp = bannerSize.getHeight();
                    }
                    if (widthDp == -1) {
                        widthPx = InMobiAdapter.this.getContextRef().getActivity().getWindow().getDecorView().getWidth();
                    } else {
                        widthPx = Utils.getScaledSize(InMobiAdapter.this.getContextRef().getActivity(), widthDp);
                    }
                    if (heightDp == -2 || heightDp == -1) {
                        int windowDp = Utils.getInverseScaledSize(InMobiAdapter.this.getContextRef().getActivity(), InMobiAdapter.this.getContextRef().getActivity().getWindow().getDecorView().getHeight());
                        if (windowDp <= 400) {
                            heightDp = 32;
                        } else if (windowDp <= 720) {
                            heightDp = 50;
                        } else if (Utils.isTablet(InMobiAdapter.this.getContextRef().getActivity())) {
                            heightDp = 90;
                        } else {
                            heightDp = 50;
                        }
                    }
                    LayoutParams params = new LayoutParams(widthPx, Utils.getScaledSize(InMobiAdapter.this.getContextRef().getActivity(), heightDp));
                    params.addRule(12);
                    params.addRule(14);
                    bannerFrame.addView(banner, params);
                    InMobiBannerListener listener = new InMobiBannerListener(bannerFrame, banner);
                    banner.setListener(listener);
                    EventStream.bind(listener.adDisplay.clickEventStream, display.clickEventStream, InMobiAdapter.this.executorService);
                    EventStream.bind(listener.adDisplay.displayEventStream, display.displayEventStream, InMobiAdapter.this.executorService);
                    banner.load();
                } catch (Exception e) {
                    Logger.error("error in inmobi banner creation", e);
                }
            }
        });
        return display;
    }

    private FetchFailure failureForStatus(InMobiAdRequestStatus status) {
        switch (C15765.$SwitchMap$com$inmobi$ads$InMobiAdRequestStatus$StatusCode[status.getStatusCode().ordinal()]) {
            case 1:
                return new FetchFailure(FetchFailureReason.NO_FILL, status.getMessage());
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new FetchFailure(FetchFailureReason.NETWORK_ERROR, status.getMessage());
            case 7:
                return new FetchFailure(FetchFailureReason.REMOTE_ERROR, status.getMessage());
            case 8:
            case 9:
            case 10:
                return new FetchFailure(FetchFailureReason.INTERNAL, status.getMessage());
            default:
                return new FetchFailure(FetchFailureReason.UNKNOWN, status.getMessage());
        }
    }
}
