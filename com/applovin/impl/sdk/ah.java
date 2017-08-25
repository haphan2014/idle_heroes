package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ah implements Runnable {
    final /* synthetic */ AppLovinAd f397a;
    final /* synthetic */ int f398b;
    final /* synthetic */ ag f399c;

    ah(ag agVar, AppLovinAd appLovinAd, int i) {
        this.f399c = agVar;
        this.f397a = appLovinAd;
        this.f398b = i;
    }

    public void run() {
        this.f399c.f396f.validationRequestFailed(this.f397a, this.f398b);
    }
}
