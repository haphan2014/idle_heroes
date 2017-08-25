package com.vungle.publisher;

import android.webkit.WebView;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class sp {
    static void m2473a(WebView webView, String str, String... strArr) {
        m2474a("window.vungle.mraidBridge", webView, str, strArr);
    }

    public static void m2474a(String str, WebView webView, String str2, String... strArr) {
        m2472a(webView, str + "." + str2 + "(" + agf.m1216a(",", (Object[]) strArr) + ")");
    }

    static void m2472a(WebView webView, String str) {
        so.m2470a(2, "VungleAd", "load javascript: " + str, null);
        webView.loadUrl("javascript:" + str);
    }
}
