package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

class C0139r extends WebViewClient {
    private final AppLovinLogger f206a;
    private final AdViewControllerImpl f207b;

    public C0139r(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        this.f206a = appLovinSdk.getLogger();
        this.f207b = adViewControllerImpl;
    }

    private void m182a(C0136o c0136o, Uri uri) {
        AppLovinAd a = c0136o.m180a();
        ViewParent parent = c0136o.getParent();
        if (!(parent instanceof AppLovinAdView) || a == null) {
            this.f206a.mo636e("AdWebViewClient", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        } else {
            this.f207b.m123a(a, (AppLovinAdView) parent, this.f207b, uri);
        }
    }

    void m183a(WebView webView, String str) {
        this.f206a.mo638i("AdWebViewClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0136o)) {
            Uri parse = Uri.parse(str);
            C0136o c0136o = (C0136o) webView;
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            if (!"applovin".equals(scheme) || !AppLovinSdk.URI_HOST.equals(host)) {
                m182a(c0136o, parse);
            } else if (AppLovinAdService.URI_NEXT_AD.equals(path)) {
                m184a(c0136o);
            } else if (AppLovinAdService.URI_CLOSE_AD.equals(path)) {
                m185b(c0136o);
            } else if (!AppLovinAdServiceImpl.URI_NO_OP.equals(path)) {
                if (AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals(path)) {
                    m182a(c0136o, Uri.parse(AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                } else if (path == null || !path.startsWith("/launch/")) {
                    this.f206a.mo641w("AdWebViewClient", "Unknown URL: " + str);
                    this.f206a.mo641w("AdWebViewClient", "Path: " + path);
                } else {
                    List pathSegments = parse.getPathSegments();
                    if (pathSegments != null && pathSegments.size() > 1) {
                        String str2 = (String) pathSegments.get(pathSegments.size() - 1);
                        try {
                            Context context = webView.getContext();
                            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str2));
                            m182a(c0136o, null);
                        } catch (Throwable e) {
                            this.f206a.mo637e("AdWebViewClient", "Threw Exception Trying to Launch App for Package: " + str2, e);
                        }
                    }
                }
            }
        }
    }

    void m184a(C0136o c0136o) {
        ViewParent parent = c0136o.getParent();
        if (parent instanceof AppLovinAdView) {
            ((AppLovinAdView) parent).loadNextAd();
        }
    }

    void m185b(C0136o c0136o) {
        this.f207b.m120a();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f207b.onAdHtmlLoaded(webView);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        m183a(webView, str);
        return true;
    }
}
