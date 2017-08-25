package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.Map;

@zzgd
public class zzh extends FrameLayout implements zzg {
    private final zzid zzoA;
    private String zzwC;
    private final FrameLayout zzzO;
    private final zzi zzzP;
    private final zzm zzzQ = new zzm(this);
    private TextView zzzR;
    private long zzzS;
    private long zzzT;

    public zzh(Context context, zzid com_google_android_gms_internal_zzid) {
        super(context);
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzzO = new FrameLayout(context);
        addView(this.zzzO);
        this.zzzP = new zzi(context);
        this.zzzO.addView(this.zzzP, new LayoutParams(-1, -1, 17));
        this.zzzR = new TextView(context);
        this.zzzR.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        zzeM();
        this.zzzQ.zzeY();
        this.zzzP.zza((zzg) this);
    }

    private void zza(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, str);
        int length = strArr.length;
        int i = 0;
        Object obj = null;
        while (i < length) {
            Object obj2 = strArr[i];
            if (obj != null) {
                hashMap.put(obj, obj2);
                obj2 = null;
            }
            i++;
            obj = obj2;
        }
        this.zzoA.zzc("onVideoEvent", hashMap);
    }

    public static void zzd(zzid com_google_android_gms_internal_zzid) {
        Map hashMap = new HashMap();
        hashMap.put(DataLayer.EVENT_KEY, "no_video_view");
        com_google_android_gms_internal_zzid.zzc("onVideoEvent", hashMap);
    }

    private void zzeM() {
        if (!zzeO()) {
            this.zzzO.addView(this.zzzR, new LayoutParams(-1, -1));
            this.zzzO.bringChildToFront(this.zzzR);
        }
    }

    private void zzeN() {
        if (zzeO()) {
            this.zzzO.removeView(this.zzzR);
        }
    }

    private boolean zzeO() {
        return this.zzzR.getParent() != null;
    }

    public void destroy() {
        this.zzzQ.cancel();
        this.zzzP.stop();
    }

    public void onPaused() {
        zza("pause", new String[0]);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.zzzT == 0) {
            float duration = ((float) mediaPlayer.getDuration()) / 1000.0f;
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            zza("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    public void pause() {
        this.zzzP.pause();
    }

    public void play() {
        this.zzzP.play();
    }

    public void seekTo(int millis) {
        this.zzzP.seekTo(millis);
    }

    public void zza(float f) {
        this.zzzP.zza(f);
    }

    public void zzah(String str) {
        this.zzwC = str;
    }

    public void zzc(MotionEvent motionEvent) {
        this.zzzP.dispatchTouchEvent(motionEvent);
    }

    public void zzeD() {
    }

    public void zzeE() {
    }

    public void zzeF() {
        zza("ended", new String[0]);
    }

    public void zzeG() {
        zzeM();
        this.zzzT = this.zzzS;
    }

    public void zzeH() {
        if (TextUtils.isEmpty(this.zzwC)) {
            zza("no_src", new String[0]);
        } else {
            this.zzzP.setVideoPath(this.zzwC);
        }
    }

    public void zzeI() {
        this.zzzP.zzeI();
    }

    public void zzeJ() {
        this.zzzP.zzeJ();
    }

    public void zzeK() {
        View textView = new TextView(this.zzzP.getContext());
        textView.setText("AdMob");
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(-256);
        this.zzzO.addView(textView, new LayoutParams(-2, -2, 17));
        this.zzzO.bringChildToFront(textView);
    }

    void zzeL() {
        long currentPosition = (long) this.zzzP.getCurrentPosition();
        if (this.zzzS != currentPosition && currentPosition > 0) {
            zzeN();
            float f = ((float) currentPosition) / 1000.0f;
            zza("timeupdate", "time", String.valueOf(f));
            this.zzzS = currentPosition;
        }
    }

    public void zzf(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.zzzO.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void zzg(String str, String str2) {
        zza("error", "what", str, "extra", str2);
    }
}
