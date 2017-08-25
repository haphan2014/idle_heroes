package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

class C0125d implements AppLovinAdDisplayListener {
    final /* synthetic */ AdViewControllerImpl f187a;

    C0125d(AdViewControllerImpl adViewControllerImpl) {
        this.f187a = adViewControllerImpl;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
    }

    public void adHidden(AppLovinAd appLovinAd) {
        if (this.f187a.f108w != null) {
            this.f187a.f108w.adHidden(appLovinAd);
        }
    }
}
