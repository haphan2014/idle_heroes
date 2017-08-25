package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

class ao implements Runnable {
    final /* synthetic */ AppLovinAd f416a;
    final /* synthetic */ Map f417b;
    final /* synthetic */ ag f418c;

    ao(ag agVar, AppLovinAd appLovinAd, Map map) {
        this.f418c = agVar;
        this.f416a = appLovinAd;
        this.f417b = map;
    }

    public void run() {
        this.f418c.f396f.userRewardRejected(this.f416a, this.f417b);
    }
}
