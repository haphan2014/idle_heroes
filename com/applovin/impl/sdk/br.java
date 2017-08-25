package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class br implements AppLovinNativeAdLoadListener {
    final /* synthetic */ AppLovinNativeAdLoadListener f495a;
    final /* synthetic */ bk f496b;

    br(bk bkVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f496b = bkVar;
        this.f495a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f496b.m429a(this.f495a, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f496b.m430a(this.f495a, list);
    }
}
