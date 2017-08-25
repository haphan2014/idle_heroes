package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

class C0128g implements Runnable {
    final /* synthetic */ AdViewControllerImpl f190a;
    private final AppLovinAd f191b;

    public C0128g(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f190a = adViewControllerImpl;
        this.f191b = appLovinAd;
    }

    public void run() {
        AppLovinAdClickListener i = this.f190a.f110y;
        if (i != null && this.f191b != null) {
            try {
                i.adClicked(this.f191b);
            } catch (Throwable th) {
                this.f190a.f89d.userError("AppLovinAdView", "Exception while notifying ad click listener", th);
            }
        }
    }
}
