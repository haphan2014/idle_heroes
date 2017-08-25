package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

class bq implements AppLovinNativeAdLoadListener {
    final /* synthetic */ AppLovinNativeAdLoadListener f493a;
    final /* synthetic */ bk f494b;

    bq(bk bkVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f494b = bkVar;
        this.f493a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f493a != null) {
            this.f493a.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        if (this.f493a != null) {
            this.f493a.onNativeAdsLoaded(list);
        }
    }
}
