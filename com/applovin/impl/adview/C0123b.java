package com.applovin.impl.adview;

class C0123b implements Runnable {
    final /* synthetic */ int f184a;
    final /* synthetic */ AdViewControllerImpl f185b;

    C0123b(AdViewControllerImpl adViewControllerImpl, int i) {
        this.f185b = adViewControllerImpl;
        this.f184a = i;
    }

    public void run() {
        try {
            if (this.f185b.f107v != null) {
                this.f185b.f107v.failedToReceiveAd(this.f184a);
            }
        } catch (Throwable th) {
            this.f185b.f89d.userError("AppLovinAdView", "Exception while running app load  callback", th);
        }
    }
}
