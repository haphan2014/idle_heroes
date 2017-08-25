package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

class an implements Runnable {
    final /* synthetic */ AppLovinAd f413a;
    final /* synthetic */ Map f414b;
    final /* synthetic */ ag f415c;

    an(ag agVar, AppLovinAd appLovinAd, Map map) {
        this.f415c = agVar;
        this.f413a = appLovinAd;
        this.f414b = map;
    }

    public void run() {
        this.f415c.f396f.userOverQuota(this.f413a, this.f414b);
    }
}
