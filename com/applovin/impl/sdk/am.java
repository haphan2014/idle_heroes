package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

class am implements Runnable {
    final /* synthetic */ AppLovinAd f410a;
    final /* synthetic */ Map f411b;
    final /* synthetic */ ag f412c;

    am(ag agVar, AppLovinAd appLovinAd, Map map) {
        this.f412c = agVar;
        this.f410a = appLovinAd;
        this.f411b = map;
    }

    public void run() {
        this.f412c.f396f.userRewardVerified(this.f410a, this.f411b);
    }
}
