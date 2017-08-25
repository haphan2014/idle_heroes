package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.ch;
import com.applovin.impl.sdk.dp;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

class C0136o extends WebView {
    private final AppLovinLogger f201a;
    private AppLovinAd f202b = null;
    private boolean f203c = false;

    C0136o(C0139r c0139r, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f201a = appLovinSdk.getLogger();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(c0139r);
        setWebChromeClient(new C0135n(appLovinSdk));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        setOnTouchListener(new C0137p(this));
        setOnLongClickListener(new C0138q(this));
    }

    AppLovinAd m180a() {
        return this.f202b;
    }

    public void m181a(AppLovinAd appLovinAd, String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (this.f203c) {
            this.f201a.userError("AdWebView", "Ad can not be loaded in a destroyed web view");
            return;
        }
        this.f202b = appLovinAd;
        if (appLovinSdkImpl != null) {
            try {
                if (new ch(appLovinSdkImpl).m524Q()) {
                    loadUrl("about:blank");
                }
            } catch (Exception e) {
                this.f201a.mo636e("AdWebView", "Unable to render AppLovinAd with placement = \"" + str + "\"");
                return;
            }
        }
        loadDataWithBaseURL("/", dp.m699a(str, ((AppLovinAdImpl) appLovinAd).getHtmlSource()), "text/html", null, "");
        this.f201a.mo635d("AdWebView", "AppLovinAd rendered");
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f203c = true;
        try {
            super.destroy();
            this.f201a.mo635d("AdWebView", "Web view destroyed");
        } catch (Throwable th) {
            if (this.f201a != null) {
                this.f201a.mo637e("AdWebView", "destroy() threw exception", th);
            }
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Throwable e) {
            this.f201a.mo637e("AdWebView", "onFocusChanged() threw exception", e);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Throwable e) {
            this.f201a.mo637e("AdWebView", "onWindowFocusChanged() threw exception", e);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
        } catch (Throwable e) {
            this.f201a.mo637e("AdWebView", "onWindowVisibilityChanged() threw exception", e);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        try {
            return super.requestFocus(i, rect);
        } catch (Throwable e) {
            this.f201a.mo637e("AdWebView", "requestFocus() threw exception", e);
            return false;
        }
    }

    public void scrollTo(int i, int i2) {
    }
}
