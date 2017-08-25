package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class ar extends WebViewClient {
    private final AppLovinSdk f176a;
    private final AppLovinLogger f177b;
    private WeakReference f178c;

    public ar(AppLovinSdk appLovinSdk) {
        this.f176a = appLovinSdk;
        this.f177b = appLovinSdk.getLogger();
    }

    void m168a(WebView webView, String str) {
        this.f177b.mo638i("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof aq)) {
            aq aqVar = (aq) webView;
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            as asVar = (as) this.f178c.get();
            if (!"applovin".equalsIgnoreCase(scheme) || !AppLovinSdk.URI_HOST.equalsIgnoreCase(host) || asVar == null) {
                return;
            }
            if ("/track_click".equals(path)) {
                asVar.mo508a(aqVar);
            } else if ("/close_ad".equals(path)) {
                asVar.mo509b(aqVar);
            } else if ("/skip_ad".equals(path)) {
                asVar.mo510c(aqVar);
            } else {
                this.f177b.mo641w("WebViewButtonClient", "Unknown URL: " + str);
                this.f177b.mo641w("WebViewButtonClient", "Path: " + path);
            }
        }
    }

    public void m169a(WeakReference weakReference) {
        this.f178c = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m168a(webView, str);
        return true;
    }
}
