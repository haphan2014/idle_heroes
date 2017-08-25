package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ai implements Runnable {
    final /* synthetic */ AppLovinAd f400a;
    final /* synthetic */ ag f401b;

    ai(ag agVar, AppLovinAd appLovinAd) {
        this.f401b = agVar;
        this.f400a = appLovinAd;
    }

    public void run() {
        this.f401b.f393c.adHidden(this.f400a);
    }
}
