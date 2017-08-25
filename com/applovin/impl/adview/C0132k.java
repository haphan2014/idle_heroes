package com.applovin.impl.adview;

import com.applovin.impl.sdk.AppLovinSdkImpl;

class C0132k implements Runnable {
    final /* synthetic */ AdViewControllerImpl f196a;

    private C0132k(AdViewControllerImpl adViewControllerImpl) {
        this.f196a = adViewControllerImpl;
    }

    public void run() {
        if (this.f196a.f99n != null) {
            this.f196a.f89d.mo635d("AppLovinAdView", "Rendering advertisement ad for #" + this.f196a.f99n.getAdIdNumber() + " over placement: \"" + this.f196a.f91f + "\"...");
            AdViewControllerImpl.m111b(this.f196a.f94i, this.f196a.f99n.getSize());
            this.f196a.f94i.m181a(this.f196a.f99n, this.f196a.f91f, (AppLovinSdkImpl) this.f196a.f87b);
        }
    }
}
