package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.List;

class bp implements AppLovinNativeAdLoadListener {
    final /* synthetic */ bo f492a;

    bp(bo boVar) {
        this.f492a = boVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f492a.f489b != null) {
            this.f492a.f489b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        if (this.f492a.f489b != null) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.f492a.f488a);
            arrayList.addAll(this.f492a.f490c);
            this.f492a.f489b.onNativeAdsLoaded(arrayList);
        }
    }
}
