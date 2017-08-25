package com.vungle.publisher;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.provider.Settings.System;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.google.android.gms.cast.TextTrackStyle;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.jw.C1798a;
import com.vungle.publisher.nd.C1830a;
import com.vungle.publisher.oh.C1845a;
import com.vungle.publisher.ok.C1846a;
import com.vungle.publisher.qx.C1869a;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class oq extends mw implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private ViewGroup f2788A;
    private Bitmap f2789B;
    private Bitmap f2790C;
    private Bitmap f2791D;
    private Bitmap f2792E;
    private final Handler f2793F = new Handler();
    private final Runnable f2794G = new C1855c(this);
    private String f2795H;
    private int f2796I;
    private boolean f2797J;
    private int f2798K;
    private boolean f2799L;
    private AtomicBoolean f2800M = new AtomicBoolean();
    private int f2801N;
    private MediaPlayer f2802O;
    ju<?> f2803e;
    ImageView f2804f;
    ImageView f2805g;
    TouchDelegate f2806h;
    AtomicBoolean f2807i = new AtomicBoolean();
    int f2808j;
    AtomicBoolean f2809k = new AtomicBoolean();
    int f2810l;
    AtomicBoolean f2811m = new AtomicBoolean(true);
    @Inject
    nf f2812n;
    @Inject
    qh f2813o;
    @Inject
    C1853a f2814p;
    @Inject
    C1845a f2815q;
    @Inject
    C1846a f2816r;
    @Inject
    pj f2817s;
    @Inject
    agj f2818t;
    @Inject
    cj f2819u;
    @Inject
    mc f2820v;
    private ok f2821w;
    private ob f2822x;
    private RelativeLayout f2823y;
    private VideoView f2824z;

    /* compiled from: vungle */
    class C18481 implements OnClickListener {
        final /* synthetic */ oq f2777a;

        C18481(oq oqVar) {
            this.f2777a = oqVar;
        }

        public final void onClick(View view) {
            String str;
            String str2 = "VungleAd";
            if (this.f2777a.f2811m.get()) {
                str = "Muting";
            } else {
                str = "Unmuting";
            }
            so.m2470a(3, str2, str, null);
            oq oqVar = this.f2777a;
            if (oqVar.f2811m.compareAndSet(oqVar.f2811m.get(), !oqVar.f2811m.get())) {
                oqVar.f2813o.m2361a(new bj(oqVar.f2811m.get()));
                oqVar.m2302d();
            }
        }
    }

    /* compiled from: vungle */
    class C18492 implements OnTouchListener {
        final /* synthetic */ oq f2778a;

        C18492(oq oqVar) {
            this.f2778a = oqVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            so.m2470a(2, "VungleAd", "video onTouch", null);
            if (this.f2778a.f2806h != null) {
                this.f2778a.f2806h.onTouchEvent(motionEvent);
            }
            oq oqVar = this.f2778a;
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (oqVar.f2804f == null || !oqVar.f2807i.compareAndSet(false, true)) {
                return true;
            }
            ObjectAnimator.ofFloat(oqVar.f2804f, "alpha", new float[]{TextTrackStyle.DEFAULT_FONT_SCALE}).setDuration(750).start();
            return true;
        }
    }

    /* compiled from: vungle */
    class C18525 implements C1830a {
        final /* synthetic */ oq f2784a;

        C18525(oq oqVar) {
            this.f2784a = oqVar;
        }

        public final void mo4497a() {
            m2275d();
        }

        public final void mo4498b() {
            so.m2470a(3, "VungleAd", "cancel video", null);
            this.f2784a.m2292g();
        }

        public final void mo4499c() {
            m2275d();
        }

        private void m2275d() {
            this.f2784a.onResume();
            this.f2784a.f2800M.set(false);
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1853a {
        @Inject
        Provider<oq> f2785a;

        @Inject
        C1853a() {
        }
    }

    /* compiled from: vungle */
    class C1854b implements OnClickListener {
        final /* synthetic */ oq f2786a;

        C1854b(oq oqVar) {
            this.f2786a = oqVar;
        }

        public final void onClick(View view) {
            so.m2470a(2, "VungleAd", "close clicked", null);
            this.f2786a.m2290f(false);
        }
    }

    /* compiled from: vungle */
    class C1855c implements Runnable {
        final /* synthetic */ oq f2787a;

        C1855c(oq oqVar) {
            this.f2787a = oqVar;
        }

        public final void run() {
            try {
                this.f2787a.m2301c(false);
                this.f2787a.m2300c();
                if (!this.f2787a.f2809k.get()) {
                    oq oqVar = this.f2787a;
                    if (oqVar.f2810l > (oqVar.f2808j * 1000) - 750 && oqVar.f2809k.compareAndSet(false, true)) {
                        ObjectAnimator.ofFloat(oqVar.f2805g, "alpha", new float[]{TextTrackStyle.DEFAULT_FONT_SCALE}).setDuration(750).start();
                    }
                }
                this.f2787a.f2821w.setCurrentTimeMillis(this.f2787a.f2824z.getCurrentPosition());
                this.f2787a.f2813o.m2361a(new aw(this.f2787a.f2810l));
            } catch (Throwable e) {
                so.m2470a(5, "VungleAd", null, e);
            } finally {
                this.f2787a.f2793F.postDelayed(this, 50);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f2788A = new RelativeLayout(getActivity());
        this.f2788A.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        return this.f2788A;
    }

    public final void onActivityCreated(Bundle savedInstanceState) {
        try {
            Integer num;
            super.onActivityCreated(savedInstanceState);
            try {
                if (Injector.getInstance().m1976c()) {
                    Injector.m1974b().mo4531a(this);
                } else {
                    so.m2470a(5, "VungleAd", "SDK not initialized", null);
                    getActivity().finish();
                }
            } catch (Throwable th) {
                so.m2470a(4, "VungleAd", "Unexpected error in fragment injection", th);
            }
            if (savedInstanceState != null) {
                so.m2470a(3, "VungleAd", "Restoring saved state", null);
                this.b = (C1617z) savedInstanceState.getParcelable("adConfig");
                this.f2799L = savedInstanceState.getBoolean("adStarted");
                this.f2801N = savedInstanceState.getInt("currentVideoPosition");
            }
            if (this.f2799L) {
                this.f2813o.m2361a(new bi());
            }
            Context activity = getActivity();
            View videoView = new VideoView(activity);
            this.f2824z = videoView;
            View obVar = new ob(activity);
            this.f2805g = obVar;
            View obVar2 = new ob(activity);
            this.f2822x = obVar2;
            this.f2789B = this.f2818t.m1228a(C1869a.muteOn);
            this.f2790C = this.f2818t.m1228a(C1869a.muteOff);
            this.f2811m.set(!this.b.isSoundEnabled());
            obVar2.setOnClickListener(new C18481(this));
            View a = this.f2815q.m2261a(activity, false);
            C1846a c1846a = this.f2816r;
            View okVar = new ok(c1846a.f2756a);
            okVar.f2762e = 1;
            okVar.f2761d = (int) c1846a.f2757b.m2195a(2);
            this.f2821w = okVar;
            this.f2788A.addView(videoView);
            LayoutParams layoutParams = (LayoutParams) videoView.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            layoutParams.addRule(13);
            View relativeLayout = new RelativeLayout(activity);
            this.f2788A.addView(relativeLayout);
            layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(10);
            relativeLayout.addView(obVar);
            this.f2818t.m1229a(obVar, C1869a.close);
            layoutParams = (LayoutParams) obVar.getLayoutParams();
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            relativeLayout.addView(a);
            a.setVisibility(0);
            layoutParams = (LayoutParams) a.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, okVar.getProgressBarHeight());
            this.f2788A.addView(okVar, layoutParams2);
            layoutParams2.addRule(12);
            a = new RelativeLayout(activity);
            this.f2823y = a;
            this.f2788A.addView(a);
            layoutParams = (LayoutParams) a.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(2, 1);
            a.addView(obVar2);
            layoutParams = (LayoutParams) obVar2.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            int round = Math.round(this.f2812n.m2195a(2));
            int round2 = Math.round(this.f2812n.m2195a(1));
            relativeLayout.setPadding(round, round2, round, round2);
            a.setPadding(round, round2, round, round2);
            this.f2805g.setScaleType(ScaleType.FIT_CENTER);
            this.f2822x.setScaleType(ScaleType.FIT_CENTER);
            so.m2470a(4, "VungleAd", "video play URI = " + this.f2803e.mo4443q(), null);
            videoView.setVideoURI(this.f2803e.mo4443q());
            if (Boolean.TRUE.equals(this.f2803e.f1831h)) {
                this.f2791D = this.f2818t.m1228a(C1869a.cta);
                this.f2792E = this.f2818t.m1228a(C1869a.ctaDisabled);
                Integer num2 = this.f2803e.f1829f;
                num = this.f2803e.f1833j;
                Integer num3;
                if (num2 == null) {
                    if (num != null) {
                        so.m2470a(2, "VungleAd", "overriding cta enabled from null to " + num, null);
                        num2 = num;
                    }
                    num3 = num;
                    num = num2;
                    num2 = num3;
                } else if (num == null) {
                    so.m2470a(2, "VungleAd", "overriding cta shown from null to " + num2, null);
                    num = num2;
                } else {
                    if (num.intValue() > num2.intValue()) {
                        so.m2470a(2, "VungleAd", "overriding cta shown from " + num + " to " + num2, null);
                        num = num2;
                    }
                    num3 = num;
                    num = num2;
                    num2 = num3;
                }
                so.m2470a(3, "VungleAd", "cta shown at " + num2 + " seconds; enabled at " + num + " seconds", null);
                this.f2796I = num == null ? 0 : num.intValue();
                if (num2 == null) {
                    round = 0;
                } else {
                    round = num2.intValue();
                }
                this.f2798K = round;
                final View obVar3 = new ob(getActivity());
                this.f2804f = obVar3;
                this.f2823y.addView(obVar3);
                layoutParams = (LayoutParams) obVar3.getLayoutParams();
                layoutParams.addRule(9);
                layoutParams.addRule(15);
                obVar3.setScaleType(ScaleType.FIT_CENTER);
                final Float f = this.f2803e.f1828e;
                if (f == null || f.floatValue() <= TextTrackStyle.DEFAULT_FONT_SCALE) {
                    so.m2470a(2, "VungleAd", "cta clickable area not scaled", null);
                } else {
                    obVar3.post(new Runnable(this) {
                        final /* synthetic */ oq f2781c;

                        public final void run() {
                            float sqrt = (float) Math.sqrt((double) f.floatValue());
                            int height = obVar3.getHeight();
                            int width = obVar3.getWidth();
                            int round = Math.round(((float) height) * sqrt);
                            int round2 = Math.round(sqrt * ((float) width));
                            so.m2470a(2, "VungleAd", "scaling cta clickable area " + f + "x - width: " + width + " --> " + round2 + ", height: " + height + " --> " + round, null);
                            Rect rect = new Rect();
                            obVar3.getHitRect(rect);
                            rect.bottom = rect.top + round;
                            rect.left = rect.right - round2;
                            this.f2781c.f2806h = new TouchDelegate(rect, obVar3);
                        }
                    });
                }
                if (Boolean.TRUE.equals(this.f2803e.f1832i)) {
                    obVar3.setAlpha(0.0f);
                    obVar3.setImageBitmap(this.f2791D);
                } else {
                    m2284d(this.f2798K >= this.f2796I);
                }
                obVar3.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ oq f2783b;

                    public final void onClick(View view) {
                        if (this.f2783b.f2797J) {
                            so.m2470a(3, "VungleAd", "cta overlay onClick", null);
                            obVar3.setOnClickListener(null);
                            this.f2783b.m2299b(false);
                            this.f2783b.f2813o.m2361a(new ai(C1798a.video_click));
                            return;
                        }
                        so.m2470a(2, "VungleAd", "cta overlay onClick, but not enabled", null);
                    }
                });
            }
            if (this.b.isIncentivized()) {
                num = this.f2803e.f1834k;
            } else {
                num = this.f2803e.f1835l;
            }
            if (num == null) {
                this.f2808j = 0;
                this.f2809k.set(true);
            } else {
                this.f2808j = num.intValue();
                obVar.setAlpha(0.0f);
                this.f2809k.set(false);
            }
            obVar.setOnClickListener(new C1854b(this));
            videoView.setOnTouchListener(new C18492(this));
            videoView.setOnCompletionListener(this);
            videoView.setOnErrorListener(this);
            videoView.setOnPreparedListener(this);
        } catch (Throwable th2) {
            so.m2471a("VungleAd", "exception in onActivityCreated", th2);
        }
    }

    public final void onSaveInstanceState(Bundle outState) {
        try {
            super.onSaveInstanceState(outState);
            outState.putParcelable("adConfig", (Parcelable) this.b);
            outState.putBoolean("adStarted", this.f2799L);
            outState.putInt("currentVideoPosition", this.f2801N);
        } catch (Throwable e) {
            this.c.m1865a("VungleAd", "exception in onSaveInstanceState", e);
        }
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        this.f2802O = mediaPlayer;
        m2302d();
        int duration = mediaPlayer.getDuration();
        so.m2470a(3, "VungleAd", "video ready: duration " + duration + " ms", null);
        this.f2821w.setMaxTimeMillis(duration);
        this.f2813o.m2361a(new ao(duration));
        if (!this.f2817s.mo4425a(getActivity())) {
            m2289f();
        }
    }

    public final void onResume() {
        try {
            super.onResume();
            so.m2470a(3, "VungleAd", "video onResume", null);
            ContentObserver contentObserver = this.f2819u;
            if (!contentObserver.f1495b) {
                contentObserver.f1494a = contentObserver.f1496c.m2161a();
                contentObserver.f1495b = true;
            }
            contentObserver.f1499f.getContentResolver().registerContentObserver(System.CONTENT_URI, true, contentObserver);
            m2289f();
        } catch (Throwable e) {
            this.c.m1865a("VungleAd", "error resuming VideoFragment", e);
            m2286e();
        }
    }

    public final void onPause() {
        so.m2470a(3, "VungleAd", "video onPause", null);
        try {
            super.onPause();
            if (this.f2824z.isPlaying()) {
                so.m2470a(3, "VungleAd", "Pausing video", null);
                this.f2801N = this.f2824z.getCurrentPosition();
                this.f2824z.pause();
                m2286e();
            }
            ContentObserver contentObserver = this.f2819u;
            contentObserver.f1499f.getContentResolver().unregisterContentObserver(contentObserver);
            if (this.f2799L) {
                this.f2813o.m2361a(new aw(this.f2824z.getCurrentPosition()));
            }
        } catch (Throwable e) {
            this.c.m1865a("VungleAd", "error in VideoFragment.onPause()", e);
            m2286e();
        }
    }

    public final void mo4506a(boolean z) {
        super.mo4506a(z);
        if (z) {
            onResume();
        } else {
            onPause();
        }
    }

    private void m2286e() {
        this.f2793F.removeCallbacks(this.f2794G);
    }

    private void m2289f() {
        boolean z = false;
        if (!this.f2824z.isPlaying()) {
            boolean z2;
            if (this.a == null || !this.a.isShowing()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                so.m2470a(2, "VungleAd", "Confirm dialog showing. Starting video briefly.", null);
                this.f2824z.seekTo(this.f2801N);
                this.f2824z.start();
                this.f2824z.pause();
                this.f2810l = this.f2801N;
                return;
            }
            so.m2470a(3, "VungleAd", "Starting video", null);
            if (!this.f2799L) {
                z = true;
            }
            this.f2799L = true;
            this.f2824z.requestFocus();
            this.f2824z.seekTo(this.f2801N);
            this.f2824z.start();
            this.f2810l = this.f2801N;
            m2300c();
            this.f2793F.post(this.f2794G);
            if (z) {
                this.f2813o.m2361a(new bc());
            }
        }
    }

    final void m2299b(boolean z) {
        Object amVar;
        m2286e();
        m2301c(z);
        qh qhVar = this.f2813o;
        if (z) {
            amVar = new am(this.f2810l);
        } else {
            amVar = new ap(this.f2810l);
        }
        qhVar.m2361a(amVar);
        this.f2799L = false;
        this.f2824z.seekTo(0);
        this.f2810l = 0;
        this.f2801N = 0;
        this.f2800M.set(false);
    }

    final void m2301c(boolean z) {
        int duration = z ? this.f2824z.getDuration() : this.f2824z.getCurrentPosition();
        if (duration > this.f2810l) {
            this.f2810l = duration;
        }
    }

    public final void mo4505a() {
        so.m2470a(2, "VungleAd", "back button pressed", null);
        m2290f(true);
    }

    final void m2300c() {
        boolean z = true;
        if (!Boolean.TRUE.equals(this.f2803e.f1831h)) {
            return;
        }
        if (Boolean.TRUE.equals(this.f2803e.f1832i)) {
            if (this.f2804f.getAlpha() < TextTrackStyle.DEFAULT_FONT_SCALE) {
                z = false;
            }
            m2287e(z);
            return;
        }
        if (this.f2810l > (this.f2798K * 1000) - 750 && this.f2807i.compareAndSet(false, true)) {
            ObjectAnimator.ofFloat(this.f2804f, "alpha", new float[]{TextTrackStyle.DEFAULT_FONT_SCALE}).setDuration(750).start();
        }
        if (this.f2810l < this.f2796I * 1000) {
            z = false;
        }
        m2287e(z);
    }

    private void m2284d(boolean z) {
        String str;
        boolean z2 = z && this.f2795H != null;
        String str2 = "VungleAd";
        StringBuilder stringBuilder = new StringBuilder("cta button ");
        if (z2) {
            str = "enabled";
        } else {
            str = "disabled";
        }
        so.m2470a(2, str2, stringBuilder.append(str).toString(), null);
        this.f2797J = z2;
        this.f2804f.setImageBitmap(z2 ? this.f2791D : this.f2792E);
    }

    private void m2287e(boolean z) {
        if (z != this.f2797J) {
            m2284d(z);
        }
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        so.m2470a(3, "VungleAd", "video.onCompletion", null);
        m2299b(true);
        this.f2802O = null;
        this.f2813o.m2361a(new bh());
    }

    public final boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        so.m2470a(6, "VungleAd", "video.onError: " + what + ", " + extra, null);
        m2299b(false);
        this.f2813o.m2361a(new bh());
        return true;
    }

    private void m2292g() {
        m2299b(false);
        this.f2824z.stopPlayback();
        this.f2813o.m2361a(new bg());
    }

    private void m2290f(boolean z) {
        if (z) {
            boolean z2;
            if (this.f2809k.get() || this.b.isBackButtonImmediatelyEnabled()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return;
            }
        } else if (!this.f2809k.get()) {
            return;
        }
        if (this.f2800M.compareAndSet(false, true)) {
            so.m2470a(3, "VungleAd", "exiting video", null);
            if (this.b.isIncentivized()) {
                AlertDialog alertDialog;
                onPause();
                if (this.a != null) {
                    alertDialog = this.a;
                } else {
                    alertDialog = this.d.m2193a(getActivity(), this.b, new C18525(this));
                }
                this.a = alertDialog;
                alertDialog.show();
                return;
            }
            this.f2805g.setOnClickListener(null);
            m2292g();
        }
    }

    final void m2302d() {
        so.m2470a(3, "VungleAd", "refresh mute state. isAdMuted = " + this.f2811m.get(), null);
        this.f2822x.setImageBitmap(this.f2811m.get() ? this.f2789B : this.f2790C);
        if (this.f2811m.get()) {
            try {
                if (this.f2802O != null) {
                    so.m2470a(3, "VungleAd", "Muting the video", null);
                    this.f2802O.setVolume(0.0f, 0.0f);
                    return;
                }
                return;
            } catch (IllegalStateException e) {
                so.m2470a(4, "VungleAd", "Failed to mute the video: " + e.getMessage(), null);
                return;
            }
        }
        try {
            if (this.f2802O != null) {
                so.m2470a(3, "VungleAd", "Unmuting the video", null);
                float b = this.f2820v.m2162b();
                this.f2802O.setVolume(b, b);
            }
        } catch (IllegalStateException e2) {
            so.m2470a(4, "VungleAd", "Failed to unmute the video: " + e2.getMessage(), null);
        }
    }

    public final String mo4507b() {
        return "videoFragment";
    }
}
