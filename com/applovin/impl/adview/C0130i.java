package com.applovin.impl.adview;

import com.applovin.adview.AppLovinInterstitialAdDialog;

class C0130i implements Runnable {
    final /* synthetic */ AdViewControllerImpl f194a;

    private C0130i(AdViewControllerImpl adViewControllerImpl) {
        this.f194a = adViewControllerImpl;
    }

    public void run() {
        if (this.f194a.f99n != null) {
            try {
                this.f194a.f89d.mo635d("AppLovinAdView", "Rendering interstitial ad for #" + this.f194a.f99n.getAdIdNumber() + " over placement: \"" + this.f194a.f91f + "\"...");
                AppLovinInterstitialAdDialog createInterstitialAdDialog = new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f194a.f87b, this.f194a.f86a);
                createInterstitialAdDialog.setAdDisplayListener(new C0125d(this.f194a));
                createInterstitialAdDialog.setAdVideoPlaybackListener(new C0126e(this.f194a));
                createInterstitialAdDialog.setAdClickListener(new C0124c(this.f194a));
                createInterstitialAdDialog.showAndRender(this.f194a.f99n, this.f194a.f91f);
            } catch (Throwable th) {
            }
        }
    }
}
