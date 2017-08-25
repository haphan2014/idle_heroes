package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.jw.C1798a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ep extends dw<Integer> {
    public String f1784a;
    public String f1785b;
    public jt f1786c;
    public long f1787d;
    public Integer f1788e;
    public Long f1789f;
    public String f1790g;
    @Inject
    C1750a f1791h;

    @Singleton
    /* compiled from: vungle */
    public static class C1750a extends C1717a<ep, Integer> {
        @Inject
        Provider<ep> f1783a;

        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            ep epVar = (ep) dwVar;
            epVar.f1784a = cm.m1261f(cursor, "ad_id");
            epVar.f1785b = cm.m1261f(cursor, "delivery_id");
            epVar.f1786c = (jt) cm.m1254a(cursor, DataLayer.EVENT_KEY, C1798a.class);
            epVar.u = cm.m1259d(cursor, "id");
            epVar.f1787d = cm.m1260e(cursor, "insert_timestamp_millis").longValue();
            epVar.f1788e = cm.m1259d(cursor, "response_code");
            epVar.f1789f = cm.m1260e(cursor, "response_timestamp_millis");
            epVar.f1790g = cm.m1261f(cursor, "url");
            return epVar;
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1750a() {
        }

        protected final String mo4385c() {
            return "event_tracking_http_log";
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }

        protected final /* synthetic */ dw c_() {
            return (ep) this.f1783a.get();
        }
    }

    @Inject
    ep() {
    }

    protected final String mo4391c() {
        return "event_tracking_http_log";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("id", (Integer) mo4410w());
            long currentTimeMillis = System.currentTimeMillis();
            this.f1787d = currentTimeMillis;
            contentValues.put("insert_timestamp_millis", Long.valueOf(currentTimeMillis));
        }
        contentValues.put("ad_id", this.f1784a);
        contentValues.put("delivery_id", this.f1785b);
        contentValues.put(DataLayer.EVENT_KEY, this.f1786c.toString());
        contentValues.put("response_code", this.f1788e);
        contentValues.put("response_timestamp_millis", this.f1789f);
        contentValues.put("url", this.f1790g);
        return contentValues;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "ad_id", this.f1784a, false);
        dw.m1312a(m, "delivery_id", this.f1785b, false);
        dw.m1312a(m, DataLayer.EVENT_KEY, this.f1786c, false);
        dw.m1312a(m, "response_code", this.f1788e, false);
        dw.m1312a(m, "response_timestamp_millis", this.f1789f, false);
        dw.m1312a(m, "url", this.f1790g, false);
        dw.m1312a(m, "insert_timestamp_millis", Long.valueOf(this.f1787d), false);
        return m;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1791h;
    }
}
