package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

class ad implements AppLovinAdLoadListener {
    final /* synthetic */ ab f385a;
    private final AppLovinAdLoadListener f386b;

    ad(ab abVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f385a = abVar;
        this.f386b = appLovinAdLoadListener;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f385a.f375c = (AppLovinAdImpl) appLovinAd;
        if (this.f386b != null) {
            this.f385a.f378f.post(new ae(this, appLovinAd));
        }
    }

    public void failedToReceiveAd(int i) {
        if (this.f386b != null) {
            this.f385a.f378f.post(new af(this, i));
        }
    }
}
