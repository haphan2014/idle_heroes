package com.vungle.publisher;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.WindowInsets;
import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.cu.C1721b.C17202;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.ni.C1832a;
import com.vungle.publisher.ni.C1832a.C18311;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class C1618d extends Activity {
    ni<cu> f746a;
    @Inject
    qh f747b;
    @Inject
    ch f748c;
    @Inject
    pu f749d;
    @Inject
    C1721b f750e;
    @Inject
    mc f751f;
    @Inject
    C1778a f752g;
    @Inject
    C1832a f753h;
    @Inject
    ac f754i;
    private View f755j;

    /* compiled from: vungle */
    class C17252 implements OnApplyWindowInsetsListener {
        final /* synthetic */ C1618d f1583a;

        C17252(C1618d c1618d) {
            this.f1583a = c1618d;
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets insets) {
            int i = 0;
            try {
                int stableInsetLeft;
                int stableInsetTop;
                int stableInsetRight;
                if (this.f1583a.isInMultiWindowMode() && insets.hasStableInsets()) {
                    stableInsetLeft = insets.getStableInsetLeft();
                    stableInsetTop = insets.getStableInsetTop();
                    stableInsetRight = insets.getStableInsetRight();
                    i = insets.getStableInsetBottom();
                } else {
                    stableInsetRight = 0;
                    stableInsetTop = 0;
                    stableInsetLeft = 0;
                }
                this.f1583a.f755j.getRootView().setPadding(stableInsetLeft, stableInsetTop, stableInsetRight, i);
            } catch (Throwable e) {
                so.m2471a("VungleAd", "Exception setting root view padding to avoid system controls overlap", e);
            }
            return insets;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            so.m2470a(3, "VungleAd", "interstitial ad", null);
            if (Injector.getInstance().m1976c()) {
                Injector.m1974b().mo4526a(this);
                getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
                Intent intent = getIntent();
                C1617z c1617z = (C1617z) intent.getBundleExtra("adConfig").getParcelable("adConfig");
                String stringExtra = intent.getStringExtra("adId");
                cu cuVar = (cu) new C17202(this.f750e, stringExtra).m811a((C1893v) intent.getSerializableExtra("adType"));
                if (cuVar == null) {
                    so.m2470a(5, "VungleAd", "no ad in activity", null);
                    this.f747b.m2361a(new bw());
                    finish();
                    return;
                }
                so.m2470a(3, "VungleAd", "creating ad activity with status: " + cuVar.m1334g(), null);
                this.f746a = (ni) new C18311(this.f753h).m810a(cuVar);
                this.f755j = getWindow().getDecorView();
                m801a(c1617z);
                if (VERSION.SDK_INT >= 24) {
                    this.f755j.setOnApplyWindowInsetsListener(new C17252(this));
                }
                this.f746a.mo4516a(this, cuVar, c1617z, savedInstanceState);
                return;
            }
            so.m2470a(5, "VungleAd", "SDK not initialized", null);
            finish();
        } catch (Throwable e) {
            so.m2471a("VungleAd", "error playing ad", e);
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        try {
            super.onSaveInstanceState(outState);
            ni niVar = this.f746a;
            try {
                outState.putString("currentFragment", niVar.f2639c.mo4507b());
            } catch (Throwable e) {
                niVar.f2644h.m1865a("VungleAd", "error in onSaveInstanceState", e);
            }
        } catch (Throwable e2) {
            this.f752g.m1865a("VungleAd", "error in onSaveInstanceState", e2);
        }
    }

    final void m801a(final C1617z c1617z) {
        if (VERSION.SDK_INT >= 19 && c1617z.isImmersiveMode()) {
            this.f755j.setSystemUiVisibility(5894);
            this.f755j.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
                final /* synthetic */ C1618d f1582b;

                public final void onSystemUiVisibilityChange(int visibility) {
                    if ((visibility & 4) == 0) {
                        this.f1582b.m801a(c1617z);
                    }
                }
            });
        }
    }

    protected void onResume() {
        try {
            super.onResume();
            pu puVar = this.f749d;
            so.m2470a(3, "VungleAd", "onAdActivityResume()", null);
            puVar.m2349a(false);
            puVar.f2940i.f2904e = 0;
            mc mcVar = this.f751f;
            so.m2470a(2, "VungleDevice", "ad requests audio focus", null);
            if (mcVar.f2554a) {
                so.m2470a(2, "VungleDevice", "ad already has audio focus", null);
            } else if (mcVar.f2555b.requestAudioFocus(mcVar, 3, 3) == 1) {
                so.m2470a(2, "VungleDevice", "audio focus request granted", null);
                mcVar.f2554a = true;
            } else {
                so.m2470a(2, "VungleDevice", "audio focus request rejected", null);
                mcVar.f2554a = false;
            }
        } catch (Throwable e) {
            this.f752g.m1865a("VungleAd", "error in onResume()", e);
        }
    }

    protected void onPause() {
        try {
            super.onPause();
            pu puVar = this.f749d;
            so.m2470a(3, "VungleAd", "onAdActivityPause()", null);
            puVar.f2940i.f2904e = puVar.m2350b();
            this.f748c.f1490a.removeCallbacksAndMessages(null);
            Object obj = this.f751f;
            so.m2470a(2, "VungleDevice", "ad abandoning audio focus", null);
            obj.f2555b.abandonAudioFocus(obj);
            obj.f2554a = false;
        } catch (Throwable e) {
            this.f752g.m1865a("VungleAd", "error in onPause()", e);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            this.f746a.mo4515a(this);
            pu puVar = this.f749d;
            so.m2470a(3, "VungleAd", "onAdActivityDestroy()", null);
            puVar.f2940i.m2333a(false);
        } catch (Throwable e) {
            so.m2471a("VungleAd", "error in onDestroy()", e);
        }
        if (!isFinishing()) {
            so.m2470a(4, "VungleAd", "finishing ad that is being destroyed", null);
            finish();
        }
    }

    public void onBackPressed() {
        try {
            so.m2470a(2, "VungleAd", "back button pressed", null);
            this.f747b.m2361a(new af());
            this.f746a.f2639c.mo4505a();
        } catch (Throwable e) {
            this.f752g.m1865a("VungleAd", "error in onBackPressed", e);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        try {
            super.onWindowFocusChanged(hasFocus);
            this.f746a.f2639c.mo4506a(hasFocus);
        } catch (Throwable e) {
            this.f752g.m1865a("VungleAd", "error in onWindowFocusChanged", e);
        }
    }
}
