package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.db.C1727a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.dz.C1739a;
import com.vungle.publisher.kd.C1801a;
import com.vungle.publisher.kt.C1805a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ky extends db<ky, kt, kz, kd> implements en {
    public dz f2416w;
    public String f2417x;
    @Inject
    C1806a f2418y;

    @Singleton
    /* compiled from: vungle */
    public static class C1806a extends C1727a<ky, kt, kz, kd, ads> {
        @Inject
        C1801a f2412c;
        @Inject
        C1805a f2413e;
        @Inject
        Provider<ky> f2414f;
        @Inject
        C1739a f2415g;

        protected final /* bridge */ /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            return m2096a((ky) dwVar, cursor, false);
        }

        @Inject
        C1806a() {
        }

        private ky m2096a(ky kyVar, Cursor cursor, boolean z) {
            super.mo4471a((db) kyVar, cursor, z);
            kyVar.o = cm.m1260e(cursor, "download_end_millis");
            kyVar.f2417x = cm.m1261f(cursor, "template_id");
            return kyVar;
        }

        public final C1893v mo4474f() {
            return C1893v.vungle_mraid;
        }

        protected final /* bridge */ /* synthetic */ C1726a mo4473e() {
            return this.f2413e;
        }

        protected final /* bridge */ /* synthetic */ C1718a mo4470a() {
            return this.f2412c;
        }

        protected final /* synthetic */ dw c_() {
            return (ky) this.f2414f.get();
        }
    }

    @Inject
    ky() {
    }

    public final void a_(Long l) {
        this.f2416w.m1555a(l);
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        this.f2416w.m1554a(a);
        if (z) {
            a.put("template_id", this.f2417x);
        }
        return a;
    }

    protected final /* bridge */ /* synthetic */ C1726a mo4477e() {
        return this.f2418y.f2413e;
    }

    public final /* bridge */ /* synthetic */ C1727a mo4476b() {
        return this.f2418y;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2418y;
    }
}
