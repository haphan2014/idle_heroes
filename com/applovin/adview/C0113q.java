package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class C0113q implements OnErrorListener {
    final /* synthetic */ AppLovinInterstitialActivity f74a;

    C0113q(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f74a = appLovinInterstitialActivity;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f74a.f3A.post(new C0114r(this, i, i2));
        return true;
    }
}
