package com.applovin.adview;

import com.applovin.impl.adview.ap;

class C0105i implements Runnable {
    final /* synthetic */ ap f63a;
    final /* synthetic */ AppLovinInterstitialActivity f64b;

    C0105i(AppLovinInterstitialActivity appLovinInterstitialActivity, ap apVar) {
        this.f64b = appLovinInterstitialActivity;
        this.f63a = apVar;
    }

    public void run() {
        this.f64b.m24a(this.f64b.f15M, false, (long) this.f63a.m164h());
    }
}
