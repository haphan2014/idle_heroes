package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dw.C1717a;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONArray;

/* compiled from: vungle */
public final class gx extends dw<Integer> {
    public long f2030a;
    public String[] f2031b;
    public int f2032c;
    public String f2033d;
    public String f2034e;
    public String f2035f;
    public String f2036g;
    public String f2037h;
    public String f2038i;
    @Inject
    C1778a f2039j;

    @Singleton
    /* compiled from: vungle */
    public static class C1778a extends C1717a<gx, Integer> {
        @Inject
        pj f2027a;
        @Inject
        pr f2028b;
        @Inject
        Provider<gx> f2029c;

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        protected final /* synthetic */ dw c_() {
            return m1859a();
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1778a() {
        }

        public final void m1865a(String str, String str2, Throwable th) {
            m1861a(2, str, str2, th);
        }

        public final void m1867b(String str, String str2, Throwable th) {
            m1861a(1, str, str2, th);
        }

        private void m1861a(int i, String str, String str2, Throwable th) {
            String[] strArr = null;
            so.m2471a(str, str2, th);
            if (!this.f2028b.m2344b()) {
                return;
            }
            if (m1286h() < 100) {
                gx a = m1859a();
                a.f2033d = str;
                a.f2034e = str2;
                a.f2035f = th.getClass().toString();
                a.f2032c = i;
                a.f2036g = this.f2027a.mo4427g();
                a.f2037h = "VungleDroid/4.1.0";
                a.f2038i = this.f2027a.mo4434n();
                if (th != null) {
                    StackTraceElement[] stackTrace = th.getStackTrace();
                    if (stackTrace != null) {
                        String[] strArr2 = new String[stackTrace.length];
                        for (int i2 = 0; i2 < stackTrace.length; i2++) {
                            strArr2[i2] = stackTrace[i2].toString();
                        }
                        strArr = strArr2;
                    }
                }
                a.f2031b = strArr;
                a.mo4400v();
                return;
            }
            so.m2470a(5, str, "could not insert logged exception... too many already!", null);
        }

        protected final String mo4385c() {
            return "logged_exceptions";
        }

        private static gx m1860a(gx gxVar, Cursor cursor) {
            gxVar.f2030a = cm.m1260e(cursor, "insert_timestamp_millis").longValue();
            gxVar.f2032c = cm.m1258c(cursor, "type");
            gxVar.f2033d = cm.m1261f(cursor, "tag");
            gxVar.f2034e = cm.m1261f(cursor, "log_message");
            gxVar.f2035f = cm.m1261f(cursor, "class");
            gxVar.f2036g = cm.m1261f(cursor, "android_version");
            gxVar.f2037h = cm.m1261f(cursor, "sdk_version");
            gxVar.f2038i = cm.m1261f(cursor, "play_services_version");
            gxVar.u = cm.m1259d(cursor, "id");
            try {
                String[] strArr;
                String f = cm.m1261f(cursor, "stack_trace");
                if (f == null) {
                    strArr = null;
                } else {
                    JSONArray jSONArray = new JSONArray(f);
                    strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = jSONArray.getString(i);
                    }
                }
                gxVar.f2031b = strArr;
            } catch (Throwable e) {
                so.m2471a("VungleDatabase", "could not parse stack trace string", e);
            }
            return gxVar;
        }

        private gx m1859a() {
            return (gx) this.f2029c.get();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }
    }

    @Inject
    gx() {
    }

    protected final String mo4391c() {
        return "logged_exceptions";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("id", (Integer) mo4410w());
            long currentTimeMillis = System.currentTimeMillis();
            this.f2030a = currentTimeMillis;
            contentValues.put("insert_timestamp_millis", Long.valueOf(currentTimeMillis));
        }
        contentValues.put("type", Integer.valueOf(this.f2032c));
        contentValues.put("tag", this.f2033d);
        contentValues.put("log_message", this.f2034e);
        contentValues.put("class", this.f2035f);
        contentValues.put("android_version", this.f2036g);
        contentValues.put("sdk_version", this.f2037h);
        contentValues.put("play_services_version", this.f2038i);
        try {
            String str = "stack_trace";
            String[] strArr = this.f2031b;
            String str2 = null;
            if (strArr != null) {
                str2 = new JSONArray(Arrays.asList(strArr)).toString();
            }
            contentValues.put(str, str2);
        } catch (Throwable e) {
            so.m2471a("VungleDatabase", "could not parse stack trace array", e);
        }
        return contentValues;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2039j;
    }
}
