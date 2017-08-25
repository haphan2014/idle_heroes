package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

class C0144y implements AppLovinAdDisplayListener {
    final /* synthetic */ ah f250a;
    final /* synthetic */ C0143x f251b;

    C0144y(C0143x c0143x, ah ahVar) {
        this.f251b = c0143x;
        this.f250a = ahVar;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        super.show();
        if (!this.f251b.f248j) {
            AppLovinAdDisplayListener d = this.f250a.m142d();
            if (d != null) {
                d.adDisplayed(appLovinAd);
            }
            this.f251b.f248j = true;
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f251b.f239a.runOnUiThread(this.f251b.f244f);
        AppLovinAdDisplayListener d = this.f250a.m142d();
        if (!(this.f251b.f249k || d == null)) {
            d.adHidden(appLovinAd);
            this.f251b.f249k = true;
        }
        this.f250a.m139a(false);
    }
}
