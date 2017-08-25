package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ap implements Runnable {
    final /* synthetic */ AppLovinAd f419a;
    final /* synthetic */ int f420b;
    final /* synthetic */ ag f421c;

    ap(ag agVar, AppLovinAd appLovinAd, int i) {
        this.f421c = agVar;
        this.f419a = appLovinAd;
        this.f420b = i;
    }

    public void run() {
        this.f421c.f396f.validationRequestFailed(this.f419a, this.f420b);
    }
}
