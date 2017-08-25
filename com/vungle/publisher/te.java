package com.vungle.publisher;

import android.webkit.WebView;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.tm.C1888a;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: vungle */
public final class te {
    @Inject
    nf f3255a;
    @Inject
    public C1778a f3256b;
    @Inject
    public sp f3257c;
    @Inject
    public C1888a f3258d;

    @Inject
    te() {
    }

    public final void m2495a(boolean z, WebView webView) {
        tm a = this.f3258d.m2503a();
        a.m2507a(z);
        try {
            m2493a(webView, a.mo4355a(), false);
        } catch (Throwable e) {
            this.f3256b.m1867b("VungleAd", "could not update viewable properties", e);
        }
    }

    public static void m2494a(WebView webView, boolean z) {
        sp.m2473a(webView, "incentivizedDialogResponse", String.valueOf(z));
    }

    public static void m2493a(WebView webView, JSONObject jSONObject, boolean z) {
        sp.m2473a(webView, "notifyPropertiesChange", jSONObject.toString(), String.valueOf(z));
    }
}
