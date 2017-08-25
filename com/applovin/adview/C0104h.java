package com.applovin.adview;

import com.applovin.impl.adview.ap;

class C0104h implements Runnable {
    final /* synthetic */ ap f61a;
    final /* synthetic */ AppLovinInterstitialActivity f62b;

    C0104h(AppLovinInterstitialActivity appLovinInterstitialActivity, ap apVar) {
        this.f62b = appLovinInterstitialActivity;
        this.f61a = apVar;
    }

    public void run() {
        this.f62b.m24a(this.f62b.f15M, true, (long) this.f61a.m163g());
    }
}
