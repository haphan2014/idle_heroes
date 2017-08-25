package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.he.C1781a;
import com.vungle.publisher.ly.C1813a;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class hd extends dx implements dy<hd> {
    String f2056p;
    @Inject
    C1780a f2057q;
    @Inject
    C1813a f2058r;

    @Singleton
    /* compiled from: vungle */
    public static class C1780a extends C1718a<hd, adh> implements eh<hd, adh> {
        @Inject
        Provider<hd> f2054c;
        @Inject
        C1781a f2055e;

        protected final /* bridge */ /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            return m1879a((hd) dwVar, cursor, false);
        }

        public final /* synthetic */ ei i_() {
            return m1880e();
        }

        @Inject
        C1780a() {
        }

        private hd m1879a(hd hdVar, Cursor cursor, boolean z) {
            super.mo4445a(hdVar, cursor, z);
            hdVar.f2056p = cm.m1261f(cursor, "html_content");
            return hdVar;
        }

        protected final C1893v mo4451a() {
            return C1893v.third_party_mraid;
        }

        public final C1718a<hd, adh> j_() {
            return this;
        }

        public final int mo4381a(List<hd> list) {
            return m1880e().m1581a(list);
        }

        private he m1880e() {
            return (he) this.f2055e.m1569a(this);
        }

        protected final /* synthetic */ dw c_() {
            return (hd) this.f2054c.get();
        }
    }

    public final /* synthetic */ String mo4459d() {
        return (String) super.mo4410w();
    }

    public final /* bridge */ /* synthetic */ cu h_() {
        return this;
    }

    @Inject
    hd() {
    }

    protected final boolean mo4458b() {
        return true;
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        a.put("html_content", this.f2056p);
        return a;
    }

    public final boolean g_() {
        return true;
    }

    public final List<gr<hd>> f_() {
        return new ArrayList();
    }

    public final /* synthetic */ lv mo4481p() {
        return this.f2058r.m2148a(this.f2056p);
    }

    public final /* bridge */ /* synthetic */ C1718a mo4456a() {
        return this.f2057q;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2057q;
    }
}
