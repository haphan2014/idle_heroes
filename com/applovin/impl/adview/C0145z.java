package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

class C0145z implements AppLovinAdClickListener {
    final /* synthetic */ ah f252a;
    final /* synthetic */ C0143x f253b;

    C0145z(C0143x c0143x, ah ahVar) {
        this.f253b = c0143x;
        this.f252a = ahVar;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AppLovinAdClickListener e = this.f252a.m143e();
        if (e != null) {
            e.adClicked(appLovinAd);
        }
    }
}
