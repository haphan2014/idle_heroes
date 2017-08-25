package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.HashMap;
import java.util.Map;

public class bs {
    private static bs f497d;
    private final Map f498a = new HashMap(1);
    private final Map f499b = new HashMap(1);
    private final Object f500c = new Object();

    private bs() {
    }

    public static synchronized bs m436a() {
        bs bsVar;
        synchronized (bs.class) {
            if (f497d == null) {
                f497d = new bs();
            }
            bsVar = f497d;
        }
        return bsVar;
    }

    public Map m437a(AppLovinAd appLovinAd) {
        Map map;
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f500c) {
            map = (Map) this.f499b.remove(appLovinAdImpl);
        }
        return map;
    }

    public void m438a(AppLovinAd appLovinAd, String str) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f500c) {
            this.f498a.put(appLovinAdImpl, str);
        }
    }

    public void m439a(AppLovinAd appLovinAd, Map map) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f500c) {
            this.f499b.put(appLovinAdImpl, map);
        }
    }

    public String m440b(AppLovinAd appLovinAd) {
        String str;
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f500c) {
            str = (String) this.f498a.remove(appLovinAdImpl);
        }
        return str;
    }
}
