package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

class C0109m implements OnPreparedListener {
    final /* synthetic */ AppLovinInterstitialActivity f68a;

    C0109m(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f68a = appLovinInterstitialActivity;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f68a.f13K = new WeakReference(mediaPlayer);
        int i = this.f68a.m55g() ? 0 : 1;
        mediaPlayer.setVolume((float) i, (float) i);
        i = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.f68a.f38v = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
        this.f68a.f5C.setVideoSize(i, videoHeight);
        mediaPlayer.setDisplay(this.f68a.f5C.getHolder());
        mediaPlayer.setOnErrorListener(new C0110n(this));
        this.f68a.m76r();
        this.f68a.m64l();
        this.f68a.m85v();
        this.f68a.m81t();
        this.f68a.m60j();
    }
}
