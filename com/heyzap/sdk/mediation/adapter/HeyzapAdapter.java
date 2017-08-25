package com.heyzap.sdk.mediation.adapter;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.ImpressionOptions;
import com.heyzap.house.Manager;
import com.heyzap.house.request.AdRequest;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.CachedAd.ExpiryListener;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.DisplayableFetchResult;
import com.heyzap.mediation.abstr.NativeNetworkAdapter;
import com.heyzap.mediation.adapter.AdUnitAliasMap;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import com.heyzap.sdk.ads.HeyzapAds.OnIncentiveResultListener;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.ads.HeyzapNativeAd;
import com.heyzap.sdk.ads.HeyzapNativeAd.Ad;
import com.heyzap.sdk.ads.HeyzapNativeAd.FetchResponse;
import com.heyzap.sdk.ads.HeyzapNativeAd.OnFetchListener;
import com.heyzap.sdk.ads.NativeAd.NativeAdWrapper;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeyzapAdapter extends FetchBackedNetworkAdapter implements NativeNetworkAdapter {
    private static AuctionType AUCTION_TYPE = AuctionType.MONETIZATION;
    protected AdUnitAliasMap adUnitAliasMap = new AdUnitAliasMap();
    private AtomicBoolean initialized = new AtomicBoolean(false);

    public class AdListener implements OnStatusListener, OnIncentiveResultListener {
        private final AdDisplay adDisplay = new AdDisplay(false);
        private final AdRequest adRequest;
        private final SettableFuture<DisplayableFetchResult> fetchResultFuture = SettableFuture.create();

        public AdListener(AdRequest adRequest) {
            this.adRequest = adRequest;
            this.adDisplay.setRefetchDelay(5);
        }

        public AdDisplay getAdDisplay() {
            return this.adDisplay;
        }

        public SettableFuture<DisplayableFetchResult> getFetchResultFuture() {
            return this.fetchResultFuture;
        }

        public void onComplete(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_COMPLETE);
            this.adDisplay.incentiveListener.set(Boolean.valueOf(true));
        }

        public void onIncomplete(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
            this.adDisplay.incentiveListener.set(Boolean.valueOf(false));
        }

        public void onShow(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.SHOW);
            this.adDisplay.displayEventStream.sendEvent(new DisplayResult());
        }

        public void onClick(String tag) {
            HeyzapAdapter.this.onCallbackEvent("click");
            this.adDisplay.clickEventStream.sendEvent(Boolean.valueOf(true));
        }

        public void onHide(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.HIDE);
            this.adDisplay.closeListener.set(Boolean.valueOf(true));
        }

        public void onImpressed() {
            this.adDisplay.impressionRegisteredListener.set(Boolean.valueOf(true));
        }

        public void onFailedToShow(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.DISPLAY_FAILED);
            this.adDisplay.displayEventStream.sendEvent(new DisplayResult("network failed to show"));
        }

        public void onAvailable(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.AVAILABLE);
            this.fetchResultFuture.set(new DisplayableFetchResult(new HeyzapCachedAd(this.adRequest, this.adDisplay)));
        }

        public void onFailedToFetch(String tag) {
            HeyzapAdapter.this.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            this.fetchResultFuture.set(new DisplayableFetchResult(new FetchFailure(FetchFailureReason.NO_FILL, "No internet connection or no fill.")));
        }

        public void onAudioStarted() {
        }

        public void onAudioFinished() {
        }
    }

    public class HeyzapCachedAd implements CachedAd {
        private final AdDisplay adDisplay;
        private final AdRequest adRequest;

        public HeyzapCachedAd(AdRequest adRequest, AdDisplay adDisplay) {
            this.adRequest = adRequest;
            this.adDisplay = adDisplay;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            this.adRequest.show(HeyzapAdapter.this.getContextRef().getActivity(), displayOptions.getAdUnit(), displayOptions.getTag());
            return this.adDisplay;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    public Boolean isOnBoard() {
        return Boolean.valueOf(true);
    }

    public String getMarketingName() {
        return "Heyzap";
    }

    public String getMarketingVersion() {
        return HeyzapAds.getVersion();
    }

    public String getCanonicalName() {
        return Network.HEYZAP;
    }

    public FetchOptions canonizeFetch(FetchOptions fetchOptions) {
        CreativeType creativeType = fetchOptions.getCreativeType();
        if (creativeType == CreativeType.INCENTIVIZED) {
            creativeType = CreativeType.VIDEO;
        }
        return FetchOptions.builder(fetchOptions.getNetwork(), creativeType, fetchOptions.getAuctionType()).setTags(fetchOptions.getTags()).build();
    }

    protected SettableFuture<DisplayableFetchResult> fetch(FetchOptions fetchOptions) {
        CreativeType creativeType;
        final SettableFuture<DisplayableFetchResult> resultFuture = SettableFuture.create();
        if (fetchOptions.getCreativeType() == CreativeType.INCENTIVIZED) {
            creativeType = CreativeType.VIDEO;
        } else {
            creativeType = fetchOptions.getCreativeType();
        }
        Manager.start(getContextRef(), this.adsConfig.publisherId).addListener(new Runnable() {
            public void run() {
                AdRequest request = new AdRequest(EnumSet.of(creativeType), Constants.DEFAULT_TAG);
                request.setAuctionType(HeyzapAdapter.this.getAuctionType());
                AdListener listener = new AdListener(request);
                request.setOnStatusListener(listener);
                request.setOnIncentiveListener(listener);
                request.fetch(HeyzapAdapter.this.getContextRef().getApp());
                FutureUtils.bind(listener.getFetchResultFuture(), resultFuture, HeyzapAdapter.this.executorService);
            }
        }, this.executorService);
        return resultFuture;
    }

    public NativeAdWrapper fetchNative(FetchOptions options) {
        final NativeAdWrapper nativeAdWrapper = new NativeAdWrapper();
        this.uiThreadExecutorService.submit(new Runnable() {

            class C15541 implements OnFetchListener {
                C15541() {
                }

                public void onResponse(FetchResponse response, String tag, Throwable e) {
                    FetchResult fetchResult = new FetchResult();
                    if (e != null) {
                        fetchResult.fetchFailure = new FetchFailure(FetchFailureReason.INTERNAL, e.getMessage());
                        fetchResult.success = false;
                    } else {
                        fetchResult.setNativeAdResult((Ad) response.getAds().get(0));
                        fetchResult.success = true;
                    }
                    nativeAdWrapper.fetchListener.set(fetchResult);
                }
            }

            public void run() {
                HeyzapNativeAd.fetch(Constants.DEFAULT_TAG, 1, HeyzapAdapter.this.getAuctionType(), new C15541());
            }
        });
        return nativeAdWrapper;
    }

    public AuctionType getAuctionType() {
        return AUCTION_TYPE;
    }

    public void onInit() {
        if (this.initialized.compareAndSet(false, true)) {
            onCallbackEvent(NetworkCallback.INITIALIZED);
        }
    }

    protected void onStart() {
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.INCENTIVIZED, AdUnit.NATIVE);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.INCENTIVIZED, AdUnit.NATIVE);
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
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    public boolean fetchSupportsDisplay(FetchOptions fetchOptions, DisplayOptions displayOptions) {
        boolean matches;
        Set<CreativeType> creativeTypes = displayOptions.getCreativeTypes().intersect(EnumSet.allOf(CreativeType.class));
        if (creativeTypes.contains(CreativeType.INCENTIVIZED)) {
            creativeTypes.add(CreativeType.VIDEO);
        }
        if (true && fetchOptions.getAdUnits().contains(displayOptions.getAdUnit())) {
            matches = true;
        } else {
            matches = false;
        }
        if (matches && fetchOptions.getTags().contains(displayOptions.getTag())) {
            matches = true;
        } else {
            matches = false;
        }
        if (matches && creativeTypes.contains(fetchOptions.getCreativeType())) {
            matches = true;
        } else {
            matches = false;
        }
        if (matches && displayOptions.getNetworks().contains(fetchOptions.getNetwork())) {
            return true;
        }
        return false;
    }

    public ImpressionOptions generateImpressionOptions(FetchOptions fetchOptions, DisplayOptions displayOptions) {
        return new ImpressionOptions(displayOptions.getAdUnit(), displayOptions.getTag(), getCanonicalName(), fetchOptions.getAuctionType(), displayOptions.getAdUnit() == AdUnit.INCENTIVIZED ? CreativeType.INCENTIVIZED : fetchOptions.getCreativeType());
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.heyzap.sdk.ads.HeyzapInterstitialActivity", "com.heyzap.sdk.ads.HeyzapVideoActivity"});
    }

    public boolean onBackPressed() {
        return false;
    }
}
