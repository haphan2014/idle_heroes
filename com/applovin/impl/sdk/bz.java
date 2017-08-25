package com.applovin.impl.sdk;

import java.util.Map;

public class bz {
    private final String f518a;
    private final Map f519b;
    private final long f520c;
    private final String f521d;

    public bz(String str, Map map, long j, String str2) {
        this.f518a = str;
        this.f519b = map;
        this.f520c = j;
        this.f521d = str2;
    }

    public String m466a() {
        return this.f518a;
    }

    public Map m467b() {
        return this.f519b;
    }

    public long m468c() {
        return this.f520c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r6 != r7) goto L_0x0006;
    L_0x0004:
        r1 = r0;
    L_0x0005:
        return r1;
    L_0x0006:
        if (r7 == 0) goto L_0x0005;
    L_0x0008:
        r2 = r6.getClass();
        r3 = r7.getClass();
        if (r2 != r3) goto L_0x0005;
    L_0x0012:
        r7 = (com.applovin.impl.sdk.bz) r7;
        r2 = r6.f520c;
        r4 = r7.f520c;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0005;
    L_0x001c:
        r2 = r6.f518a;
        if (r2 == 0) goto L_0x0049;
    L_0x0020:
        r2 = r6.f518a;
        r3 = r7.f518a;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x002a:
        r2 = r6.f519b;
        if (r2 == 0) goto L_0x004e;
    L_0x002e:
        r2 = r6.f519b;
        r3 = r7.f519b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0005;
    L_0x0038:
        r2 = r6.f521d;
        if (r2 == 0) goto L_0x0053;
    L_0x003c:
        r2 = r6.f521d;
        r3 = r7.f521d;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0047;
    L_0x0046:
        r0 = r1;
    L_0x0047:
        r1 = r0;
        goto L_0x0005;
    L_0x0049:
        r2 = r7.f518a;
        if (r2 == 0) goto L_0x002a;
    L_0x004d:
        goto L_0x0005;
    L_0x004e:
        r2 = r7.f519b;
        if (r2 == 0) goto L_0x0038;
    L_0x0052:
        goto L_0x0005;
    L_0x0053:
        r2 = r7.f521d;
        if (r2 != 0) goto L_0x0046;
    L_0x0057:
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.bz.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f519b != null ? this.f519b.hashCode() : 0) + ((this.f518a != null ? this.f518a.hashCode() : 0) * 31)) * 31) + ((int) (this.f520c ^ (this.f520c >>> 32)))) * 31;
        if (this.f521d != null) {
            i = this.f521d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SdkEvent{eventType='" + this.f518a + '\'' + ", parameters=" + this.f519b + ", creationTsMillis=" + this.f520c + ", uniqueIdentifier='" + this.f521d + '\'' + '}';
    }
}
