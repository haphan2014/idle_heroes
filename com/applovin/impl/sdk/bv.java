package com.applovin.impl.sdk;

import java.util.Map;

class bv {
    final /* synthetic */ bt f509a;
    private int f510b;
    private String f511c;
    private Map f512d;

    bv(bt btVar, String str, Map map) {
        this(btVar, str, map, 0);
    }

    bv(bt btVar, String str, Map map, int i) {
        this.f509a = btVar;
        this.f510b = i;
        this.f511c = str + "&postback_ts=" + System.currentTimeMillis();
        this.f512d = map;
    }

    public int m456a() {
        return this.f510b;
    }

    public void m457a(int i) {
        this.f510b = i;
    }

    public String m458b() {
        return this.f511c;
    }

    public Map m459c() {
        return this.f512d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r4 != r5) goto L_0x0006;
    L_0x0004:
        r1 = r0;
    L_0x0005:
        return r1;
    L_0x0006:
        if (r5 == 0) goto L_0x0005;
    L_0x0008:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 != r3) goto L_0x0005;
    L_0x0012:
        r5 = (com.applovin.impl.sdk.bv) r5;
        r2 = r4.f510b;
        r3 = r5.f510b;
        if (r2 != r3) goto L_0x0005;
    L_0x001a:
        r2 = r4.f511c;
        if (r2 == 0) goto L_0x0039;
    L_0x001e:
        r2 = r4.f511c;
        r3 = r5.f511c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0028:
        r2 = r4.f512d;
        if (r2 == 0) goto L_0x003e;
    L_0x002c:
        r2 = r4.f512d;
        r3 = r5.f512d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0037;
    L_0x0036:
        r0 = r1;
    L_0x0037:
        r1 = r0;
        goto L_0x0005;
    L_0x0039:
        r2 = r5.f511c;
        if (r2 == 0) goto L_0x0028;
    L_0x003d:
        goto L_0x0005;
    L_0x003e:
        r2 = r5.f512d;
        if (r2 != 0) goto L_0x0036;
    L_0x0042:
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.bv.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f511c != null ? this.f511c.hashCode() : 0) + (this.f510b * 31)) * 31;
        if (this.f512d != null) {
            i = this.f512d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PostbackRequest{attemptNumber=" + this.f510b + ", targetUrl='" + this.f511c + '\'' + ", requestBody=" + this.f512d + '}';
    }
}
