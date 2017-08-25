package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dw.C1717a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class cv extends dw<Integer> {
    public String f1568a;
    public Integer f1569b;
    @Inject
    C1723a f1570c;

    @Singleton
    /* compiled from: vungle */
    public static class C1723a extends C1717a<cv, Integer> {
        @Inject
        Provider<cv> f1567a;

        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            cv cvVar = (cv) dwVar;
            cvVar.f1568a = cm.m1261f(cursor, "code");
            cvVar.f1569b = cm.m1259d(cursor, "report_id");
            return cvVar;
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        protected final /* synthetic */ dw c_() {
            return m1343a();
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1723a() {
        }

        protected final String mo4385c() {
            return "errors";
        }

        public final List<cv> m1345a(Integer num) {
            return super.mo4383a("report_id = ?", new String[]{num.toString()});
        }

        public final cv m1343a() {
            return (cv) this.f1567a.get();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }
    }

    @Inject
    cv() {
    }

    protected final String mo4391c() {
        return "errors";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("id", (Integer) this.u);
            contentValues.put("report_id", this.f1569b);
        }
        contentValues.put("code", this.f1568a);
        return contentValues;
    }

    public final String toString() {
        return this.f1568a;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1570c;
    }
}
