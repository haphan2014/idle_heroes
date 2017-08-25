package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Map;

class C0159j extends cc {
    final /* synthetic */ AppLovinAdServiceImpl f686a;
    private final AppLovinAdSize f687b;

    public C0159j(AppLovinAdServiceImpl appLovinAdServiceImpl, AppLovinAdSize appLovinAdSize) {
        this.f686a = appLovinAdServiceImpl;
        super("UpdateAdTask", appLovinAdServiceImpl.f314a);
        this.f687b = appLovinAdSize;
    }

    public void run() {
        Object obj = 1;
        C0158i c0158i = (C0158i) ((Map) this.f686a.f317d.get(AppLovinAdType.REGULAR)).get(this.f687b);
        synchronized (c0158i.f680b) {
            boolean a = this.f686a.m239a(this.f687b);
            boolean e = this.f686a.m237a();
            Object obj2 = !c0158i.f684f.isEmpty() ? 1 : null;
            if (System.currentTimeMillis() <= c0158i.f682d) {
                obj = null;
            }
            if (!(!a || obj2 == null || r1 == null || !e || c0158i.f683e)) {
                c0158i.f683e = true;
                this.f686a.m236a(this.f687b, AppLovinAdType.REGULAR, new C0157h(this.f686a, c0158i));
            }
        }
    }
}
