package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

class C0124c implements AppLovinAdClickListener {
    final /* synthetic */ AdViewControllerImpl f186a;

    C0124c(AdViewControllerImpl adViewControllerImpl) {
        this.f186a = adViewControllerImpl;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        if (this.f186a.f110y != null) {
            this.f186a.f110y.adClicked(appLovinAd);
        }
    }
}
