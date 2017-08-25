package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

class al implements Runnable {
    final /* synthetic */ AppLovinAd f406a;
    final /* synthetic */ double f407b;
    final /* synthetic */ boolean f408c;
    final /* synthetic */ ag f409d;

    al(ag agVar, AppLovinAd appLovinAd, double d, boolean z) {
        this.f409d = agVar;
        this.f406a = appLovinAd;
        this.f407b = d;
        this.f408c = z;
    }

    public void run() {
        this.f409d.f395e.videoPlaybackEnded(this.f406a, this.f407b, this.f408c);
    }
}
