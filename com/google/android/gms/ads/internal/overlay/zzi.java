package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import com.droidhang.pay.util.IabHelper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zzgd
public class zzi extends SurfaceView implements OnAudioFocusChangeListener, OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnVideoSizeChangedListener, Callback {
    private static final Map<Integer, String> zzzU = new HashMap();
    private int zzAa;
    private int zzAb;
    private int zzAc;
    private int zzAd;
    private int zzAe;
    private float zzAf = TextTrackStyle.DEFAULT_FONT_SCALE;
    private boolean zzAg;
    private boolean zzAh;
    private int zzAi;
    private zzg zzAj;
    private int zzzV = 0;
    private int zzzW = 0;
    private SurfaceHolder zzzX;
    private MediaPlayer zzzY;
    private Uri zzzZ;

    class C03522 implements Runnable {
        final /* synthetic */ zzi zzAl;

        C03522(zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzAl = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            if (this.zzAl.zzAj != null) {
                this.zzAl.zzAj.zzeF();
            }
        }
    }

    class C03544 implements Runnable {
        final /* synthetic */ zzi zzAl;

        C03544(zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzAl = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            if (this.zzAl.zzAj != null) {
                this.zzAl.zzAj.zzeD();
            }
        }
    }

    class C03555 implements Runnable {
        final /* synthetic */ zzi zzAl;

        C03555(zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzAl = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            if (this.zzAl.zzAj != null) {
                this.zzAl.zzAj.onPaused();
                this.zzAl.zzAj.zzeG();
            }
        }
    }

    class C03566 implements Runnable {
        final /* synthetic */ zzi zzAl;

        C03566(zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzAl = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            if (this.zzAl.zzAj != null) {
                this.zzAl.zzAj.zzeE();
            }
        }
    }

    class C03577 implements Runnable {
        final /* synthetic */ zzi zzAl;

        C03577(zzi com_google_android_gms_ads_internal_overlay_zzi) {
            this.zzAl = com_google_android_gms_ads_internal_overlay_zzi;
        }

        public void run() {
            if (this.zzAl.zzAj != null) {
                this.zzAl.zzAj.onPaused();
            }
        }
    }

