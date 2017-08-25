package com.heyzap.sdk.mediation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.common.banner.BannerWrapper.OnSizeChangeListener;
import com.heyzap.common.concurrency.ExecutorPool;
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
import com.heyzap.mediation.abstr.BannerNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.CachedAd.ExpiryListener;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.DisplayableFetchResult;
import com.heyzap.mediation.abstr.NativeNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import com.heyzap.sdk.ads.HeyzapAds.CreativeSize;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import com.heyzap.sdk.ads.NativeAd.Image;
import com.heyzap.sdk.ads.NativeAd.NativeAdWrapper;
import com.heyzap.sdk.ads.NativeAdResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FacebookAdapter extends FetchBackedNetworkAdapter implements NativeNetworkAdapter, BannerNetworkAdapter {
    private String bannerPlacementId;
    private FacebookCachedBanner cachedBanner = null;
    private boolean coppaEnabled;
    private final EnumSet<AdUnit> enabledAdUnits = EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.BANNER, AdUnit.NATIVE, AdUnit.INCENTIVIZED);
    private String nativePlacementId;
    private String placementId;
    private String rewardedPlacementId;
    private Boolean rewardedVideoEnabled = null;

    private class FacebookAdWrapper {
        public final EventStream<Boolean> clickEventListener;
        public final SettableFuture<Boolean> closeListener;
        public final EventStream<DisplayResult> displayEventStream;
        public final SettableFuture<DisplayableFetchResult> fetchListener;
        public final SettableFuture<Boolean> incentiveListener;

        private FacebookAdWrapper() {
            this.fetchListener = SettableFuture.create();
            this.displayEventStream = EventStream.create();
            this.closeListener = SettableFuture.create();
            this.clickEventListener = EventStream.create();
            this.incentiveListener = SettableFuture.create();
        }
    }

    private class FacebookBannerListener implements AdListener {
        final NetworkAdapter adapter;
        final FacebookBannerWrapper wrapper;

        public FacebookBannerListener(FacebookBannerWrapper wrapper, NetworkAdapter adapter) {
            this.wrapper = wrapper;
            this.adapter = adapter;
        }

        public void onAdClicked(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.BANNER_CLICK);
            this.wrapper.clickEventListener.sendEvent(Boolean.valueOf(true));
        }

        public void onLoggingImpression(Ad ad) {
            this.adapter.onCallbackEvent(NetworkCallback.FACEBOOK_LOGGING_IMPRESSION);
        }

        public void onAdLoaded(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.BANNER_LOADED);
            DisplayResult displayResult = new DisplayResult();
            displayResult.bannerWrapper = this.wrapper;
            this.wrapper.displayEventStream.sendEvent(displayResult);
        }

        public void onError(Ad arg0, AdError adError) {
            this.adapter.onCallbackEvent(NetworkCallback.BANNER_FETCH_FAILED);
            this.wrapper.displayEventStream.sendEvent(new DisplayResult(adError.getErrorMessage(), FacebookAdapter.this.getFetchFailureReason(adError)));
        }
    }

    private class FacebookBannerWrapper extends FacebookAdWrapper implements BannerWrapper {
        public AdView fbAdView;
        public View realBannerView;

        private FacebookBannerWrapper() {
            super();
        }

        public View getRealBannerView() {
            return this.realBannerView;
        }

        public int getAdHeight() {
            return this.fbAdView.getLayoutParams().height;
        }

        public int getAdWidth() {
            return this.fbAdView.getLayoutParams().width;
        }

        public boolean destroyBanner(boolean permaDeath) {
            FacebookAdapter.this.cachedBanner = null;
            if (this.fbAdView == null) {
                return false;
            }
            this.fbAdView.setAdListener(null);
            this.fbAdView.destroy();
            this.fbAdView = null;
            this.realBannerView = null;
            return true;
        }

        public void setSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        }
    }

    public abstract class FacebookCachedAd implements CachedAd {
        private final FacebookAdWrapper facebookAdWrapper;

        protected abstract boolean isReady();

        protected abstract void show();

        public FacebookCachedAd(FacebookAdWrapper facebookAdWrapper) {
            this.facebookAdWrapper = facebookAdWrapper;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            AdDisplay display = new AdDisplay();
            if (isReady()) {
                display.displayEventStream = this.facebookAdWrapper.displayEventStream;
                display.clickEventStream = this.facebookAdWrapper.clickEventListener;
                display.closeListener = this.facebookAdWrapper.closeListener;
                display.incentiveListener = this.facebookAdWrapper.incentiveListener;
                show();
            } else {
                display.displayEventStream = EventStream.create();
                display.displayEventStream.sendEvent(DisplayResult.NOT_READY);
            }
            return display;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    public class FacebookCachedBanner implements CachedAd {
        private final FacebookBannerWrapper wrapper;

        public FacebookCachedBanner(FacebookBannerWrapper wrapper) {
            this.wrapper = wrapper;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            return FacebookAdapter.this.fetchAndShowBanner(mediationRequest.getBannerOptions());
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    public class FacebookCachedInterstitialAd extends FacebookCachedAd {
        private final FacebookInterstitialWrapper interstitialWrapper;

        public FacebookCachedInterstitialAd(FacebookInterstitialWrapper facebookAdWrapper) {
            super(facebookAdWrapper);
            this.interstitialWrapper = facebookAdWrapper;
        }

        protected boolean isReady() {
            return this.interstitialWrapper.interstitialAd != null && this.interstitialWrapper.interstitialAd.isAdLoaded();
        }

        protected void show() {
            Logger.log("FacebookCachedInterstitialAd - show()");
            this.interstitialWrapper.interstitialAd.show();
        }
    }

    public class FacebookCachedRewardedVideoAd extends FacebookCachedAd {
        private final FacebookRewardedVideoWrapper rewardedVideoWrapper;

        public FacebookCachedRewardedVideoAd(FacebookRewardedVideoWrapper facebookAdWrapper) {
            super(facebookAdWrapper);
            this.rewardedVideoWrapper = facebookAdWrapper;
        }

        protected boolean isReady() {
            return this.rewardedVideoWrapper.rewardedVideoAd != null && this.rewardedVideoWrapper.rewardedVideoAd.isAdLoaded();
        }

        protected void show() {
            Logger.log("FacebookCachedRewardedVideoAd - show");
            this.rewardedVideoWrapper.rewardedVideoAd.show();
        }
    }

    private class FacebookInterstitialListener implements InterstitialAdListener {
        private final FacebookAdapter adapter;
        private final FacebookInterstitialWrapper wrapper;

        public FacebookInterstitialListener(FacebookInterstitialWrapper wrapper, FacebookAdapter adapter) {
            this.wrapper = wrapper;
            this.adapter = adapter;
        }

        public void onAdClicked(Ad arg0) {
            this.adapter.onCallbackEvent("click");
            this.wrapper.clickEventListener.sendEvent(Boolean.valueOf(true));
        }

        public void onAdLoaded(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            this.wrapper.fetchListener.set(new DisplayableFetchResult(new FacebookCachedInterstitialAd(this.wrapper)));
        }

        public void onError(Ad arg0, AdError error) {
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            this.wrapper.fetchListener.set(new DisplayableFetchResult(new FetchFailure(FacebookAdapter.this.getFetchFailureReason(error), error.getErrorMessage())));
        }

        public void onLoggingImpression(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.FACEBOOK_LOGGING_IMPRESSION);
        }

        public void onInterstitialDismissed(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
            this.wrapper.closeListener.set(Boolean.valueOf(true));
        }

        public void onInterstitialDisplayed(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            this.wrapper.displayEventStream.sendEvent(new DisplayResult());
        }
    }

    private class FacebookInterstitialWrapper extends FacebookAdWrapper {
        public InterstitialAd interstitialAd;

        private FacebookInterstitialWrapper() {
            super();
        }
    }

    private class FacebookNativeAdResult extends NativeAdResult implements CachedAd {
        final NativeAd facebookNativeAd;
        private OnClickListener onClickListener = null;
        private ViewTrick viewTrick;

        class C15491 implements Image {
            C15491() {
            }

            public int getWidth() {
                return FacebookNativeAdResult.this.facebookNativeAd.getAdIcon().getWidth();
            }

            public String getUrl() {
                try {
                    return FacebookNativeAdResult.this.facebookNativeAd.getAdIcon().getUrl();
                } catch (Exception e) {
                    return "";
                }
            }

            public int getHeight() {
                return FacebookNativeAdResult.this.facebookNativeAd.getAdIcon().getHeight();
            }
        }

        class C15502 implements Image {
            C15502() {
            }

            public int getWidth() {
                return FacebookNativeAdResult.this.facebookNativeAd.getAdCoverImage().getWidth();
            }

            public String getUrl() {
                try {
                    return FacebookNativeAdResult.this.facebookNativeAd.getAdCoverImage().getUrl();
                } catch (Exception e) {
                    return "";
                }
            }

            public int getHeight() {
                return FacebookNativeAdResult.this.facebookNativeAd.getAdCoverImage().getHeight();
            }
        }

        class C15513 implements Image {
            C15513() {
            }

            public int getHeight() {
                return FacebookNativeAdResult.this.facebookNativeAd.getAdChoicesIcon().getHeight();
            }

            public int getWidth() {
                return FacebookNativeAdResult.this.facebookNativeAd.getAdChoicesIcon().getWidth();
            }

            public String getUrl() {
                try {
                    return FacebookNativeAdResult.this.facebookNativeAd.getAdChoicesIcon().getUrl();
                } catch (Exception e) {
                    return "";
                }
            }
        }

        public FacebookNativeAdResult(NativeAd facebookNativeAd) {
            this.facebookNativeAd = facebookNativeAd;
        }

        public void registerView(View viewFromDev) {
            if (this.onClickListener == null) {
                this.viewTrick = new ViewTrick(viewFromDev.getContext());
                this.facebookNativeAd.registerViewForInteraction(this.viewTrick);
                this.onClickListener = this.viewTrick.listener;
            }
            View dummyView = new View(viewFromDev.getContext());
            ArrayList<View> clickableViews = new ArrayList();
            clickableViews.add(dummyView);
            this.facebookNativeAd.registerViewForInteraction(viewFromDev, clickableViews);
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }

        public String getTitle() {
            return this.facebookNativeAd.getAdTitle();
        }

        public Image getIcon() {
            return new C15491();
        }

        public Image getCoverImage() {
            return new C15502();
        }

        public String getBody() {
            return this.facebookNativeAd.getAdBody();
        }

        public void onClick(View view) {
            if (this.onClickListener != null) {
                this.onClickListener.onClick(view);
            }
        }

        public void onImpression() {
        }

        public FetchFailure getFetchFailure() {
            return null;
        }

        public String getCallToAction() {
            return this.facebookNativeAd.getAdCallToAction();
        }

        public String getSocialContext() {
            return this.facebookNativeAd.getAdSocialContext();
        }

        public Image getAdChoicesImage() {
            return new C15513();
        }

        public String getAdChoicesUrl() {
            return this.facebookNativeAd.getAdChoicesLinkUrl();
        }

        public Object getNativeAdObject() {
            return this.facebookNativeAd;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            return null;
        }
    }

    private class FacebookNativeListener implements AdListener {
        private final NetworkAdapter adapter;
        final NativeAdWrapper nativeAdWrapper;

        public FacebookNativeListener(NativeAdWrapper nativeAdWrapper, NetworkAdapter adapter) {
            this.nativeAdWrapper = nativeAdWrapper;
            this.adapter = adapter;
        }

        public void onAdClicked(Ad arg0) {
            this.nativeAdWrapper.clickEventListener.sendEvent(Boolean.valueOf(true));
        }

        public void onLoggingImpression(Ad ad) {
            this.adapter.onCallbackEvent(NetworkCallback.FACEBOOK_LOGGING_IMPRESSION);
        }

        public void onAdLoaded(Ad ad) {
            if (ad == this.nativeAdWrapper.nativeAdObject) {
                NativeAd facebookNativeAd = (NativeAd) ad;
                FetchResult fetchResult = new FetchResult();
                fetchResult.setNativeAdResult(new FacebookNativeAdResult(facebookNativeAd));
                fetchResult.success = true;
                this.nativeAdWrapper.fetchListener.set(fetchResult);
            }
        }

        public void onError(Ad arg0, AdError adError) {
            this.nativeAdWrapper.fetchListener.set(new FetchResult(FacebookAdapter.this.getFetchFailureReason(adError), adError.getErrorMessage()));
        }
    }

    private class FacebookRewardedVideoListener implements RewardedVideoAdListener {
        private final FacebookAdapter adapter;
        private final FacebookRewardedVideoWrapper wrapper;

        class C15521 implements Runnable {
            C15521() {
            }

            public void run() {
                FacebookRewardedVideoListener.this.wrapper.incentiveListener.set(Boolean.valueOf(false));
            }
        }

        public FacebookRewardedVideoListener(FacebookRewardedVideoWrapper wrapper, FacebookAdapter adapter) {
            this.wrapper = wrapper;
            this.adapter = adapter;
        }

        public void onAdClicked(Ad arg0) {
            this.adapter.onCallbackEvent("click");
            this.wrapper.clickEventListener.sendEvent(Boolean.valueOf(true));
        }

        public void onAdLoaded(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            this.wrapper.fetchListener.set(new DisplayableFetchResult(new FacebookCachedRewardedVideoAd(this.wrapper)));
        }

        public void onError(Ad arg0, AdError error) {
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            this.wrapper.fetchListener.set(new DisplayableFetchResult(new FetchFailure(FacebookAdapter.this.getFetchFailureReason(error), error.getErrorMessage())));
        }

        public void onRewardedVideoCompleted() {
            this.wrapper.incentiveListener.set(Boolean.valueOf(true));
        }

        public void onLoggingImpression(Ad arg0) {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            this.wrapper.displayEventStream.sendEvent(new DisplayResult());
            this.adapter.onCallbackEvent(NetworkCallback.FACEBOOK_LOGGING_IMPRESSION);
        }

        public void onRewardedVideoClosed() {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
            if (this.wrapper.displayEventStream.getEventsCount() == 0) {
                this.wrapper.displayEventStream.sendEvent(new DisplayResult());
            }
            this.wrapper.closeListener.set(Boolean.valueOf(true));
            ExecutorPool.getInstance().schedule(new C15521(), 3, TimeUnit.SECONDS);
        }
    }

    private class FacebookRewardedVideoWrapper extends FacebookAdWrapper {
        public RewardedVideoAd rewardedVideoAd;

        private FacebookRewardedVideoWrapper() {
            super();
        }
    }

    private static class ViewTrick extends View {
        public OnClickListener listener;

        public ViewTrick(Context context) {
            super(context);
        }

        public void setOnClickListener(OnClickListener listener) {
            this.listener = listener;
        }
    }

    public Boolean isOnBoard() {
        return Utils.classExists("com.facebook.ads.InterstitialAd");
    }

    public String getMarketingName() {
        return "Facebook";
    }

    public String getMarketingVersion() {
        return "4.22.0";
    }

    public String getCanonicalName() {
        return Network.FACEBOOK;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        if (this.rewardedVideoEnabled == null) {
            this.rewardedVideoEnabled = Utils.classExists("com.facebook.ads.RewardedVideoAd");
        }
        if (this.rewardedVideoEnabled.booleanValue()) {
            return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.BANNER, AdUnit.NATIVE, AdUnit.INCENTIVIZED);
        }
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.BANNER, AdUnit.NATIVE);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return this.enabledAdUnits;
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case STATIC:
                return EnumSet.of(AdUnit.INTERSTITIAL);
            case BANNER:
                return EnumSet.of(AdUnit.BANNER);
            case NATIVE:
                return EnumSet.of(AdUnit.NATIVE);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    protected SettableFuture<DisplayableFetchResult> fetch(final FetchOptions fetchOptions) {
        final SettableFuture<DisplayableFetchResult> fetchResult = SettableFuture.create();
        switch (fetchOptions.getCreativeType()) {
            case BANNER:
                if (this.cachedBanner == null) {
                    this.cachedBanner = new FacebookCachedBanner(new FacebookBannerWrapper());
                }
                fetchResult.set(new DisplayableFetchResult(this.cachedBanner));
                break;
            case INCENTIVIZED:
                this.uiThreadExecutorService.submit(new Runnable() {
                    public void run() {
                        String placementId = fetchOptions.getCustomPlacementId();
                        if (placementId == null) {
                            placementId = FacebookAdapter.this.rewardedPlacementId;
                        }
                        FacebookRewardedVideoWrapper localWrapper = new FacebookRewardedVideoWrapper();
                        RewardedVideoAd ad = new RewardedVideoAd(FacebookAdapter.this.getContextRef().getActivity(), placementId);
                        localWrapper.rewardedVideoAd = ad;
                        ad.setAdListener(new FacebookRewardedVideoListener(localWrapper, FacebookAdapter.this));
                        ad.loadAd();
                        FutureUtils.bind(localWrapper.fetchListener, fetchResult, FacebookAdapter.this.executorService);
                    }
                });
                break;
            default:
                this.uiThreadExecutorService.submit(new Runnable() {
                    public void run() {
                        String placementId = fetchOptions.getCustomPlacementId();
                        if (placementId == null) {
                            placementId = FacebookAdapter.this.placementId;
                        }
                        FacebookInterstitialWrapper localWrapper = new FacebookInterstitialWrapper();
                        InterstitialAd ad = new InterstitialAd(FacebookAdapter.this.getContextRef().getActivity(), placementId);
                        localWrapper.interstitialAd = ad;
                        ad.setAdListener(new FacebookInterstitialListener(localWrapper, FacebookAdapter.this));
                        ad.loadAd();
                        FutureUtils.bind(localWrapper.fetchListener, fetchResult, FacebookAdapter.this.executorService);
                    }
                });
                break;
        }
        return fetchResult;
    }

    public NativeAdWrapper fetchNative(FetchOptions options) {
        final NativeAdWrapper nativeAdWrapper = new NativeAdWrapper();
        final String placementId = options.getCustomPlacementId() != null ? options.getCustomPlacementId() : this.nativePlacementId;
        final NetworkAdapter adapter = this;
        this.uiThreadExecutorService.submit(new Runnable() {
            public void run() {
                NativeAd nativeAd = new NativeAd(FacebookAdapter.this.getContextRef().getApp(), placementId);
                nativeAd.setAdListener(new FacebookNativeListener(nativeAdWrapper, adapter));
                nativeAdWrapper.nativeAdObject = nativeAd;
                nativeAd.loadAd();
            }
        });
        return nativeAdWrapper;
    }

    public AdDisplay fetchAndShowBanner(BannerOptions options) {
        AdDisplay display = new AdDisplay();
        final FacebookBannerWrapper wrapper = new FacebookBannerWrapper();
        display.displayEventStream = wrapper.displayEventStream;
        display.clickEventStream = wrapper.clickEventListener;
        final CreativeSize adSize = options.getFacebookBannerSize();
        final LayoutParams params = new LayoutParams(Utils.getScaledSizeWithRelativeFlags(getContextRef().getActivity(), adSize.getWidth()), Utils.getScaledSizeWithRelativeFlags(getContextRef().getActivity(), adSize.getHeight()));
        params.gravity = 1;
        wrapper.realBannerView = new FrameLayout(getContextRef().getActivity());
        this.uiThreadExecutorService.submit(new Runnable() {
            public void run() {
                AdView adView = new AdView(FacebookAdapter.this.getContextRef().getActivity(), FacebookAdapter.this.bannerPlacementId, FacebookAdapter.getAdSize(adSize, FacebookAdapter.this.getContextRef().getApp()));
                adView.setAdListener(new FacebookBannerListener(wrapper, FacebookAdapter.this));
                ((ViewManager) wrapper.realBannerView).addView(adView, params);
                wrapper.fbAdView = adView;
                adView.loadAd();
            }
        });
        return display;
    }

    public void onInit() throws ConfigurationError {
        this.placementId = getConfiguration().getValue("placement_id");
        if (this.placementId == null || this.placementId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.INTERSTITIAL);
        }
        this.rewardedPlacementId = getConfiguration().getValue("rewarded_placement_id");
        if (this.rewardedPlacementId == null || this.rewardedPlacementId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.INCENTIVIZED);
        }
        this.bannerPlacementId = getConfiguration().getValue("banner_placement_id");
        if (this.bannerPlacementId == null || this.bannerPlacementId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.BANNER);
        }
        this.nativePlacementId = getConfiguration().getValue("native_placement_id");
        if (this.nativePlacementId == null || this.nativePlacementId.equals("")) {
            this.enabledAdUnits.remove(AdUnit.NATIVE);
        }
        this.coppaEnabled = getConfiguration().optValue("coppa_enabled", "disabled").equals("enabled");
        boolean z = this.coppaEnabled || (HeyzapAds.config.flags & 64) != 0;
        this.coppaEnabled = z;
        start(FetchOptions.builder(Network.FACEBOOK, CreativeType.BANNER, AuctionType.MONETIZATION).setAdUnit(LargeSet.of(AdUnit.BANNER)).build());
        if (Utils.isDebug(getContextRef().getActivity()).booleanValue()) {
            AdSettings.addTestDevice("2a0c65385b65c12871e6673d40017e18");
            AdSettings.addTestDevice("dfa511635c4d74b30ec70134fe25ae0f");
            AdSettings.addTestDevice("1f39479cda3ff21cb27a010840e6b457");
        }
        AdSettings.setIsChildDirected(this.coppaEnabled);
    }

    protected void onStart() {
    }

    @NonNull
    private FetchFailureReason getFetchFailureReason(AdError adError) {
        switch (adError.getErrorCode()) {
            case 1000:
                return FetchFailureReason.NETWORK_ERROR;
            case 1001:
                return FetchFailureReason.NO_FILL;
            case 1002:
                return FetchFailureReason.NO_FILL;
            case 2000:
                return FetchFailureReason.REMOTE_ERROR;
            case 2001:
                return FetchFailureReason.INTERNAL;
            default:
                return FetchFailureReason.UNKNOWN;
        }
    }

    private static AdSize getAdSize(CreativeSize size, Context context) {
        if (size.equals(CreativeSize.BANNER_320_50) || size.equals(CreativeSize.BANNER)) {
            return AdSize.BANNER_320_50;
        }
        if (size.equals(CreativeSize.BANNER_HEIGHT_50) || size.equals(CreativeSize.FULL_BANNER)) {
            return AdSize.BANNER_HEIGHT_50;
        }
        if (size.equals(CreativeSize.BANNER_HEIGHT_90) || size.equals(CreativeSize.LARGE_BANNER)) {
            return AdSize.BANNER_HEIGHT_90;
        }
        if (size.equals(CreativeSize.BANNER_RECTANGLE_250) || size.equals(CreativeSize.MEDIUM_RECTANGLE)) {
            return AdSize.RECTANGLE_HEIGHT_250;
        }
        if (!size.equals(CreativeSize.SMART_BANNER)) {
            return AdSize.BANNER_HEIGHT_50;
        }
        if (Utils.isTablet(context)) {
            return AdSize.BANNER_HEIGHT_90;
        }
        return AdSize.BANNER_HEIGHT_50;
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});
    }

    public List<String> getActivities() {
        return Collections.singletonList("com.facebook.ads.AudienceNetworkActivity");
    }

    public boolean onBackPressed() {
        return false;
    }
}
