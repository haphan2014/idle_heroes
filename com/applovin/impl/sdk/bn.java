package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

class bn implements AppLovinNativeAdPrecacheListener {
    final /* synthetic */ AppLovinNativeAdPrecacheListener f486a;
    final /* synthetic */ bk f487b;

    bn(bk bkVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f487b = bkVar;
        this.f486a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f487b.m431a(this.f486a, appLovinNativeAd, i, true);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f487b.m432a(this.f486a, appLovinNativeAd, true);
    }
}
