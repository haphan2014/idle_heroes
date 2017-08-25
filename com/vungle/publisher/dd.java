package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.eu.C1751a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class dd extends dw<Integer> {
    Integer f1631a;
    public String f1632b;
    public String f1633c;
    @Inject
    C1733a f1634d;

    @Singleton
    /* compiled from: vungle */
    public static class C1733a extends C1717a<dd, Integer> {
        @Inject
        Provider<dd> f1629a;
        @Inject
        C1751a f1630b;

        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            dd ddVar = (dd) dwVar;
            ddVar.u = cm.m1259d(cursor, "id");
            ddVar.f1631a = cm.m1259d(cursor, "ad_report_id");
            ddVar.f1632b = cm.m1261f(cursor, "name");
            ddVar.f1633c = cm.m1261f(cursor, "value");
            return ddVar;
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        protected final /* synthetic */ dw c_() {
            return m1443a();
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1733a() {
        }

        public final int m1441a(Integer num) {
            int delete = this.d.getWritableDatabase().delete("ad_report_extra", "ad_report_id = ?", new String[]{String.valueOf(num)});
            so.m2470a(2, "VungleDatabase", "deleted " + delete + " ad_report_extra records for adReportId: " + num, null);
            return delete;
        }

        final eu m1447b(Integer num) {
            Throwable th;
            Cursor cursor = null;
            if (num == null) {
                so.m2470a(5, "VungleDatabase", "failed to fetch ad_report_extra records by ad_report_id " + num, null);
                return null;
            }
            try {
                so.m2470a(3, "VungleDatabase", "fetching ad_report_extra records by ad_report_id " + num, null);
                Cursor query = this.d.getReadableDatabase().query("ad_report_extra", null, "ad_report_id = ?", new String[]{String.valueOf(num)}, null, null, null);
                try {
                    eu euVar;
                    int count = query.getCount();
                    so.m2470a(2, "VungleDatabase", count + " ad_report_extra for ad_report_id " + num, null);
                    if (count > 0) {
                        euVar = new eu();
                        while (query.moveToNext()) {
                            dw a = m1443a();
                            m1280b(a, query);
                            euVar.put(a.f1632b, a);
                        }
                    } else {
                        euVar = null;
                    }
                    if (query == null) {
                        return euVar;
                    }
                    query.close();
                    return euVar;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        protected final String mo4385c() {
            return "ad_report_extra";
        }

        final dd m1443a() {
            return (dd) this.f1629a.get();
        }
    }

    @Inject
    dd() {
    }

    protected final String mo4391c() {
        return "ad_report_extra";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("ad_report_id", this.f1631a);
        }
        contentValues.put("name", this.f1632b);
        contentValues.put("value", this.f1633c);
        return contentValues;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "ad_report_id", this.f1631a, false);
        dw.m1312a(m, "name", this.f1632b, false);
        dw.m1312a(m, "value", this.f1633c, false);
        return m;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1634d;
    }
}
