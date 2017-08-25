package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ae implements Runnable {
    final /* synthetic */ AppLovinAd f387a;
    final /* synthetic */ ad f388b;

    ae(ad adVar, AppLovinAd appLovinAd) {
        this.f388b = adVar;
        this.f387a = appLovinAd;
    }

    public void run() {
        this.f388b.f386b.adReceived(this.f387a);
    }
}
