package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinPostbackListener;

class C0154e implements AppLovinPostbackListener {
    final /* synthetic */ AdViewControllerImpl f670a;
    final /* synthetic */ Uri f671b;
    final /* synthetic */ AppLovinAdImpl f672c;
    final /* synthetic */ AppLovinAdView f673d;
    final /* synthetic */ AppLovinAdServiceImpl f674e;

    C0154e(AppLovinAdServiceImpl appLovinAdServiceImpl, AdViewControllerImpl adViewControllerImpl, Uri uri, AppLovinAdImpl appLovinAdImpl, AppLovinAdView appLovinAdView) {
        this.f674e = appLovinAdServiceImpl;
        this.f670a = adViewControllerImpl;
        this.f671b = uri;
        this.f672c = appLovinAdImpl;
        this.f673d = appLovinAdView;
    }

    public void onPostbackFailure(String str, int i) {
        this.f674e.f316c.post(new C0156g(this));
    }

    public void onPostbackSuccess(String str) {
        this.f674e.f316c.post(new C0155f(this));
    }
}
