package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class C0112p implements OnCompletionListener {
    final /* synthetic */ AppLovinInterstitialActivity f73a;

    C0112p(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f73a = appLovinInterstitialActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f73a.f29m = true;
        this.f73a.m6C();
    }
}
