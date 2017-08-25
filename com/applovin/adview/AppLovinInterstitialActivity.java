package com.applovin.adview;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.C0096w;
import com.applovin.impl.adview.C0122u;
import com.applovin.impl.adview.C0140s;
import com.applovin.impl.adview.ah;
import com.applovin.impl.adview.ap;
import com.applovin.impl.adview.aq;
import com.applovin.impl.adview.ar;
import com.applovin.impl.adview.as;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinAdImpl.AdTarget;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0163n;
import com.applovin.impl.sdk.ay;
import com.applovin.impl.sdk.ch;
import com.applovin.impl.sdk.dp;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.cast.TextTrackStyle;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinInterstitialActivity extends Activity implements C0096w {
    public static final String KEY_WRAPPER_ID = "com.applovin.interstitial.wrapper_id";
    public static volatile ah lastKnownWrapper = null;
    private Handler f3A;
    private FrameLayout f4B;
    private AppLovinVideoView f5C;
    private C0122u f6D;
    private View f7E;
    private C0122u f8F;
    private View f9G;
    private C0140s f10H;
    private volatile UUID f11I;
    private ImageView f12J;
    private WeakReference f13K = new WeakReference(null);
    private ay f14L;
    private aq f15M;
    private as f16N;
    private AppLovinAdView f17a;
    private ah f18b;
    private volatile boolean f19c = false;
    private AppLovinLogger f20d;
    private ch f21e;
    private AppLovinSdkImpl f22f;
    private volatile AppLovinAdImpl f23g = dp.m695a();
    private volatile boolean f24h = false;
    private volatile boolean f25i = false;
    private volatile boolean f26j = false;
    private volatile boolean f27k = false;
    private volatile boolean f28l = false;
    private volatile boolean f29m = false;
    private volatile boolean f30n = false;
    private volatile boolean f31o = false;
    private volatile boolean f32p = false;
    private boolean f33q = false;
    private volatile boolean f34r = false;
    private volatile boolean f35s = false;
    private boolean f36t = true;
    private boolean f37u = false;
    private int f38v = 0;
    private boolean f39w = false;
    private long f40x = 0;
    private double f41y = 0.0d;
    private AtomicBoolean f42z = new AtomicBoolean(false);

    private boolean m2A() {
        return !this.f23g.isVideoAd() && m93z();
    }

    private void m5B() {
        if (this.f19c && !this.f39w) {
            return;
        }
        if (this.f17a != null) {
            this.f17a.setAdDisplayListener(new C0107k(this));
            this.f17a.setAdClickListener(new C0108l(this));
            this.f23g = (AppLovinAdImpl) this.f18b.m140b();
            m56h();
            m62k();
            this.f35s = this.f23g.isVideoStream();
            if (this.f35s) {
                this.f20d.mo635d("AppLovinInterstitialActivity", "Preparing stream for " + this.f23g.getVideoUri());
            } else {
                this.f20d.mo635d("AppLovinInterstitialActivity", "Preparing cached video playback for " + this.f23g.getVideoUri());
            }
            m23a(this.f23g.getVideoUri());
            this.f6D.bringToFront();
            if (m71o() && this.f7E != null) {
                this.f7E.bringToFront();
            }
            if (this.f8F != null) {
                this.f8F.bringToFront();
            }
            this.f17a.renderAd(this.f23g, this.f18b.m145g());
            this.f18b.m139a(true);
            if (!this.f23g.isVideoAd()) {
                if (m2A() && this.f21e.m527T()) {
                    m49d(this.f23g);
                }
                m6C();
                return;
            }
            return;
        }
        exitWithError("AdView was null");
    }

    private void m6C() {
        try {
            if (this.f5C != null) {
                this.f41y = m12I();
                this.f5C.stopPlayback();
            }
            if (this.f17a != null) {
                ViewParent parent = this.f17a.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f17a);
                }
                View frameLayout = new FrameLayout(this);
                frameLayout.setLayoutParams(new LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                frameLayout.addView(this.f17a);
                if (this.f4B != null) {
                    this.f4B.removeAllViewsInLayout();
                }
                if (m71o() && this.f7E != null) {
                    frameLayout.addView(this.f7E);
                    this.f7E.bringToFront();
                }
                if (this.f6D != null) {
                    parent = this.f6D.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.f6D);
                    }
                    frameLayout.addView(this.f6D);
                    this.f6D.bringToFront();
                }
                setContentView(frameLayout);
            }
            if (this.f23g.isCloseButtonHidden()) {
                this.f20d.mo635d("AppLovinInterstitialActivity", "Skip showing of close button");
            } else if (this.f23g.getCloseDelay() >= 0.0f) {
                m22a(dp.m707c(this.f23g.getCloseDelay()), this.f6D);
            } else if (this.f23g.getCloseDelay() == -2.0f) {
                this.f6D.setVisibility(0);
            } else {
                m22a(0, this.f6D);
            }
            this.f32p = true;
        } catch (Throwable th) {
            this.f20d.mo637e("AppLovinInterstitialActivity", "Encountered error while showing poststitial. Dismissing...", th);
            dismiss();
        }
    }

    private void m7D() {
        boolean z = !m8E();
        m40b(z);
        m30a(z);
    }

    private boolean m8E() {
        return this.f34r;
    }

    private void m9F() {
        Editor edit = m14K().edit();
        edit.putInt("com.applovin.interstitial.last_video_position", this.f5C.getCurrentPosition());
        edit.putBoolean("com.applovin.interstitial.should_resume_video", true);
        edit.commit();
        this.f5C.pause();
    }

    private void m10G() {
        SharedPreferences K = m14K();
        if (this.f5C != null) {
            int duration = this.f5C.getDuration();
            int i = K.getInt("com.applovin.interstitial.last_video_position", duration);
            duration -= i;
            m81t();
            this.f5C.seekTo(i);
            this.f5C.start();
            m20a(duration);
        }
    }

    private void m11H() {
        if (!this.f28l) {
            if (this.f23g.isVideoAd()) {
                double I = m12I();
                String parametrizedCompletionUrl = this.f23g.getParametrizedCompletionUrl((int) I, this.f18b != null ? this.f18b.m145g() : null, this.f35s);
                if (AppLovinSdkUtils.isValidString(parametrizedCompletionUrl)) {
                    this.f22f.getPostbackService().dispatchPostbackAsync(parametrizedCompletionUrl, null);
                } else {
                    this.f20d.mo636e("AppLovinInterstitialActivity", "Received invalid placement aware parameterized video completion url. No postback dispatched.");
                }
                m29a(this.f23g, I, m13J());
            } else if (m2A() && this.f21e.m527T()) {
                float mraidCloseDelay = this.f23g.getMraidCloseDelay();
                if (mraidCloseDelay <= 0.0f) {
                    mraidCloseDelay = this.f23g.getCloseDelay();
                }
                int min = (int) Math.min((dp.m690a(System.currentTimeMillis() - this.f40x) / ((double) mraidCloseDelay)) * 100.0d, 100.0d);
                this.f20d.mo635d("AppLovinInterstitialActivity", "Rewarded playable engaged at " + min + " percent");
                m29a(this.f23g, (double) min, min >= 95);
            }
        }
    }

    private double m12I() {
        if (this.f29m) {
            return 100.0d;
        }
        if (this.f5C != null) {
            int duration = this.f5C.getDuration();
            return duration > 0 ? 100.0d * (((double) this.f5C.getCurrentPosition()) / ((double) duration)) : this.f41y;
        } else {
            this.f20d.mo636e("AppLovinInterstitialActivity", "No video view detected on video end");
            return 0.0d;
        }
    }

    private boolean m13J() {
        return m12I() >= 95.0d;
    }

    private SharedPreferences m14K() {
        return getSharedPreferences("com.applovin.interstitial.sharedpreferences", 0);
    }

    private int m15a(int i, boolean z) {
        if (z) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            if (i == 3) {
                return 1;
            }
        } else if (i == 0) {
            return 1;
        } else {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            if (i == 3) {
                return 8;
            }
        }
        return -1;
    }

    private static int m16a(Display display) {
        return display.getWidth() == display.getHeight() ? 3 : display.getWidth() < display.getHeight() ? 1 : 2;
    }

    private void m20a(int i) {
        m36b((int) (((float) i) - dp.m691a((float) TextTrackStyle.DEFAULT_FONT_SCALE)));
    }

    private void m21a(int i, UUID uuid) {
        if (this.f10H != null && uuid.equals(this.f11I)) {
            if (i <= 0) {
                this.f10H.setVisibility(8);
                this.f37u = true;
            } else if (!this.f37u) {
                int i2 = i - 1;
                this.f10H.m190a(i2);
                this.f3A.postDelayed(new C0103g(this, i2, uuid), 1000);
            }
        }
    }

    private void m22a(long j, C0122u c0122u) {
        this.f3A.postDelayed(new C0102f(this, c0122u), j);
    }

    private void m23a(Uri uri) {
        this.f5C = new AppLovinVideoView(this);
        this.f5C.setOnPreparedListener(new C0109m(this));
        this.f5C.setOnCompletionListener(new C0112p(this));
        this.f5C.setOnErrorListener(new C0113q(this));
        this.f5C.setVideoURI(uri);
        this.f5C.setLayoutParams(new LayoutParams(-1, -1, 17));
        this.f5C.setOnTouchListener(new AppLovinTouchToClickListener(this, new C0115s(this)));
        this.f4B.addView(this.f5C);
        setContentView(this.f4B);
        m74q();
    }

    private void m24a(View view, boolean z, long j) {
        float f = TextTrackStyle.DEFAULT_FONT_SCALE;
        float f2 = z ? 0.0f : TextTrackStyle.DEFAULT_FONT_SCALE;
        if (!z) {
            f = 0.0f;
        }
        Animation alphaAnimation = new AlphaAnimation(f2, f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setAnimationListener(new C0098b(this, view, z));
        view.startAnimation(alphaAnimation);
    }

    private void m28a(AppLovinAd appLovinAd) {
        AppLovinAdDisplayListener d = this.f18b.m142d();
        if (d != null) {
            d.adDisplayed(appLovinAd);
        }
        this.f25i = true;
    }

    private void m29a(AppLovinAd appLovinAd, double d, boolean z) {
        this.f28l = true;
        AppLovinAdVideoPlaybackListener c = this.f18b.m141c();
        if (c != null) {
            c.videoPlaybackEnded(appLovinAd, d, z);
        }
    }

    private void m30a(boolean z) {
        AppLovinSdkUtils.safePopulateImageView(this.f12J, z ? this.f23g.getMuteImageUri() : this.f23g.getUnmuteImageUri(), m42c(this.f21e.m510C()));
    }

    private boolean m31a() {
        return (this.f18b == null || this.f21e == null || this.f21e.m528a()) ? true : (this.f21e.m530c() && this.f30n) ? true : this.f21e.m529b() && this.f32p;
    }

    private void m35b() {
        if (this.f23g.isVideoClickableDuringPlayback() && AppLovinSdkUtils.isValidString(this.f23g.getClickDestinationUrl())) {
            this.f22f.getLogger().mo635d("AppLovinInterstitialActivity", "Clicking through video...");
            m44c();
            return;
        }
        m47d();
        m51e();
    }

    private void m36b(int i) {
        m21a(i, this.f11I);
    }

    private void m37b(int i, boolean z) {
        int i2 = 0;
        int i3 = 1;
        boolean S = this.f21e.m526S();
        if (this.f18b.m144f() == AdTarget.ACTIVITY_PORTRAIT) {
            if (z) {
                if (i != 1 && i != 3) {
                    this.f19c = true;
                    setRequestedOrientation(1);
                } else if (S) {
                    if (i != 1) {
                        i3 = 9;
                    }
                    setRequestedOrientation(i3);
                }
            } else if (i != 0 && i != 2) {
                this.f19c = true;
                setRequestedOrientation(1);
            } else if (S) {
                if (i != 0) {
                    i3 = 9;
                }
                setRequestedOrientation(i3);
            }
        } else if (this.f18b.m144f() != AdTarget.ACTIVITY_LANDSCAPE) {
        } else {
            if (z) {
                if (i != 0 && i != 2) {
                    this.f19c = true;
                    setRequestedOrientation(0);
                } else if (S) {
                    setRequestedOrientation(i == 2 ? 8 : 0);
                }
            } else if (i != 1 && i != 3) {
                this.f19c = true;
                setRequestedOrientation(0);
            } else if (S) {
                if (i != 1) {
                    i2 = 8;
                }
                setRequestedOrientation(i2);
            }
        }
    }

    private void m39b(AppLovinAd appLovinAd) {
        dismiss();
        m45c(appLovinAd);
    }

    private void m40b(boolean z) {
        this.f34r = z;
        MediaPlayer mediaPlayer = (MediaPlayer) this.f13K.get();
        if (mediaPlayer != null) {
            int i = z ? 0 : 1;
            mediaPlayer.setVolume((float) i, (float) i);
        }
    }

    private int m42c(int i) {
        return AppLovinSdkUtils.dpToPx(this, i);
    }

    private void m44c() {
        try {
            ((AppLovinAdServiceImpl) this.f22f.getAdService()).trackAndLaunchVideoClick(this.f23g, this.f18b.m145g(), this.f17a, Uri.parse(this.f23g.getClickDestinationUrl()));
            AppLovinAdClickListener e = this.f18b.m143e();
            if (e != null) {
                e.adClicked(this.f23g);
            }
        } catch (Throwable th) {
            this.f22f.getLogger().mo637e("AppLovinInterstitialActivity", "Encountered error while clicking through video.", th);
        }
    }

    private void m45c(AppLovinAd appLovinAd) {
        if (!this.f26j) {
            this.f26j = true;
            if (this.f18b != null) {
                AppLovinAdDisplayListener d = this.f18b.m142d();
                if (d != null) {
                    d.adHidden(appLovinAd);
                }
            }
        }
    }

    private void m47d() {
        if (this.f21e.m553z() && this.f10H != null && this.f10H.getVisibility() != 8) {
            m24a(this.f10H, this.f10H.getVisibility() == 4, 750);
        }
    }

    private void m49d(AppLovinAd appLovinAd) {
        if (!this.f27k) {
            this.f27k = true;
            AppLovinAdVideoPlaybackListener c = this.f18b.m141c();
            if (c != null) {
                c.videoPlaybackBegan(appLovinAd);
            }
        }
    }

    private void m51e() {
        ap videoButtonProperties = this.f23g.getVideoButtonProperties();
        if (videoButtonProperties != null && videoButtonProperties.m161e() && !this.f32p && this.f15M != null) {
            m24a(this.f15M, this.f15M.getVisibility() == 4, (long) videoButtonProperties.m162f());
        }
    }

    private void m52f() {
        Editor edit = m14K().edit();
        edit.putBoolean("com.applovin.interstitial.should_resume_video", false);
        edit.putInt("com.applovin.interstitial.last_video_position", 0);
        edit.commit();
    }

    private boolean m55g() {
        return m14K().getInt("com.applovin.interstitial.last_video_position", 0) > 0 ? this.f34r : this.f21e.m516I() ? this.f22f.getSettings().isMuted() : this.f21e.m514G();
    }

    private void m56h() {
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f4B = new FrameLayout(this);
        this.f4B.setLayoutParams(layoutParams);
        this.f4B.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3A = new Handler();
    }

    private void m58i() {
        if (this.f42z.compareAndSet(false, true)) {
            if (this.f21e.m538k()) {
                this.f20d.mo636e("AppLovinInterstitialActivity", "Handling media player error - Finishing activity...");
                finish();
            } else {
                this.f20d.mo636e("AppLovinInterstitialActivity", "Handling media player error - Showing poststitial...");
                m6C();
            }
            this.f20d.mo636e("AppLovinInterstitialActivity", "Finished handling media player error.");
            return;
        }
        this.f20d.mo636e("AppLovinInterstitialActivity", "Already handled media player error. Doing nothing...");
    }

    private void m60j() {
        m49d(this.f23g);
        this.f5C.start();
        m36b(m78s());
    }

    private void m62k() {
        int i = 3;
        this.f6D = C0122u.m147a(this.f22f, this, this.f23g.getCloseButtonStyle());
        this.f6D.setVisibility(8);
        this.f6D.setOnClickListener(new C0116t(this));
        int c = m42c(this.f21e.m540m());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(c, c, (this.f21e.m551x() ? 3 : 5) | 48);
        this.f6D.mo547a(c);
        int c2 = m42c(this.f21e.m542o());
        int c3 = m42c(this.f21e.m544q());
        layoutParams.setMargins(c3, c2, c3, c2);
        this.f4B.addView(this.f6D, layoutParams);
        this.f8F = C0122u.m147a(this.f22f, this, this.f23g.getSkipButtonStyle());
        this.f8F.setVisibility(8);
        this.f8F.setOnClickListener(new C0117u(this));
        layoutParams = new LayoutParams(c, c, (this.f21e.m550w() ? 3 : 5) | 48);
        layoutParams.setMargins(c3, c2, c3, c2);
        this.f8F.mo547a(c);
        this.f4B.addView(this.f8F, layoutParams);
        this.f8F.bringToFront();
        if (m71o()) {
            int c4 = m42c(new ch(this.f22f).m545r());
            this.f7E = new View(this);
            this.f7E.setBackgroundColor(0);
            this.f7E.setVisibility(8);
            this.f9G = new View(this);
            this.f9G.setBackgroundColor(0);
            this.f9G.setVisibility(8);
            c += c4;
            int c5 = c2 - m42c(5);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(c, c, (this.f21e.m551x() ? 3 : 5) | 48);
            layoutParams2.setMargins(c5, c5, c5, c5);
            if (!this.f21e.m550w()) {
                i = 5;
            }
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(c, c, i | 48);
            layoutParams3.setMargins(c5, c5, c5, c5);
            this.f7E.setOnClickListener(new C0118v(this));
            this.f9G.setOnClickListener(new C0119w(this));
            this.f4B.addView(this.f7E, layoutParams2);
            this.f7E.bringToFront();
            this.f4B.addView(this.f9G, layoutParams3);
            this.f9G.bringToFront();
        }
    }

    private void m64l() {
        try {
            this.f34r = m55g();
            if (this.f12J == null) {
                this.f12J = new ImageView(this);
                if (m67m()) {
                    this.f22f.getLogger().mo635d("AppLovinInterstitialActivity", "Mute button should be hidden");
                    return;
                }
                int c = m42c(this.f21e.m510C());
                ViewGroup.LayoutParams layoutParams = new LayoutParams(c, c, this.f21e.m511D());
                this.f12J.setScaleType(ScaleType.FIT_CENTER);
                c = m42c(this.f21e.m512E());
                layoutParams.setMargins(c, c, c, c);
                Object muteImageUri = this.f34r ? this.f23g.getMuteImageUri() : this.f23g.getUnmuteImageUri();
                if (muteImageUri != null) {
                    this.f22f.getLogger().mo635d("AppLovinInterstitialActivity", "Added mute button with params: " + layoutParams);
                    m30a(this.f34r);
                    this.f12J.setClickable(true);
                    this.f12J.setOnClickListener(new C0099c(this));
                    this.f4B.addView(this.f12J, layoutParams);
                    this.f12J.bringToFront();
                    return;
                }
                this.f22f.getLogger().mo636e("AppLovinInterstitialActivity", "Attempting to add mute button but could not find uri = " + muteImageUri);
            }
        } catch (Throwable e) {
            this.f22f.getLogger().mo642w("AppLovinInterstitialActivity", "Failed to attach mute button", e);
        }
    }

    private boolean m67m() {
        return !this.f21e.m508A() ? true : this.f21e.m509B() ? m55g() ? false : !this.f21e.m515H() : false;
    }

    private void m69n() {
        runOnUiThread(new C0100d(this));
    }

    private boolean m71o() {
        return this.f21e.m545r() > 0;
    }

    private void m72p() {
        runOnUiThread(new C0101e(this));
    }

    private void m74q() {
        if (this.f23g.getVideoCloseDelay() >= 0.0f) {
            C0122u c0122u = (!this.f33q || this.f8F == null) ? this.f6D : this.f8F;
            m22a(dp.m707c(this.f23g.getVideoCloseDelay()), c0122u);
        }
    }

    private void m76r() {
        if (this.f10H == null) {
            this.f10H = new C0140s(this);
            int u = m82u();
            this.f10H.m195c(u);
            this.f10H.m192b((float) this.f21e.m535h());
            this.f10H.m197d(u);
            this.f10H.m189a((float) this.f21e.m534g());
            this.f10H.m193b(m78s());
            ViewGroup.LayoutParams layoutParams = new LayoutParams(m42c(this.f21e.m533f()), m42c(this.f21e.m533f()), this.f21e.m549v());
            int c = m42c(this.f21e.m548u());
            layoutParams.setMargins(c, c, c, c);
            this.f4B.addView(this.f10H, layoutParams);
            this.f10H.bringToFront();
            C0140s c0140s = this.f10H;
            u = (!this.f21e.m536i() || m78s() <= 0) ? 4 : 0;
            c0140s.setVisibility(u);
        }
    }

    private int m78s() {
        int countdownLength = this.f23g.getCountdownLength();
        return (countdownLength <= 0 && this.f21e.m547t()) ? this.f38v + 1 : countdownLength;
    }

    private void m81t() {
        this.f11I = UUID.randomUUID();
    }

    private int m82u() {
        return Color.parseColor(this.f21e.m531d());
    }

    private void m85v() {
        ap videoButtonProperties = this.f23g.getVideoButtonProperties();
        if (AppLovinSdkUtils.isValidString(this.f23g.getVideoButtonHtmlSource()) && videoButtonProperties != null && this.f15M == null) {
            this.f20d.mo638i("AppLovinInterstitialActivity", "Attaching video button...");
            this.f15M = m86w();
            double b = ((double) videoButtonProperties.m158b()) / 100.0d;
            ViewGroup.LayoutParams layoutParams = new LayoutParams((int) ((((double) videoButtonProperties.m157a()) / 100.0d) * ((double) this.f5C.getWidth())), (int) (((double) this.f5C.getHeight()) * b), videoButtonProperties.m160d());
            int c = m42c(videoButtonProperties.m159c());
            layoutParams.setMargins(c, c, c, c);
            this.f4B.addView(this.f15M, layoutParams);
            this.f15M.bringToFront();
            if (videoButtonProperties.m165i() > 0.0f) {
                this.f15M.setVisibility(4);
                this.f3A.postDelayed(new C0104h(this, videoButtonProperties), dp.m707c(videoButtonProperties.m165i()));
            }
            if (videoButtonProperties.m166j() > 0.0f) {
                this.f3A.postDelayed(new C0105i(this, videoButtonProperties), dp.m707c(videoButtonProperties.m166j()));
            }
        }
    }

    private aq m86w() {
        this.f20d.mo635d("AppLovinInterstitialActivity", "Create video button with HTML = " + this.f23g.getVideoButtonHtmlSource());
        ar arVar = new ar(this.f22f);
        this.f16N = new C0106j(this);
        arVar.m169a(new WeakReference(this.f16N));
        aq aqVar = new aq(arVar, getApplicationContext());
        aqVar.m167a(this.f23g.getVideoButtonHtmlSource());
        return aqVar;
    }

    private void m88x() {
        if (m91y()) {
            m9F();
            this.f14L.m344b();
            return;
        }
        skipVideo();
    }

    private boolean m91y() {
        return !m13J() && m93z() && this.f21e.m523P() && this.f14L != null;
    }

    private boolean m93z() {
        return AppLovinAdType.INCENTIVIZED.equals(this.f23g.getType());
    }

    public void continueVideo() {
        m10G();
    }

    public void dismiss() {
        ((AdViewControllerImpl) this.f17a.getAdViewController()).setIsForegroundClickInvalidated(true);
        m52f();
        m11H();
        if (this.f18b != null) {
            if (this.f23g != null) {
                m45c(this.f23g);
            }
            this.f18b.m139a(false);
            this.f18b.m146h();
        }
        finish();
    }

    public void exitWithError(String str) {
        try {
            Log.e("AppLovinInterstitialActivity", "Failed to properly render an Interstitial Activity, due to error: " + str, new Throwable("Initialized = " + ah.f130a + "; CleanedUp = " + ah.f131b));
            m45c(dp.m695a());
        } catch (Throwable e) {
            Log.e("AppLovinInterstitialActivity", "Failed to show a video ad due to error:", e);
        }
        finish();
    }

    public void onBackPressed() {
        if (m31a()) {
            this.f20d.mo635d("AppLovinInterstitialActivity", "Back button was pressed; forwarding to Android for handling...");
            super.onBackPressed();
            return;
        }
        try {
            if (this.f33q && this.f8F != null && this.f8F.getVisibility() == 0 && this.f8F.getAlpha() > 0.0f && !this.f30n) {
                this.f20d.mo635d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to skip button.");
                this.f8F.performClick();
            } else if (this.f6D == null || this.f6D.getVisibility() != 0 || this.f6D.getAlpha() <= 0.0f) {
                this.f20d.mo635d("AppLovinInterstitialActivity", "Back button was pressed, but was not eligible for dismissal.");
            } else {
                this.f20d.mo635d("AppLovinInterstitialActivity", "Back button was pressed; forwarding as a click to close button.");
                this.f6D.performClick();
            }
        } catch (Exception e) {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        requestWindowFeature(1);
        String stringExtra = getIntent().getStringExtra(KEY_WRAPPER_ID);
        if (stringExtra == null || stringExtra.isEmpty()) {
            exitWithError("Wrapper ID is null");
        } else {
            this.f18b = ah.m124a(stringExtra);
            if (this.f18b == null && lastKnownWrapper != null) {
                this.f18b = lastKnownWrapper;
            }
            if (this.f18b != null) {
                AppLovinAd b = this.f18b.m140b();
                this.f22f = (AppLovinSdkImpl) this.f18b.m137a();
                this.f20d = this.f18b.m137a().getLogger();
                this.f21e = new ch(this.f18b.m137a());
                if (b != null) {
                    this.f40x = System.currentTimeMillis();
                    if (((AppLovinAdImpl) b).isAccelerateHardware()) {
                        getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
                    }
                    Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                    int a = m16a(defaultDisplay);
                    int rotation = defaultDisplay.getRotation();
                    boolean z2 = (a == 2 && rotation == 0) || ((a == 2 && rotation == 2) || ((a == 1 && rotation == 1) || (a == 1 && rotation == 3)));
                    if (((AppLovinAdImpl) b).isLockCurrentOrientation()) {
                        int a2 = m15a(rotation, z2);
                        if (a2 != -1) {
                            this.f20d.mo635d("AppLovinInterstitialActivity", "Locking activity orientation to current orientation: " + a2);
                            setRequestedOrientation(a2);
                        } else {
                            this.f20d.mo636e("AppLovinInterstitialActivity", "Unable to detect current orientation. Locking to targeted orientation...");
                            m37b(rotation, z2);
                        }
                    } else {
                        this.f20d.mo635d("AppLovinInterstitialActivity", "Locking activity orientation to targeted orientation...");
                        m37b(rotation, z2);
                    }
                    this.f17a = new AppLovinAdView(this.f22f, AppLovinAdSize.INTERSTITIAL, (Activity) this);
                    this.f17a.setAutoDestroy(false);
                    this.f18b.m138a((C0096w) this);
                    this.f33q = this.f21e.m546s();
                    if (!(C0163n.m731a(getApplicationContext()) || C0163n.m731a(getApplicationContext()))) {
                        z = false;
                    }
                    this.f39w = z;
                    this.f14L = new ay(this.f22f, this);
                } else {
                    exitWithError("No current ad found.");
                }
            } else {
                exitWithError("Wrapper is null; initialized state: " + Boolean.toString(ah.f130a));
            }
        }
        Editor edit = m14K().edit();
        edit.putBoolean("com.applovin.interstitial.should_resume_video", false);
        edit.commit();
        m52f();
        m5B();
    }

    protected void onDestroy() {
        try {
            if (this.f17a != null) {
                ViewParent parent = this.f17a.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.f17a);
                }
                this.f17a.destroy();
                this.f17a = null;
            }
            if (this.f5C != null) {
                this.f5C.pause();
                this.f5C.stopPlayback();
            }
        } catch (Throwable th) {
            this.f20d.mo642w("AppLovinInterstitialActivity", "Unable to destroy video view", th);
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (!this.f24h) {
            if (this.f39w) {
                m9F();
            } else if (!this.f19c) {
                m9F();
            }
        }
        this.f18b.m139a(false);
        this.f14L.m343a();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.f18b.m139a(true);
        if (!this.f36t) {
            if (m14K().getBoolean("com.applovin.interstitial.should_resume_video", false) && !this.f14L.m345c() && !this.f32p) {
                m10G();
                if (!(!this.f21e.m537j() || this.f23g.isHideVideoCloseButtonOnExit() || this.f32p || !this.f33q || this.f8F == null)) {
                    m22a(0, this.f8F);
                }
            } else if (!(!this.f21e.m537j() || this.f23g.isHideCloseButtonOnExit() || !this.f32p || this.f6D == null || this.f23g.isCloseButtonHidden())) {
                m22a(0, this.f6D);
            }
        }
        this.f36t = false;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            try {
                if (C0163n.m737c() && this.f21e.m522O()) {
                    getWindow().getDecorView().setSystemUiVisibility(5894);
                } else {
                    getWindow().setFlags(1024, 1024);
                }
            } catch (Throwable th) {
                this.f20d.mo637e("AppLovinInterstitialActivity", "Setting window flags failed.", th);
            }
        }
    }

    public void skipVideo() {
        if (this.f23g.getDismissOnSkip()) {
            dismiss();
        } else {
            m6C();
        }
    }
}
