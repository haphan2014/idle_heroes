package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ch;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.widget.WebDialog;
import java.lang.ref.WeakReference;

class C0143x extends Dialog implements C0096w {
    private final Activity f239a;
    private final AppLovinSdk f240b;
    private final AppLovinLogger f241c;
    private RelativeLayout f242d;
    private AppLovinAdView f243e;
    private Runnable f244f;
    private C0122u f245g;
    private Handler f246h;
    private ah f247i = null;
    private volatile boolean f248j = false;
    private volatile boolean f249k = false;

    C0143x(AppLovinSdk appLovinSdk, Activity activity) {
        super(activity, WebDialog.DEFAULT_THEME);
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f240b = appLovinSdk;
            this.f241c = appLovinSdk.getLogger();
            this.f239a = activity;
            this.f244f = new ag();
            this.f246h = new Handler();
            this.f243e = new AppLovinAdView(appLovinSdk, AppLovinAdSize.INTERSTITIAL, activity);
            this.f243e.setAutoDestroy(false);
            ((AdViewControllerImpl) this.f243e.getAdViewController()).setParentDialog(new WeakReference(this));
            requestWindowFeature(1);
            try {
                getWindow().setFlags(activity.getWindow().getAttributes().flags, activity.getWindow().getAttributes().flags);
            } catch (Throwable e) {
                this.f241c.mo637e("InterstitialAdDialog", "Setting window flags failed.", e);
            }
        }
    }

    private int m210a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f239a, i);
    }

    private void m212a() {
        this.f239a.runOnUiThread(new af(this));
    }

    private void m213a(long j) {
        this.f246h.postDelayed(new ae(this), j);
    }

    private void m214a(C0142v c0142v) {
        int i = 9;
        this.f245g = C0122u.m147a(this.f240b, getContext(), c0142v);
        this.f245g.setVisibility(8);
        this.f245g.setOnClickListener(new ac(this));
        this.f245g.setClickable(false);
        ch chVar = new ch(this.f240b);
        int a = m210a(chVar.m539l());
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a, a);
        layoutParams.addRule(10);
        layoutParams.addRule(chVar.m552y() ? 9 : 11);
        this.f245g.mo547a(a);
        int a2 = m210a(chVar.m541n());
        int a3 = m210a(chVar.m543p());
        layoutParams.setMargins(a3, a2, a3, a2);
        this.f243e.addView(this.f245g, layoutParams);
        this.f245g.bringToFront();
        int a4 = m210a(new ch(this.f240b).m545r());
        View view = new View(this.f239a);
        view.setBackgroundColor(0);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a + a4, a + a4);
        layoutParams2.addRule(10);
        if (!chVar.m551x()) {
            i = 11;
        }
        layoutParams2.addRule(i);
        layoutParams2.setMargins(0, a2 - m210a(5), a3 - m210a(5), 0);
        view.setOnClickListener(new ad(this));
        this.f243e.addView(view, layoutParams2);
        view.bringToFront();
    }

    private void m219b() {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f243e.setLayoutParams(layoutParams);
        this.f242d = new RelativeLayout(this.f239a);
        this.f242d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f242d.setBackgroundColor(-1157627904);
        this.f242d.addView(this.f243e);
        setContentView(this.f242d);
    }

    public void m229a(ah ahVar) {
        this.f243e.setAdDisplayListener(new C0144y(this, ahVar));
        this.f243e.setAdClickListener(new C0145z(this, ahVar));
        this.f243e.setAdVideoPlaybackListener(new aa(this, ahVar));
        this.f247i = ahVar;
        ahVar.m139a(true);
    }

    public void m230a(AppLovinAd appLovinAd, String str) {
        this.f239a.runOnUiThread(new ab(this, appLovinAd, str));
    }

    public void dismiss() {
        if (this.f247i != null) {
            this.f247i.m146h();
        }
        if (this.f243e != null) {
            this.f243e.destroy();
        }
        this.f247i = null;
        this.f243e = null;
        super.dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m219b();
    }
}