    static {
        zzzU.put(Integer.valueOf(IabHelper.IABHELPER_SEND_INTENT_FAILED), "MEDIA_ERROR_IO");
        zzzU.put(Integer.valueOf(IabHelper.IABHELPER_MISSING_TOKEN), "MEDIA_ERROR_MALFORMED");
        zzzU.put(Integer.valueOf(IabHelper.IABHELPER_INVALID_CONSUMPTION), "MEDIA_ERROR_UNSUPPORTED");
        zzzU.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        zzzU.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        zzzU.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        zzzU.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        zzzU.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzzU.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        zzzU.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        zzzU.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        zzzU.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        zzzU.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        zzzU.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        zzzU.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzzU.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzi(Context context) {
        super(context);
        getHolder().addCallback(this);
        if (VERSION.SDK_INT < 11) {
            getHolder().setType(3);
        }
    }

    private void zzb(float f) {
        if (this.zzzY != null) {
            try {
                this.zzzY.setVolume(f, f);
                return;
            } catch (IllegalStateException e) {
                return;
            }
        }
        zzb.zzaC("AdVideoView setMediaPlayerVolume() called before onPrepared().");
    }

    private void zzeP() {
        Throwable e;
        zzb.zzaB("AdVideoView init MediaPlayer");
        if (this.zzzZ != null && this.zzzX != null) {
            zzv(false);
            try {
                this.zzzY = new MediaPlayer();
                this.zzzY.setOnBufferingUpdateListener(this);
                this.zzzY.setOnCompletionListener(this);
                this.zzzY.setOnErrorListener(this);
                this.zzzY.setOnInfoListener(this);
                this.zzzY.setOnPreparedListener(this);
                this.zzzY.setOnVideoSizeChangedListener(this);
                this.zzAe = 0;
                this.zzzY.setDataSource(getContext(), this.zzzZ);
                this.zzzY.setDisplay(this.zzzX);
                this.zzzY.setAudioStreamType(3);
                this.zzzY.setScreenOnWhilePlaying(true);
                this.zzzY.prepareAsync();
                this.zzzV = 1;
            } catch (IOException e2) {
                e = e2;
                zzb.zzd("Failed to initialize MediaPlayer at " + this.zzzZ, e);
                onError(this.zzzY, 1, 0);
            } catch (IllegalArgumentException e3) {
                e = e3;
                zzb.zzd("Failed to initialize MediaPlayer at " + this.zzzZ, e);
                onError(this.zzzY, 1, 0);
            }
        }
    }

    private void zzeQ() {
        if (zzeT() && this.zzzW != 3) {
            zzb.zzaB("AdVideoView nudging MediaPlayer");
            this.zzzY.start();
            int currentPosition = this.zzzY.getCurrentPosition();
            long currentTimeMillis = zzo.zzbz().currentTimeMillis();
            while (zzeT() && this.zzzY.getCurrentPosition() == currentPosition) {
                if (zzo.zzbz().currentTimeMillis() - currentTimeMillis > 250) {
                    break;
                }
            }
            this.zzzY.pause();
        }
    }

    private void zzeR() {
        AudioManager zzeX = zzeX();
        if (zzeX != null && !this.zzAh) {
            if (zzeX.requestAudioFocus(this, 3, 2) == 1) {
                zzeU();
            } else {
                zzb.zzaC("AdVideoView audio focus request failed");
            }
        }
    }

    private void zzeS() {
        zzb.zzaB("AdVideoView abandon audio focus");
        AudioManager zzeX = zzeX();
        if (zzeX != null && this.zzAh) {
            if (zzeX.abandonAudioFocus(this) == 1) {
                this.zzAh = false;
            } else {
                zzb.zzaC("AdVideoView abandon audio focus failed");
            }
        }
    }

    private boolean zzeT() {
        return (this.zzzY == null || this.zzzV == -1 || this.zzzV == 0 || this.zzzV == 1) ? false : true;
    }

    private void zzeU() {
        zzb.zzaB("AdVideoView audio focus gained");
        this.zzAh = true;
        zzeW();
    }

    private void zzeV() {
        zzb.zzaB("AdVideoView audio focus lost");
        this.zzAh = false;
        zzeW();
    }

    private void zzeW() {
        if (this.zzAg || !this.zzAh) {
            zzb(0.0f);
        } else {
            zzb(this.zzAf);
        }
    }

    private AudioManager zzeX() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzv(boolean z) {
        zzb.zzaB("AdVideoView release");
        if (this.zzzY != null) {
            this.zzzY.reset();
            this.zzzY.release();
            this.zzzY = null;
            this.zzzV = 0;
            if (z) {
                this.zzzW = 0;
            }
            zzeS();
        }
    }

    public int getCurrentPosition() {
        return zzeT() ? this.zzzY.getCurrentPosition() : 0;
    }

    public void onAudioFocusChange(int focusChange) {
        if (focusChange > 0) {
            zzeU();
        } else if (focusChange < 0) {
            zzeV();
        }
    }

    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        this.zzAe = percent;
    }

