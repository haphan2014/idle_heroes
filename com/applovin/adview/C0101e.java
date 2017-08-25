package com.applovin.adview;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.google.android.gms.cast.TextTrackStyle;

class C0101e implements Runnable {
    final /* synthetic */ AppLovinInterstitialActivity f55a;

    C0101e(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f55a = appLovinInterstitialActivity;
    }

    public void run() {
        try {
            if (!this.f55a.f31o && this.f55a.f8F != null) {
                this.f55a.f31o = true;
                this.f55a.f8F.setVisibility(0);
                Animation alphaAnimation = new AlphaAnimation(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
                alphaAnimation.setDuration((long) this.f55a.f21e.m532e());
                alphaAnimation.setRepeatCount(0);
                this.f55a.f8F.startAnimation(alphaAnimation);
                if (this.f55a.m71o() && this.f55a.f9G != null) {
                    this.f55a.f9G.setVisibility(0);
                    this.f55a.f9G.bringToFront();
                }
            }
        } catch (Throwable th) {
            this.f55a.f20d.mo641w("AppLovinInterstitialActivity", "Unable to show skip button: " + th);
        }
    }
}
