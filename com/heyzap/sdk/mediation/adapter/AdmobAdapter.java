package com.heyzap.sdk.mediation.adapter;

import android.content.Context;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.common.banner.BannerWrapper.OnSizeChangeListener;
import com.heyzap.common.concurrency.FutureUtils;
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
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.CachedAd.ExpiryListener;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.DisplayableFetchResult;
import com.heyzap.mediation.abstr.NativeNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.CreativeSize;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import com.heyzap.sdk.ads.NativeAd;
import com.heyzap.sdk.ads.NativeAd.Image;
import com.heyzap.sdk.ads.NativeAd.NativeAdWrapper;
import com.heyzap.sdk.ads.NativeAdResult;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class AdmobAdapter extends FetchBackedNetworkAdapter implements NativeNetworkAdapter {
    private String adUnitId;
    protected String bannerAdUnitId;
    private AdMobBannerAd cachedBannerAd;
    private EnumSet<AdUnit> enabledAdUnits = EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.BANNER, AdUnit.NATIVE);
    private String nativeAdUnitId;
    private NetworkProperties properties;
    private String videoAdUnitId;

    public static class NetworkProperties {
        public String canonicalName;
        public boolean doesPerNetworkFetch;
        public String marketingName;
        public String marketingVersion;
    }

    class C15191 extends NetworkProperties {
        C15191() {
            this.marketingName = "AdMob";
            this.marketingVersion = AdRequest.VERSION;
            this.canonicalName = Network.ADMOB;
            this.doesPerNetworkFetch = false;
        }
    }

    private class AdMobBannerAd implements CachedAd {
        private final AdMobBannerWrapper adMobBannerWrapper;

        private AdMobBannerAd(AdMobBannerWrapper adMobBannerWrapper) {
            this.adMobBannerWrapper = adMobBannerWrapper;
        }

        public AdDisplay show(final MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            AdDisplay display = new AdDisplay();
            display.displayEventStream = this.adMobBannerWrapper.displayEventStream;
            display.clickEventStream = this.adMobBannerWrapper.clickEventStream;
            AdmobAdapter.this.uiThreadExecutorService.submit(new Runnable() {
                public void run() {
                    AdView bannerView = new AdView(AdmobAdapter.this.getContextRef().getActivity());
                    bannerView.setAdSize(AdmobAdapter.getAdSize(mediationRequest.getBannerOptions().getAdmobBannerSize()));
                    bannerView.setBackgroundColor(0);
                    bannerView.setAdUnitId(AdmobAdapter.this.bannerAdUnitId);
                    bannerView.setAdListener(new AdmobBannerListener(AdMobBannerAd.this.adMobBannerWrapper, AdmobAdapter.this));
                    bannerView.loadAd(AdmobAdapter.this.getNewAdRequestBuilder().build());
                    AdMobBannerAd.this.adMobBannerWrapper.realBannerView = bannerView;
                }
            });
            return display;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    private static class AdMobBannerWrapper implements BannerWrapper {
        public EventStream<Boolean> clickEventStream;
        public SettableFuture<Boolean> closeListener;
        private final Context context;
        public EventStream<DisplayResult> displayEventStream;
        public SettableFuture<Boolean> incentiveListener;
        public final InterstitialAd interstitialAd;
        public AdView realBannerView;

        public AdMobBannerWrapper(Context context, InterstitialAd interstitialAd) {
            this.context = context;
            this.interstitialAd = interstitialAd;
            resetEventFutures();
        }

        public View getRealBannerView() {
            return this.realBannerView;
        }

        public int getAdHeight() {
            return this.realBannerView.getAdSize().getHeightInPixels(this.context);
        }

        public int getAdWidth() {
            return this.realBannerView.getAdSize().getWidthInPixels(this.context);
        }

        public void resetEventFutures() {
            this.displayEventStream = EventStream.create();
            this.closeListener = SettableFuture.create();
            this.clickEventStream = EventStream.create();
            this.incentiveListener = SettableFuture.create();
        }

        public boolean destroyBanner(boolean permaDeath) {
            if (this.realBannerView == null) {
                return false;
            }
            this.realBannerView.destroy();
            this.realBannerView = null;
            resetEventFutures();
            return true;
        }

        public void setSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        }
    }

    private class AdMobCachedAd implements CachedAd {
        private final AdMobBannerWrapper adMobBannerWrapper;

        private AdMobCachedAd(AdMobBannerWrapper adMobBannerWrapper) {
            this.adMobBannerWrapper = adMobBannerWrapper;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            final AdDisplay display = new AdDisplay();
            if (this.adMobBannerWrapper.interstitialAd == null) {
                display.displayEventStream = EventStream.create();
                display.displayEventStream.sendEvent(DisplayResult.NOT_READY);
            } else {
                display.displayEventStream = this.adMobBannerWrapper.displayEventStream;
                display.clickEventStream = this.adMobBannerWrapper.clickEventStream;
                display.closeListener = this.adMobBannerWrapper.closeListener;
                display.incentiveListener = this.adMobBannerWrapper.incentiveListener;
                AdmobAdapter.this.uiThreadExecutorService.execute(new Runnable() {
                    public void run() {
                        if (AdMobCachedAd.this.adMobBannerWrapper.interstitialAd.isLoaded()) {
                            AdMobCachedAd.this.adMobBannerWrapper.interstitialAd.show();
                            return;
                        }
                        display.displayEventStream = EventStream.create();
                        display.displayEventStream.sendEvent(DisplayResult.NOT_READY);
                    }
                });
            }
            return display;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    private class AdmobAppInstallNativeAdResult extends NativeAdResult {
        NativeAppInstallAd ad;

        public AdmobAppInstallNativeAdResult(NativeAppInstallAd ad) {
            this.ad = ad;
        }

        public String getTitle() {
            return null;
        }

        public Image getIcon() {
            return null;
        }

        public Image getCoverImage() {
            return null;
        }

        public String getBody() {
            return null;
        }

        public String getCallToAction() {
            return null;
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
        }

        public void onImpression() {
        }

        public void registerView(View view) {
        }

        public FetchFailure getFetchFailure() {
            return null;
        }
    }

    private class AdmobBannerListener extends AdListener {
        NetworkAdapter adapter;
        AdMobBannerWrapper wrapper;

        public AdmobBannerListener(AdMobBannerWrapper wrapper, NetworkAdapter adapter) {
            this.wrapper = wrapper;
            this.adapter = adapter;
        }

        public void onAdLoaded() {
            Logger.log("Admob onAdLoaded");
            this.adapter.onCallbackEvent(NetworkCallback.BANNER_LOADED);
            DisplayResult displayResult = new DisplayResult();
            displayResult.bannerWrapper = this.wrapper;
            new FetchResult().success = true;
            this.wrapper.displayEventStream.sendEvent(displayResult);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.adapter.onCallbackEvent(NetworkCallback.BANNER_FETCH_FAILED);
            FetchFailure fetchFailure = AdmobAdapter.getFetchFailure(errorCode);
            this.wrapper.displayEventStream.sendEvent(new DisplayResult(fetchFailure.getMessage(), fetchFailure.getErrorType()));
        }

        public void onAdOpened() {
            this.adapter.onCallbackEvent(NetworkCallback.BANNER_CLICK);
            this.wrapper.clickEventStream.sendEvent(Boolean.valueOf(true));
        }
    }

    private class AdmobContentAdNativeAdResult extends NativeAdResult {
        NativeContentAd ad;

        public AdmobContentAdNativeAdResult(NativeContentAd ad) {
            this.ad = ad;
        }

        public String getTitle() {
            return null;
        }

        public Image getIcon() {
            return null;
        }

        public Image getCoverImage() {
            return null;
        }

        public String getBody() {
            return null;
        }

        public String getCallToAction() {
            return null;
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
        }

        public void onImpression() {
        }

        public void registerView(View view) {
        }

        public FetchFailure getFetchFailure() {
            return null;
        }
    }

    private class AdmobInterstitialListener extends AdListener {
        NetworkAdapter adapter;
        final SettableFuture<DisplayableFetchResult> fetchFuture = SettableFuture.create();
        AdMobBannerWrapper wrapper;

        public AdmobInterstitialListener(AdMobBannerWrapper wrapper, NetworkAdapter adapter) {
            this.wrapper = wrapper;
            this.adapter = adapter;
        }

        public SettableFuture<DisplayableFetchResult> getFetchFuture() {
            return this.fetchFuture;
        }

        public void onAdLoaded() {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            this.fetchFuture.set(new DisplayableFetchResult(new AdMobCachedAd(this.wrapper)));
        }

        public void onAdFailedToLoad(int errorCode) {
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            this.fetchFuture.set(new DisplayableFetchResult(AdmobAdapter.getFetchFailure(errorCode)));
        }

        public void onAdOpened() {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            this.wrapper.displayEventStream.sendEvent(new DisplayResult());
        }

        public void onAdClosed() {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
            this.wrapper.closeListener.set(Boolean.valueOf(true));
        }

        public void onAdLeftApplication() {
            this.adapter.onCallbackEvent("click");
            this.wrapper.clickEventStream.sendEvent(Boolean.valueOf(true));
        }
    }

    private class AdmobNativeListener extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener {
        private AdmobAdapter admobAdapter;
        private FetchResult fetchResult;
        private NativeAdWrapper nativeAdWrapper;

        public AdmobNativeListener(NativeAdWrapper nativeAdWrapper, AdmobAdapter admobAdapter) {
            this.nativeAdWrapper = nativeAdWrapper;
            this.admobAdapter = admobAdapter;
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.fetchResult = new FetchResult();
            this.fetchResult.setNativeAdResult(new AdmobAppInstallNativeAdResult(nativeAppInstallAd));
            this.fetchResult.success = true;
            this.nativeAdWrapper.fetchListener.set(this.fetchResult);
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.fetchResult = new FetchResult();
            this.fetchResult.setNativeAdResult(new AdmobContentAdNativeAdResult(nativeContentAd));
            this.fetchResult.success = true;
            this.nativeAdWrapper.fetchListener.set(this.fetchResult);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.nativeAdWrapper.fetchListener.set(new FetchResult(AdmobAdapter.getFetchFailure(errorCode)));
        }

        public void onAdOpened() {
            this.nativeAdWrapper.clickEventListener.sendEvent(Boolean.valueOf(true));
            if (this.fetchResult != null) {
                this.fetchResult.getNativeAdResult().clickEventStream.sendEvent(Boolean.valueOf(true));
            }
        }
    }

    public Boolean isOnBoard() {
        return Utils.classExists("com.google.android.gms.ads.InterstitialAd");
    }

    public NetworkProperties getProperties() {
        if (this.properties == null) {
            this.properties = new C15191();
        }
        return this.properties;
    }

    public String getMarketingName() {
        return "AdMob";
    }

    public String getMarketingVersion() {
        return AdRequest.VERSION;
    }

    public String getCanonicalName() {
        return Network.ADMOB;
    }

    public void onInit() throws ConfigurationError {
        this.adUnitId = getConfiguration().getValue("ad_unit_id");
        this.videoAdUnitId = getConfiguration().getValue("video_ad_unit_id");
        if (this.adUnitId == null || this.adUnitId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.INTERSTITIAL);
        }
        if (this.videoAdUnitId == null || this.videoAdUnitId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.VIDEO);
        }
        this.bannerAdUnitId = getConfiguration().getValue("banner_ad_unit_id");
        if (this.bannerAdUnitId == null || this.bannerAdUnitId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.BANNER);
        } else {
            start(FetchOptions.builder(Network.ADMOB, CreativeType.BANNER, AuctionType.MONETIZATION).setAdUnit(LargeSet.of(AdUnit.BANNER)).build());
        }
        this.nativeAdUnitId = getConfiguration().getValue("native_ad_unit_id");
        if (Utils.isDebug(getContextRef().getActivity()).booleanValue()) {
            this.nativeAdUnitId = "ca-app-pub-3940256099942544/2247696110";
        }
        if (this.nativeAdUnitId == null || this.nativeAdUnitId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.NATIVE);
        }
    }

    protected void onStart() {
    }

    protected SettableFuture<DisplayableFetchResult> fetch(FetchOptions fetchOptions) {
        final SettableFuture<DisplayableFetchResult> resultFuture = SettableFuture.create();
        if (getContextRef().getActivity() != null) {
            switch (fetchOptions.getCreativeType()) {
                case BANNER:
                    if (this.cachedBannerAd == null) {
                        this.cachedBannerAd = new AdMobBannerAd(new AdMobBannerWrapper(getContextRef().getApp(), null));
                    }
                    resultFuture.set(new DisplayableFetchResult(this.cachedBannerAd));
                    break;
                case STATIC:
                case VIDEO:
                    String customPlacementId = fetchOptions.getCustomPlacementId();
                    String placementId = customPlacementId != null ? customPlacementId : fetchOptions.getCreativeType() == CreativeType.STATIC ? this.adUnitId : this.videoAdUnitId;
                    if (placementId != null) {
                        this.uiThreadExecutorService.submit(new Runnable() {
                            public void run() {
                                InterstitialAd ad = new InterstitialAd(AdmobAdapter.this.getContextRef().getActivity());
                                ad.setAdUnitId(placementId);
                                AdmobInterstitialListener listener = new AdmobInterstitialListener(new AdMobBannerWrapper(AdmobAdapter.this.getContextRef().getApp(), ad), AdmobAdapter.this);
                                ad.setAdListener(listener);
                                ad.loadAd(AdmobAdapter.this.getNewAdRequestBuilder().build());
                                FutureUtils.bind(listener.getFetchFuture(), resultFuture, AdmobAdapter.this.executorService);
                            }
                        });
                        break;
                    }
                    resultFuture.set(new DisplayableFetchResult(new FetchFailure(FetchFailureReason.CONFIGURATION_ERROR, "no placement id for creative type " + fetchOptions.getCreativeType().toString())));
                    break;
                default:
                    resultFuture.set(new DisplayableFetchResult(new FetchFailure(FetchFailureReason.CONFIGURATION_ERROR, "unsupported creative type")));
                    break;
            }
        }
        resultFuture.set(new DisplayableFetchResult(new FetchFailure(FetchFailureReason.CONFIGURATION_ERROR, "No Activity")));
        return resultFuture;
    }

    @NonNull
    private Builder getNewAdRequestBuilder() {
        Builder adRequestBuilder = new Builder();
        if (Utils.isDebug(getContextRef().getActivity()).booleanValue()) {
            adRequestBuilder.addTestDevice(Utils.md5(Secure.getString(getContextRef().getActivity().getContentResolver(), "android_id")).toUpperCase());
        }
        adRequestBuilder.setRequestAgent("Heyzap");
        String coppa = getConfiguration().getValue("coppa_enabled");
        if ((this.adsConfig.flags & 64) != 0 || (coppa != null && coppa.equals("enabled"))) {
            adRequestBuilder.tagForChildDirectedTreatment(true);
        }
        if (this.locationProvider.getLocation() != null) {
            adRequestBuilder.setLocation(this.locationProvider.getLocation());
        }
        return adRequestBuilder;
    }

    public NativeAdWrapper fetchNative(FetchOptions options) {
        NativeAdOptions.Builder optionsBuilder;
        NativeAdWrapper nativeAdWrapper = new NativeAdWrapper();
        AdmobNativeListener admobNativeListener = new AdmobNativeListener(nativeAdWrapper, this);
        String placementId = options.getCustomPlacementId() != null ? options.getCustomPlacementId() : this.nativeAdUnitId;
        NativeAd.NativeAdOptions nativeAdOptions = options.getNativeAdOptions();
        AdLoader.Builder adLoaderBuilder = new AdLoader.Builder(getContextRef().getApp(), placementId).withAdListener(admobNativeListener);
        if (nativeAdOptions.isAdMobAppInstallAdsEnabled()) {
            adLoaderBuilder = adLoaderBuilder.forAppInstallAd(admobNativeListener);
        }
        if (nativeAdOptions.isAdMobContentAdsEnabled()) {
            adLoaderBuilder = adLoaderBuilder.forContentAd(admobNativeListener);
        }
        if (nativeAdOptions.getAdMobNativeAdOptionsBuilder() != null) {
            optionsBuilder = nativeAdOptions.getAdMobNativeAdOptionsBuilder();
        } else {
            optionsBuilder = new NativeAdOptions.Builder();
        }
        final AdLoader adLoader = adLoaderBuilder.withNativeAdOptions(optionsBuilder.build()).build();
        this.uiThreadExecutorService.submit(new Runnable() {
            public void run() {
                adLoader.loadAd(AdmobAdapter.this.getNewAdRequestBuilder().build());
            }
        });
        return nativeAdWrapper;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.BANNER, AdUnit.NATIVE);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return this.enabledAdUnits;
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case BANNER:
                return EnumSet.of(AdUnit.BANNER);
            case STATIC:
                return EnumSet.of(AdUnit.INTERSTITIAL);
            case VIDEO:
                return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
            case NATIVE:
                return EnumSet.of(AdUnit.NATIVE);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    private static AdSize getAdSize(CreativeSize size) {
        if (size.equals(CreativeSize.BANNER) || size.equals(CreativeSize.BANNER_320_50) || size.equals(CreativeSize.BANNER_HEIGHT_50)) {
            return AdSize.BANNER;
        }
        if (size.equals(CreativeSize.FULL_BANNER)) {
            return AdSize.FULL_BANNER;
        }
        if (size.equals(CreativeSize.LARGE_BANNER) || size.equals(CreativeSize.BANNER_HEIGHT_90)) {
            return AdSize.LARGE_BANNER;
        }
        if (size.equals(CreativeSize.MEDIUM_RECTANGLE) || size.equals(CreativeSize.BANNER_RECTANGLE_250)) {
            return AdSize.MEDIUM_RECTANGLE;
        }
        if (size.equals(CreativeSize.LEADERBOARD)) {
            return AdSize.LEADERBOARD;
        }
        if (size.equals(CreativeSize.WIDE_SKYSCRAPER)) {
            return AdSize.WIDE_SKYSCRAPER;
        }
        if (size.equals(CreativeSize.SMART_BANNER)) {
            return AdSize.SMART_BANNER;
        }
        return AdSize.BANNER;
    }

    private static FetchFailure getFetchFailure(int errorCode) {
        String message;
        FetchFailureReason reason;
        switch (errorCode) {
            case 0:
                message = "INTERNAL_ERROR";
                reason = FetchFailureReason.INTERNAL;
                break;
            case 1:
                message = "INVALID_REQUEST";
                reason = FetchFailureReason.CONFIGURATION_ERROR;
                break;
            case 2:
                message = "NETWORK_ERROR";
                reason = FetchFailureReason.NETWORK_ERROR;
                break;
            case 3:
                message = "NO_FILL";
                reason = FetchFailureReason.NO_FILL;
                break;
            default:
                message = "UNKNOWN";
                reason = FetchFailureReason.UNKNOWN;
                break;
        }
        return new FetchFailure(reason, message);
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{AdActivity.CLASS_NAME});
    }

    public boolean onBackPressed() {
        return false;
    }
}
