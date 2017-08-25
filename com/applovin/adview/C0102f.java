package com.applovin.adview;

import com.applovin.impl.adview.C0122u;

class C0102f implements Runnable {
    final /* synthetic */ C0122u f56a;
    final /* synthetic */ AppLovinInterstitialActivity f57b;

    C0102f(AppLovinInterstitialActivity appLovinInterstitialActivity, C0122u c0122u) {
        this.f57b = appLovinInterstitialActivity;
        this.f56a = c0122u;
    }

    public void run() {
        if (this.f56a.equals(this.f57b.f6D)) {
            this.f57b.m69n();
        } else if (this.f56a.equals(this.f57b.f8F)) {
            this.f57b.m72p();
        }
    }
}
