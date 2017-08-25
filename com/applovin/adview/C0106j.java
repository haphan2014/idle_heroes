package com.applovin.adview;

import com.applovin.impl.adview.aq;
import com.applovin.impl.adview.as;

class C0106j implements as {
    final /* synthetic */ AppLovinInterstitialActivity f65a;

    C0106j(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f65a = appLovinInterstitialActivity;
    }

    public void mo508a(aq aqVar) {
        this.f65a.f20d.mo635d("AppLovinInterstitialActivity", "Clicking through from video button...");
        this.f65a.m44c();
    }

    public void mo509b(aq aqVar) {
        this.f65a.f20d.mo635d("AppLovinInterstitialActivity", "Closing ad from video button...");
        this.f65a.dismiss();
    }

    public void mo510c(aq aqVar) {
        this.f65a.f20d.mo635d("AppLovinInterstitialActivity", "Skipping video from video button...");
        this.f65a.skipVideo();
    }
}
