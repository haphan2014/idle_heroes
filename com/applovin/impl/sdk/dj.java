package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

public class dj {
    private static final dj f657a = new dj();
    private final Object f658b = new Object();
    private final Map f659c = new HashMap(2);

    private dj() {
    }

    static dj m670a() {
        return f657a;
    }

    dl m671a(String str) {
        dl dlVar;
        synchronized (this.f658b) {
            dlVar = (dl) this.f659c.remove(str);
        }
        return dlVar;
    }

    void m672a(String str, long j, String str2) {
        dl dlVar = new dl(this, str2, j);
        synchronized (this.f658b) {
            this.f659c.put(str, dlVar);
        }
    }
}
