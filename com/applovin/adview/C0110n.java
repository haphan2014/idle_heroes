package com.applovin.adview;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

class C0110n implements OnErrorListener {
    final /* synthetic */ C0109m f69a;

    C0110n(C0109m c0109m) {
        this.f69a = c0109m;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f69a.f68a.f3A.post(new C0111o(this, i, i2));
        return true;
    }
}
