package com.applovin.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

class C0108l implements AppLovinAdClickListener {
    final /* synthetic */ AppLovinInterstitialActivity f67a;

    C0108l(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f67a = appLovinInterstitialActivity;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AppLovinAdClickListener e = this.f67a.f18b.m143e();
        if (e != null) {
            e.adClicked(appLovinAd);
        }
    }
}
