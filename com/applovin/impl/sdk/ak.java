package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class ak implements Runnable {
    final /* synthetic */ AppLovinAd f404a;
    final /* synthetic */ ag f405b;

    ak(ag agVar, AppLovinAd appLovinAd) {
        this.f405b = agVar;
        this.f404a = appLovinAd;
    }

    public void run() {
        this.f405b.f395e.videoPlaybackBegan(this.f404a);
    }
}
