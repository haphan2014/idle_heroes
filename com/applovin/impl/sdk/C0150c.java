package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

public class C0150c {
    private AppLovinAdSize f522a;
    private AppLovinAdType f523b;

    public C0150c(AppLovinAd appLovinAd) {
        this.f522a = appLovinAd.getSize();
        this.f523b = appLovinAd.getType();
    }

    public C0150c(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        this.f522a = appLovinAdSize;
        this.f523b = appLovinAdType;
    }

    public AppLovinAdSize m469a() {
        return this.f522a;
    }

    public AppLovinAdType m470b() {
        return this.f523b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0150c c0150c = (C0150c) obj;
        if (this.f522a == null ? c0150c.f522a != null : !this.f522a.equals(c0150c.f522a)) {
            if (this.f523b != null) {
                if (this.f523b.equals(c0150c.f523b)) {
                    return true;
                }
            } else if (c0150c.f523b == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f522a != null ? this.f522a.hashCode() : 0) * 31;
        if (this.f523b != null) {
            i = this.f523b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AdSpec{size=" + this.f522a + ", type=" + this.f523b + '}';
    }
}
