package com.vungle.publisher;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.widget.ProfilePictureView;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class mc implements OnAudioFocusChangeListener {
    public boolean f2554a = false;
    @Inject
    public AudioManager f2555b;

    @Inject
    mc() {
    }

    public final int m2161a() {
        return this.f2555b.getStreamVolume(3);
    }

    public final float m2162b() {
        float streamVolume = (float) this.f2555b.getStreamVolume(3);
        int streamMaxVolume = this.f2555b.getStreamMaxVolume(3);
        return streamMaxVolume > 0 ? streamVolume / ((float) streamMaxVolume) : 0.0f;
    }

    public final void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case ProfilePictureView.NORMAL /*-3*/:
            case -2:
            case -1:
                this.f2554a = false;
                break;
            case 1:
                this.f2554a = true;
                break;
        }
        so.m2470a(2, "VungleDevice", "audio focus changed to " + this.f2554a + ", with focusChange code " + focusChange, null);
    }
}
