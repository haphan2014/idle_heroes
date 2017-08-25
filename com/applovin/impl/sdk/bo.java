package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bo implements AppLovinNativeAdLoadListener {
    final /* synthetic */ List f488a;
    final /* synthetic */ AppLovinNativeAdLoadListener f489b;
    final /* synthetic */ List f490c;
    final /* synthetic */ bk f491d;

    bo(bk bkVar, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list2) {
        this.f491d = bkVar;
        this.f488a = list;
        this.f489b = appLovinNativeAdLoadListener;
        this.f490c = list2;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f489b != null) {
            this.f489b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        this.f491d.m434c(this.f488a, new bp(this));
    }
}
