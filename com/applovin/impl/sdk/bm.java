package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

class bm implements AppLovinNativeAdPrecacheListener {
    final /* synthetic */ AppLovinNativeAdPrecacheListener f484a;
    final /* synthetic */ bk f485b;

    bm(bk bkVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f485b = bkVar;
        this.f484a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f485b.m431a(this.f484a, appLovinNativeAd, i, false);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        this.f485b.m432a(this.f484a, appLovinNativeAd, false);
        this.f485b.m428a(appLovinNativeAd, this.f484a);
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
    }
}
