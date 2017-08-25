package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdkUtils;

class bj implements AppLovinNativeAdPrecacheListener {
    final /* synthetic */ bi f479a;

    bj(bi biVar) {
        this.f479a = biVar;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f479a.m356b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        if (!AppLovinSdkUtils.isValidString(appLovinNativeAd.getVideoUrl())) {
            this.f479a.m358c((bf) appLovinNativeAd);
        }
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f479a.b.mo641w("NativeAdPreloadManager", "Video failed to cache during native ad preload. " + i);
        this.f479a.m358c((bf) appLovinNativeAd);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f479a.m358c((bf) appLovinNativeAd);
    }
}
