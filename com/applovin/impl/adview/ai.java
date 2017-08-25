package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

class ai implements AppLovinAdLoadListener {
    final /* synthetic */ String f145a;
    final /* synthetic */ ah f146b;

    ai(ah ahVar, String str) {
        this.f146b = ahVar;
        this.f145a = str;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f146b.m135b(appLovinAd);
        this.f146b.showAndRender(appLovinAd, this.f145a);
    }

    public void failedToReceiveAd(int i) {
        this.f146b.m126a(i);
    }
}
