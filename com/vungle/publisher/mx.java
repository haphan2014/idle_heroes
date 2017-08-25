package com.vungle.publisher;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class mx extends WebView {
    protected qh f2601a;

    @Singleton
    /* compiled from: vungle */
    public static class C1823a {
        @Inject
        qh f2596a;
        @Inject
        pj f2597b;
        @Inject
        public ch f2598c;

        /* compiled from: vungle */
        public class C18221 implements Runnable {
            final /* synthetic */ Context f2594a;
            final /* synthetic */ C1823a f2595b;

            public C18221(C1823a c1823a, Context context) {
                this.f2595b = c1823a;
                this.f2594a = context;
            }

            public final void run() {
                this.f2595b.f2597b.mo4424a(new WebView(this.f2594a));
                this.f2595b.f2596a.m2361a(new py());
            }
        }

        @Inject
        C1823a() {
        }
    }

    /* compiled from: vungle */
    public static abstract class C1824b<W extends mx> {
        @Inject
        Context f2599a;
        @Inject
        qh f2600b;

        public abstract W mo4518a(Context context);

        public abstract void mo4519a(W w);

        public abstract void mo4520a(String str, W w, C1617z c1617z);

        public final W m2178a(String str, C1617z c1617z) {
            mx a = mo4518a(this.f2599a);
            a.f2601a = this.f2600b;
            WebSettings settings = a.getSettings();
            settings.setBuiltInZoomControls(false);
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSaveFormData(true);
            settings.setUseWideViewPort(false);
            if (VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            a.setBackgroundColor(Color.argb(1, 0, 0, 0));
            a.setBackgroundResource(0);
            mo4520a(str, a, c1617z);
            mo4519a(a);
            if (VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            return a;
        }
    }

    protected mx(Context context) {
        super(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }
}
