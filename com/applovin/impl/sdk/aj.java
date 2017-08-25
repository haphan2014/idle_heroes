package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class aj implements Runnable {
    final /* synthetic */ AppLovinAd f402a;
    final /* synthetic */ ag f403b;

    aj(ag agVar, AppLovinAd appLovinAd) {
        this.f403b = agVar;
        this.f402a = appLovinAd;
    }

    public void run() {
        this.f403b.f394d.adClicked(this.f402a);
    }
}
