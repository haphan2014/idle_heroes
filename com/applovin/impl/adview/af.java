package com.applovin.impl.adview;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.applovin.impl.sdk.ch;
import com.google.android.gms.cast.TextTrackStyle;

class af implements Runnable {
    final /* synthetic */ C0143x f128a;

    af(C0143x c0143x) {
        this.f128a = c0143x;
    }

    public void run() {
        try {
            this.f128a.f245g.setVisibility(0);
            this.f128a.f245g.bringToFront();
            ch chVar = new ch(this.f128a.f240b);
            Animation alphaAnimation = new AlphaAnimation(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
            alphaAnimation.setDuration((long) chVar.m532e());
            alphaAnimation.setRepeatCount(0);
            this.f128a.f245g.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f128a.dismiss();
        }
    }
}
