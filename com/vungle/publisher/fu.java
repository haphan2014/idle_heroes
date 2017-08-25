package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.db.C1727a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.dz.C1739a;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.fp.C1769a;
import com.vungle.publisher.jy.C1770a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class fu extends jy<fu, fp, fv, ez, ey> implements en {
    @Inject
    C1771a f1931w;
    @Inject
    C1769a f1932x;
    public dz f1933y;

    @Singleton
    /* compiled from: vungle */
    public static class C1771a extends C1770a<fu, fp, fv, ez, ey, ade> {
        @Inject
        C1760a f1927c;
        @Inject
        C1769a f1928e;
        @Inject
        Provider<fu> f1929f;
        @Inject
        C1739a f1930g;

        protected final /* bridge */ /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            return m1794a((fu) dwVar, cursor, false);
        }

        @Inject
        protected C1771a() {
        }

        public final C1893v mo4474f() {
            return C1893v.vungle_local;
        }

        private fu m1794a(fu fuVar, Cursor cursor, boolean z) {
            super.mo4471a((db) fuVar, cursor, z);
            fuVar.o = cm.m1260e(cursor, "download_end_millis");
            return fuVar;
        }

        protected final /* bridge */ /* synthetic */ C1726a mo4473e() {
            return this.f1928e;
        }

        protected final /* bridge */ /* synthetic */ C1718a mo4470a() {
            return this.f1927c;
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new fu[i];
        }

        protected final /* synthetic */ dw c_() {
            return (fu) this.f1929f.get();
        }
    }

    @Inject
    protected fu() {
    }

    public final void a_(Long l) {
        this.f1933y.m1555a(l);
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        this.f1933y.m1554a(a);
        return a;
    }

    public final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "download_end_millis", this.o, false);
        return m;
    }

    protected final /* bridge */ /* synthetic */ C1726a mo4477e() {
        return this.f1932x;
    }

    public final /* bridge */ /* synthetic */ C1727a mo4476b() {
        return this.f1931w;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1931w;
    }
}
