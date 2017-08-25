package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;

class C0121a implements Runnable {
    final /* synthetic */ AppLovinAd f118a;
    final /* synthetic */ AdViewControllerImpl f119b;

    C0121a(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f119b = adViewControllerImpl;
        this.f118a = appLovinAd;
    }

    public void run() {
        try {
            if (this.f119b.f107v != null) {
                this.f119b.f107v.adReceived(this.f118a);
            }
        } catch (Throwable th) {
            this.f119b.f89d.userError(AppLovinLogger.SDK_TAG, "Exception while running app load callback: " + th.getMessage());
        }
    }
}
