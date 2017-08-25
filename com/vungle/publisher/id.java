package com.vungle.publisher;

import android.text.TextUtils;
import java.lang.reflect.Array;

/* compiled from: vungle */
public final class id {
    public final String f2142a;
    public final String[] f2143b;
    public final String f2144c;
    public final String[] f2145d;
    public final String f2146e;
    public final String f2147f;
    public final String f2148g;
    public final String f2149h;

    /* compiled from: vungle */
    public static final class C1786a {
        String f2134a;
        String[] f2135b;
        String f2136c = "";
        String[] f2137d = new String[0];
        String f2138e;
        String f2139f;
        String f2140g;
        String f2141h;

        public final C1786a m1935a(String str) {
            this.f2136c = this.f2136c.concat(str);
            return this;
        }

        public final C1786a m1936a(String[] strArr) {
            Object obj;
            String[][] strArr2 = new String[][]{this.f2137d, strArr};
            Class cls = null;
            int i = 0;
            for (int i2 = 0; i2 < 2; i2++) {
                Object obj2 = strArr2[i2];
                if (obj2 != null) {
                    i += obj2.length;
                    cls = obj2.getClass();
                }
            }
            if (cls != null) {
                obj = (Object[]) Array.newInstance(cls.getComponentType(), i);
                i = 0;
                for (int i3 = 0; i3 < 2; i3++) {
                    Object obj3 = strArr2[i3];
                    if (obj3 != null) {
                        System.arraycopy(obj3, 0, obj, i, obj3.length);
                        i += obj3.length;
                    }
                }
            } else {
                obj = null;
            }
            this.f2137d = (String[]) obj;
            return this;
        }

        public final id m1937a() {
            return new id();
        }
    }

    private id(C1786a c1786a) {
        this.f2142a = c1786a.f2134a;
        this.f2143b = c1786a.f2135b;
        this.f2144c = c1786a.f2136c;
        this.f2145d = c1786a.f2137d;
        this.f2146e = c1786a.f2138e;
        this.f2147f = c1786a.f2139f;
        this.f2148g = c1786a.f2140g;
        this.f2149h = c1786a.f2141h;
    }

    public final String m1938a() {
        String str;
        Object a = agf.m1217a(this.f2143b);
        Object a2 = agf.m1217a(this.f2145d);
        StringBuilder append = new StringBuilder().append(TextUtils.isEmpty(this.f2142a) ? "" : "table: " + this.f2142a + "; ").append(TextUtils.isEmpty(a) ? "" : "columns: " + a + "; ").append(TextUtils.isEmpty(this.f2144c) ? "" : "selection: " + this.f2144c + "; ").append(TextUtils.isEmpty(a2) ? "" : "selectionArgs: " + a2 + "; ").append(TextUtils.isEmpty(this.f2146e) ? "" : "groupBy: " + this.f2146e + "; ").append(TextUtils.isEmpty(this.f2147f) ? "" : "having: " + this.f2147f + "; ").append(TextUtils.isEmpty(this.f2148g) ? "" : "orderBy: " + this.f2148g + "; ");
        if (TextUtils.isEmpty(this.f2149h)) {
            str = "";
        } else {
            str = "limit: " + this.f2149h + "; ";
        }
        return append.append(str).toString();
    }
}