    public void onCompletion(MediaPlayer mp) {
        zzb.zzaB("AdVideoView completion");
        this.zzzV = 5;
        this.zzzW = 5;
        zzhl.zzGk.post(new C03522(this));
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        final String str = (String) zzzU.get(Integer.valueOf(what));
        final String str2 = (String) zzzU.get(Integer.valueOf(extra));
        zzb.zzaC("AdVideoView MediaPlayer error: " + str + ":" + str2);
        this.zzzV = -1;
        this.zzzW = -1;
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzi zzAl;

            public void run() {
                if (this.zzAl.zzAj != null) {
                    this.zzAl.zzAj.zzg(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        String str = (String) zzzU.get(Integer.valueOf(extra));
        zzb.zzaB("AdVideoView MediaPlayer info: " + ((String) zzzU.get(Integer.valueOf(what))) + ":" + str);
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultSize = getDefaultSize(this.zzAa, widthMeasureSpec);
        int defaultSize2 = getDefaultSize(this.zzAb, heightMeasureSpec);
        if (this.zzAa > 0 && this.zzAb > 0) {
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            int size = MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = MeasureSpec.getMode(heightMeasureSpec);
            defaultSize2 = MeasureSpec.getSize(heightMeasureSpec);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzAa * defaultSize2 < this.zzAb * size) {
                    defaultSize = (this.zzAa * defaultSize2) / this.zzAb;
                } else if (this.zzAa * defaultSize2 > this.zzAb * size) {
                    defaultSize2 = (this.zzAb * size) / this.zzAa;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                defaultSize = (this.zzAb * size) / this.zzAa;
                if (mode2 != ExploreByTouchHelper.INVALID_ID || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzAa * defaultSize2) / this.zzAb;
                if (mode == ExploreByTouchHelper.INVALID_ID && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i = this.zzAa;
                defaultSize = this.zzAb;
                if (mode2 != ExploreByTouchHelper.INVALID_ID || defaultSize <= defaultSize2) {
                    defaultSize2 = defaultSize;
                    defaultSize = i;
                } else {
                    defaultSize = (this.zzAa * defaultSize2) / this.zzAb;
                }
                if (mode == ExploreByTouchHelper.INVALID_ID && r1 > size) {
                    defaultSize2 = (this.zzAb * size) / this.zzAa;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void onPrepared(final MediaPlayer mediaPlayer) {
        zzb.zzaB("AdVideoView prepared");
        this.zzzV = 2;
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzi zzAl;

            public void run() {
                if (this.zzAl.zzAj != null) {
                    this.zzAl.zzAj.onPrepared(mediaPlayer);
                }
            }
        });
        this.zzAa = mediaPlayer.getVideoWidth();
        this.zzAb = mediaPlayer.getVideoHeight();
        if (this.zzAi != 0) {
            seekTo(this.zzAi);
        }
        zzeQ();
        if (this.zzAa != 0 && this.zzAb != 0) {
            zzb.zzaA("AdVideoView stream dimensions: " + this.zzAa + " x " + this.zzAb);
            getHolder().setFixedSize(this.zzAa, this.zzAb);
            if (this.zzAc == this.zzAa && this.zzAd == this.zzAb && this.zzzW == 3) {
                play();
            }
        } else if (this.zzzW == 3) {
            play();
        }
        zzeR();
        zzeW();
    }

    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        zzb.zzaB("AdVideoView size changed: " + width + " x " + height);
        this.zzAa = mp.getVideoWidth();
        this.zzAb = mp.getVideoHeight();
        if (this.zzAa != 0 && this.zzAb != 0) {
            getHolder().setFixedSize(this.zzAa, this.zzAb);
            requestLayout();
        }
    }

    public void pause() {
        zzb.zzaB("AdVideoView pause");
        if (zzeT() && this.zzzY.isPlaying()) {
            this.zzzY.pause();
            this.zzzV = 4;
            zzhl.zzGk.post(new C03577(this));
        }
        this.zzzW = 4;
    }

    public void play() {
        zzb.zzaB("AdVideoView play");
        if (zzeT()) {
            this.zzzY.start();
            this.zzzV = 3;
            zzhl.zzGk.post(new C03566(this));
        }
        this.zzzW = 3;
    }

    public void seekTo(int millis) {
        zzb.zzaB("AdVideoView seek " + millis);
        if (zzeT()) {
            this.zzzY.seekTo(millis);
            this.zzAi = 0;
            return;
        }
        this.zzAi = millis;
    }

    public void setVideoPath(String path) {
        setVideoURI(Uri.parse(path));
    }

    public void setVideoURI(Uri uri) {
        this.zzzZ = uri;
        this.zzAi = 0;
        zzeP();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzb.zzaB("AdVideoView stop");
        if (this.zzzY != null) {
            this.zzzY.stop();
            this.zzzY.release();
            this.zzzY = null;
            this.zzzV = 0;
            this.zzzW = 0;
            zzeS();
        }
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        Object obj = 1;
        zzb.zzaB("AdVideoView surface changed");
        this.zzAc = w;
        this.zzAd = h;
        Object obj2 = this.zzzW == 3 ? 1 : null;
        if (!(this.zzAa == w && this.zzAb == h)) {
            obj = null;
        }
        if (this.zzzY != null && obj2 != null && r1 != null) {
            if (this.zzAi != 0) {
                seekTo(this.zzAi);
            }
            play();
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        zzb.zzaB("AdVideoView surface created");
        this.zzzX = holder;
        zzeP();
        zzhl.zzGk.post(new C03544(this));
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        zzb.zzaB("AdVideoView surface destroyed");
        if (this.zzzY != null && this.zzAi == 0) {
            this.zzAi = this.zzzY.getCurrentPosition();
        }
        this.zzzX = null;
        zzhl.zzGk.post(new C03555(this));
        zzv(true);
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

    public void zza(float f) {
        this.zzAf = f;
        zzeW();
    }

    public void zza(zzg com_google_android_gms_ads_internal_overlay_zzg) {
        this.zzAj = com_google_android_gms_ads_internal_overlay_zzg;
    }

    public void zzeI() {
        this.zzAg = true;
        zzeW();
    }

    public void zzeJ() {
        this.zzAg = false;
        zzeW();
    }
}
