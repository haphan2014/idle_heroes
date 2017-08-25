package com.applovin.adview;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.google.android.gms.cast.TextTrackStyle;

class C0100d implements Runnable {
    final /* synthetic */ AppLovinInterstitialActivity f54a;

    C0100d(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f54a = appLovinInterstitialActivity;
    }

    public void run() {
        try {
            if (this.f54a.f30n) {
                this.f54a.f6D.setVisibility(0);
                return;
            }
            this.f54a.f30n = true;
            if (this.f54a.m71o() && this.f54a.f7E != null) {
                this.f54a.f7E.setVisibility(0);
                this.f54a.f7E.bringToFront();
            }
            this.f54a.f6D.setVisibility(0);
            this.f54a.f6D.bringToFront();
            Animation alphaAnimation = new AlphaAnimation(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
            alphaAnimation.setDuration((long) this.f54a.f21e.m532e());
            alphaAnimation.setRepeatCount(0);
            this.f54a.f6D.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f54a.dismiss();
        }
    }
}
