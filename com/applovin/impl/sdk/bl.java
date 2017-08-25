package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bl implements AppLovinNativeAdLoadListener {
    final /* synthetic */ AppLovinNativeAdLoadListener f482a;
    final /* synthetic */ bk f483b;

    bl(bk bkVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f483b = bkVar;
        this.f482a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f483b.m429a(this.f482a, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f483b.m435a(list, this.f482a);
    }
}
