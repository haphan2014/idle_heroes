package com.vungle.publisher;

import android.app.AlertDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.mz.C1825a;
import com.vungle.publisher.nd.C1830a;
import com.vungle.publisher.oh.C1845a;
import com.vungle.publisher.qx.C1869a;
import com.vungle.publisher.st.C1873a;
import com.vungle.publisher.tb.C1879a;
import com.vungle.publisher.tb.C1880b;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class nl extends mz<st> {
    final Handler f2663m = new Handler();
    AtomicInteger f2664n = new AtomicInteger(0);
    AtomicInteger f2665o = new AtomicInteger(0);
    tb f2666p;
    oh f2667q;
    @Inject
    C1873a f2668r;
    @Inject
    C1836a f2669s;
    @Inject
    te f2670t;
    @Inject
    nf f2671u;
    @Inject
    C1879a f2672v;
    @Inject
    C1845a f2673w;

    /* compiled from: vungle */
    class C18331 implements OnClickListener {
        final /* synthetic */ nl f2653a;

        C18331(nl nlVar) {
            this.f2653a = nlVar;
        }

        public final void onClick(View view) {
            this.f2653a.j.m2361a(new tv());
        }
    }

    /* compiled from: vungle */
    class C18342 implements C1830a {
        final /* synthetic */ nl f2654a;

        C18342(nl nlVar) {
            this.f2654a = nlVar;
        }

        public final void mo4497a() {
            te.m2494a(this.f2654a.f, true);
        }

        public final void mo4498b() {
            so.m2470a(3, "VungleAd", "cancel video", null);
            te.m2494a(this.f2654a.f, false);
        }

        public final void mo4499c() {
            te.m2494a(this.f2654a.f, true);
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1835a extends C1825a<nl> {
        @Inject
        Provider<nl> f2655a;

        @Inject
        C1835a() {
        }

        protected final String mo4501b() {
            return "fullScreenMraidFragment";
        }

        protected final /* synthetic */ mz mo4500a() {
            return (nl) this.f2655a.get();
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1837b extends qa {
        nl f2657a;

        @Singleton
        /* compiled from: vungle */
        public static class C1836a {
            @Inject
            C1837b f2656a;

            @Inject
            C1836a() {
            }

            public final C1837b m2217a(nl nlVar) {
                this.f2656a.f2657a = nlVar;
                return this.f2656a;
            }
        }

        @Inject
        C1837b() {
        }

        public final void onEvent(uf event) {
            C1880b c1880b = event.f3335a;
            so.m2470a(2, "VungleEvent", "set close region: " + c1880b, null);
            this.f2657a.m2227a(c1880b, 2, 0);
        }

        public final void onEvent(ug event) {
            boolean z = event.f3336a;
            so.m2470a(2, "VungleEvent", "use custom privacy icon? " + z, null);
            this.f2657a.m2229a(!z, 2, 0);
        }

        public final void onEvent(ue ueVar) {
            so.m2470a(2, "VungleEvent", "throw incentivized dialog", null);
            nl.m2224a(this.f2657a);
        }

        public final void onEvent(uc ucVar) {
            this.f2657a.m2227a(C1880b.visible, 1, 500);
            this.f2657a.m2229a(true, 1, 500);
        }
    }

    /* compiled from: vungle */
    abstract class C1838d<V> implements Runnable {
        final V f2658b;
        final int f2659c;
        final /* synthetic */ nl f2660d;

        abstract AtomicInteger mo4502a();

        abstract void mo4503a(V v);

        public C1838d(nl nlVar, V v, int i) {
            this.f2660d = nlVar;
            this.f2659c = i;
            this.f2658b = v;
        }

        public void run() {
            try {
                AtomicInteger a = mo4502a();
                int i;
                do {
                    i = a.get();
                    if (this.f2659c < i) {
                        return;
                    }
                } while (!a.compareAndSet(i, this.f2659c));
                mo4503a(this.f2658b);
            } catch (Throwable e) {
                so.m2470a(5, "VungleAd", null, e);
            }
        }
    }

    /* compiled from: vungle */
    class C1839c extends C1838d<C1880b> {
        final /* synthetic */ nl f2661a;

        final /* synthetic */ void mo4503a(Object obj) {
            this.f2661a.f2666p.setCloseVisibility((C1880b) obj);
        }

        public C1839c(nl nlVar, C1880b c1880b, int i) {
            this.f2661a = nlVar;
            super(nlVar, c1880b, i);
        }

        final AtomicInteger mo4502a() {
            return this.f2661a.f2664n;
        }
    }

    /* compiled from: vungle */
    class C1840e extends C1838d<Integer> {
        final /* synthetic */ nl f2662a;

        final /* synthetic */ void mo4503a(Object obj) {
            this.f2662a.f2667q.setVisibility(((Integer) obj).intValue());
        }

        public C1840e(nl nlVar, Integer num, int i) {
            this.f2662a = nlVar;
            super(nlVar, num, i);
        }

        final AtomicInteger mo4502a() {
            return this.f2662a.f2665o;
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            if (Injector.getInstance().m1976c()) {
                Injector.m1974b().mo4529a(this);
                this.f2669s.m2217a(this).m1184g();
                return;
            }
            so.m2470a(5, "VungleAd", "SDK not initialized", null);
            getActivity().finish();
        } catch (Throwable e) {
            so.m2471a("VungleAd", "exception while creating Mraid ad fragment", e);
        }
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        te teVar = this.f2670t;
        WebView webView = this.f;
        tm a = teVar.f3258d.m2503a();
        a.m2509c();
        try {
            te.m2493a(webView, a.mo4355a(), false);
        } catch (Throwable e) {
            teVar.f3256b.m1867b("VungleAd", "could not update mraid dimensions", e);
        }
    }

    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout relativeLayout = (RelativeLayout) super.onCreateView(inflater, container, savedInstanceState);
        try {
            C1879a c1879a = this.f2672v;
            tb tbVar = new tb(c1879a.f3241a);
            View imageView = new ImageView(c1879a.f3241a);
            tbVar.f3248a = imageView;
            c1879a.f3243c.m1229a(imageView, C1869a.close);
            tbVar.addView(imageView);
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            tbVar.setCloseVisibility(C1880b.gone);
            this.f2666p = tbVar;
            relativeLayout.addView(this.f2666p);
            layoutParams = (LayoutParams) this.f2666p.getLayoutParams();
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            try {
                layoutParams = (LayoutParams) this.f2666p.getLayoutParams();
                int a = (int) this.f2672v.f3242b.m2195a(50);
                layoutParams.width = a;
                layoutParams.height = a;
            } catch (Exception e) {
                so.m2470a(6, "VungleAd", "could not set close region dimensions. did you add it to a view yet?", null);
            }
            m2227a(C1880b.visible, 0, 3000);
            this.f2666p.setOnClickListener(new C18331(this));
            this.f2667q = this.f2673w.m2261a(this.l, true);
            relativeLayout.addView(this.f2667q);
            layoutParams = (LayoutParams) this.f2667q.getLayoutParams();
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            m2229a(true, 0, 3000);
            relativeLayout.setBackgroundColor(0);
        } catch (Throwable e2) {
            this.c.m1865a("VungleAd", "error creating MraidAdFragment", e2);
        }
        return relativeLayout;
    }

    final void m2227a(C1880b c1880b, int i, long j) {
        this.f2663m.postDelayed(new C1839c(this, c1880b, i), j);
    }

    final void m2229a(boolean z, int i, long j) {
        this.f2663m.postDelayed(new C1840e(this, Integer.valueOf(z ? 0 : 8), i), j);
    }

    public final boolean m2231c() {
        return ((st) this.f).f3197b.f3206b;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f2669s.m2217a(this).mo4377f();
    }

    public final void onResume() {
        try {
            super.onResume();
            this.f2670t.m2495a(true, this.f);
        } catch (Throwable e) {
            this.c.m1865a("VungleAd", "error resuming mraid ad", e);
        }
    }

    public final void onPause() {
        try {
            super.onPause();
            this.f2670t.m2495a(false, this.f);
        } catch (Throwable e) {
            this.c.m1865a("VungleAd", "error pausing mraid ad", e);
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

    public final void mo4505a() {
        try {
            st stVar = (st) this.f;
            if (stVar.f3197b.f3206b) {
                sp.m2474a("window.vungle.mraidBridgeExt", stVar, "requestMRAIDClose", new String[0]);
            } else if (!stVar.f3197b.f3207c) {
                int historyIndex = stVar.getHistoryIndex();
                so.m2470a(2, "VungleAd", "back pressed at index: " + historyIndex, null);
                if (historyIndex > 0) {
                    stVar.goBack();
                }
            }
        } catch (Throwable e) {
            so.m2470a(5, "VungleAd", "exception in onBackPressed", e);
        }
    }

    public final String mo4507b() {
        return "fullScreenMraidFragment";
    }

    protected final /* bridge */ /* synthetic */ mx mo4504a(String str, C1617z c1617z) {
        return (st) this.f2668r.m2178a(str, c1617z);
    }

    static /* synthetic */ void m2224a(nl nlVar) {
        AlertDialog alertDialog;
        if (nlVar.a != null) {
            alertDialog = nlVar.a;
        } else {
            alertDialog = nlVar.d.m2193a(nlVar.getActivity(), nlVar.h, new C18342(nlVar));
        }
        nlVar.a = alertDialog;
        nlVar.a.show();
    }
}
