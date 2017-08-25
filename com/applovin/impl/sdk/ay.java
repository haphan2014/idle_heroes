package com.applovin.impl.sdk;

import android.app.AlertDialog;
import com.applovin.adview.AppLovinInterstitialActivity;

public class ay {
    private final AppLovinSdkImpl f439a;
    private final AppLovinInterstitialActivity f440b;
    private AlertDialog f441c;

    public ay(AppLovinSdkImpl appLovinSdkImpl, AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f439a = appLovinSdkImpl;
        this.f440b = appLovinInterstitialActivity;
    }

    public void m343a() {
        this.f440b.runOnUiThread(new az(this));
    }

    public void m344b() {
        this.f440b.runOnUiThread(new ba(this));
    }

    public boolean m345c() {
        return this.f441c != null ? this.f441c.isShowing() : false;
    }
}
