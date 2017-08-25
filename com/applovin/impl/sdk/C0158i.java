package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import java.util.Collection;
import java.util.HashSet;

class C0158i {
    final AppLovinAdSize f679a;
    final Object f680b;
    AppLovinAd f681c;
    long f682d;
    boolean f683e;
    private final Collection f684f;
    private final Collection f685g;

    private C0158i(AppLovinAdSize appLovinAdSize) {
        this.f684f = new HashSet();
        this.f685g = new HashSet();
        this.f679a = appLovinAdSize;
        this.f680b = new Object();
        this.f681c = null;
        this.f682d = 0;
        this.f683e = false;
    }
}
