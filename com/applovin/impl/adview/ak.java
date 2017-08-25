package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;

class ak implements Runnable {
    final /* synthetic */ AppLovinAd f151a;
    final /* synthetic */ ah f152b;

    ak(ah ahVar, AppLovinAd appLovinAd) {
        this.f152b = ahVar;
        this.f151a = appLovinAd;
    }

    public void run() {
        if (this.f152b.f137g != null) {
            this.f152b.f137g.adReceived(this.f151a);
        }
    }
}
