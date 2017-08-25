package com.applovin.adview;

import java.util.UUID;

class C0103g implements Runnable {
    final /* synthetic */ int f58a;
    final /* synthetic */ UUID f59b;
    final /* synthetic */ AppLovinInterstitialActivity f60c;

    C0103g(AppLovinInterstitialActivity appLovinInterstitialActivity, int i, UUID uuid) {
        this.f60c = appLovinInterstitialActivity;
        this.f58a = i;
        this.f59b = uuid;
    }

    public void run() {
        this.f60c.m21a(this.f58a, this.f59b);
    }
}
