package com.applovin.adview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class C0098b implements AnimationListener {
    final /* synthetic */ View f50a;
    final /* synthetic */ boolean f51b;
    final /* synthetic */ AppLovinInterstitialActivity f52c;

    C0098b(AppLovinInterstitialActivity appLovinInterstitialActivity, View view, boolean z) {
        this.f52c = appLovinInterstitialActivity;
        this.f50a = view;
        this.f51b = z;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f51b) {
            this.f50a.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f50a.setVisibility(0);
    }
}
