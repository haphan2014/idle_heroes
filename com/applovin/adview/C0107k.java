package com.applovin.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

class C0107k implements AppLovinAdDisplayListener {
    final /* synthetic */ AppLovinInterstitialActivity f66a;

    C0107k(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f66a = appLovinInterstitialActivity;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        this.f66a.f23g = (AppLovinAdImpl) appLovinAd;
        if (!this.f66a.f25i) {
            this.f66a.m28a(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f66a.m39b(appLovinAd);
    }
}
