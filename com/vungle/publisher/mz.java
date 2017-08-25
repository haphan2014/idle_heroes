package com.vungle.publisher;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.vungle.publisher.agj.C17051;
import com.vungle.publisher.lv.C1812b;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class mz<W extends mx> extends mw {
    protected lv f2602e;
    protected W f2603f;
    protected String f2604g;
    protected C1617z f2605h;
    @Inject
    pj f2606i;
    @Inject
    qh f2607j;
    @Inject
    C1812b f2608k;
    @Inject
    Context f2609l;

    /* compiled from: vungle */
    public static abstract class C1825a<A extends mz<?>> {
        protected abstract A mo4500a();

        protected abstract String mo4501b();

        C1825a() {
        }

        public final A m2182a(Activity activity, String str, lv lvVar, C1617z c1617z) {
            A a = (mz) activity.getFragmentManager().findFragmentByTag(mo4501b());
            if (a == null) {
                a = mo4500a();
            }
            a.f2602e = lvVar;
            a.f2604g = str;
            a.f2605h = c1617z;
            return a;
        }
    }

    protected abstract W mo4504a(String str, C1617z c1617z);

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            if (savedInstanceState != null) {
                C1812b c1812b = this.f2608k;
                lv a = savedInstanceState.containsKey("webViewRootContentIndexFile") ? c1812b.f2503a.m2134a(savedInstanceState.getString("webViewRootContentIndexFile")) : savedInstanceState.containsKey("webViewRootContentString") ? c1812b.f2504b.m2148a(savedInstanceState.getString("webViewRootContentString")) : null;
                this.f2602e = a;
                this.f2604g = savedInstanceState.getString("adId");
            }
        } catch (Throwable e) {
            so.m2470a(5, "VungleAd", "exception in onCreate", e);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f2603f.onConfigurationChanged(newConfig);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        Throwable th;
        try {
            WebView a = mo4504a(this.f2604g, this.f2605h);
            this.f2603f = a;
            lv lvVar = this.f2602e;
            if (lvVar.mo4489a()) {
                so.m2470a(2, "VungleAd", "loading webview with url: " + lvVar.mo4490b(), null);
                a.loadUrl(lvVar.mo4490b());
            } else if (lvVar.mo4491c()) {
                so.m2470a(2, "VungleAd", "loading webview with content: " + lvVar.mo4492d(), null);
                a.loadDataWithBaseURL("http://lol.vungle.com/", lvVar.mo4492d(), "text/html", "utf-8", null);
            }
            this.f2606i.mo4424a(a);
            a.setOnTouchListener(new C17051());
            View relativeLayout = new RelativeLayout(this.f2609l);
            try {
                relativeLayout.addView(a);
                LayoutParams layoutParams = a.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                return relativeLayout;
            } catch (Throwable e) {
                Throwable th2 = e;
                view = relativeLayout;
                th = th2;
                so.m2470a(5, "VungleAd", "exception in onCreateView", th);
                return view;
            }
        } catch (Throwable e2) {
            th = e2;
            view = null;
            so.m2470a(5, "VungleAd", "exception in onCreateView", th);
            return view;
        }
    }

    public void onDestroy() {
        so.m2470a(3, "VungleAd", "webview fragment onDestroy()", null);
        super.onDestroy();
        this.f2603f.destroy();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.f2602e.mo4488a(outState);
        outState.putString("adId", this.f2604g);
    }
}
