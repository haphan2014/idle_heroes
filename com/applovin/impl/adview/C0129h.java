package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

class C0129h implements Runnable {
    final /* synthetic */ AdViewControllerImpl f192a;
    private final AppLovinAd f193b;

    public C0129h(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f192a = adViewControllerImpl;
        this.f193b = appLovinAd;
    }

    public void run() {
        AppLovinAdDisplayListener h = this.f192a.f108w;
        if (h != null && this.f193b != null) {
            try {
                h.adHidden(this.f193b);
            } catch (Throwable th) {
                this.f192a.f89d.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }
}
