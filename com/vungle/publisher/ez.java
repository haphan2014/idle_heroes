package com.vungle.publisher;

import android.database.Cursor;
import android.database.SQLException;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ed.C1741a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ey.C1758a;
import com.vungle.publisher.fa.C1764a;
import com.vungle.publisher.ff.C1765a;
import com.vungle.publisher.ge.C1776a;
import com.vungle.publisher.js.C1775a;
import com.vungle.publisher.ju.C1757a;
import com.vungle.publisher.jv.C1759a;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ez extends jv<ez, ey, ade> implements dy<ez> {
    fa f1855p;
    public ed f1856q;
    boolean f1857r;
    @Inject
    C1760a f1858s;

    @Singleton
    /* compiled from: vungle */
    public static class C1760a extends C1759a<ez, ey, ade> implements eh<ez, ade> {
        @Inject
        Provider<String> f1842c;
        @Inject
        C1764a f1843e;
        @Inject
        Provider<ez> f1844f;
        @Inject
        C1758a f1845g;
        @Inject
        C1765a f1846h;
        @Inject
        C1741a f1847i;
        @Inject
        C1776a f1848j;

        public final /* synthetic */ ei i_() {
            return m1730g();
        }

        public final /* bridge */ /* synthetic */ C1718a j_() {
            return this;
        }

        @Inject
        C1760a() {
        }

        private ez m1728a(ade com_vungle_publisher_ade) throws qo {
            ez ezVar = (ez) super.mo4449a((adq) com_vungle_publisher_ade);
            ezVar.m1327a((String) this.f1842c.get());
            ezVar.f1855p = this.f1843e.m1764a(ezVar, com_vungle_publisher_ade, C1753b.postRoll);
            ezVar.f1856q = this.f1847i.m1560a(ezVar);
            ezVar.mo4457a(C1722c.aware);
            return ezVar;
        }

        protected final C1893v mo4451a() {
            return C1893v.vungle_local;
        }

        public final int mo4381a(List<ez> list) {
            return m1730g().m1581a(list);
        }

        private ez m1729a(ez ezVar, Cursor cursor, boolean z) {
            super.mo4450a((jv) ezVar, cursor, z);
            ezVar.m1327a(cm.m1261f(cursor, "parent_path"));
            ezVar.f1856q = this.f1847i.m1560a(ezVar);
            if (z) {
                m1736a(ezVar, z);
            }
            return ezVar;
        }

        final fa m1736a(ez ezVar, boolean z) {
            if (ezVar.f1857r) {
                return ezVar.f1855p;
            }
            fa faVar = (fa) this.f1843e.m1486a((String) ezVar.u, C1753b.postRoll, z);
            ezVar.f1855p = faVar;
            ezVar.f1857r = true;
            return faVar;
        }

        private ff m1730g() {
            return (ff) this.f1846h.m1569a(this);
        }

        protected final /* bridge */ /* synthetic */ C1775a mo4452e() {
            return this.f1848j;
        }

        protected final /* bridge */ /* synthetic */ C1757a mo4453f() {
            return this.f1845g;
        }

        protected final /* synthetic */ dw c_() {
            return (ez) this.f1844f.get();
        }
    }

    public final /* synthetic */ String mo4459d() {
        return (String) super.mo4410w();
    }

    public final /* bridge */ /* synthetic */ cu h_() {
        return this;
    }

    public final /* synthetic */ Object mo4400v() {
        return mo4463q();
    }

    @Inject
    protected ez() {
    }

    public final fa m1757p() {
        return this.f1858s.m1736a(this, false);
    }

    public final void mo4457a(C1722c c1722c) {
        C1722c c1722c2 = this.d;
        super.mo4457a(c1722c);
        this.f1856q.m1561a(c1722c2, c1722c);
    }

    public final List<gr<ez>> f_() {
        List<gr<ez>> arrayList = new ArrayList();
        ey eyVar = (ey) m1751u();
        if (eyVar != null) {
            arrayList.add(eyVar);
        }
        fa p = m1757p();
        if (p != null) {
            arrayList.add(p);
        }
        return arrayList;
    }

    public final boolean g_() {
        boolean z;
        boolean z2 = false;
        ey eyVar = (ey) m1751u();
        ex p = m1757p();
        boolean z3 = eyVar != null;
        if (p != null) {
            z = true;
        } else {
            z = false;
        }
        if (z3 || z) {
            z2 = true;
        }
        String z4 = mo4389z();
        if (z2) {
            if (z3) {
                so.m2470a(2, "VunglePrepare", z4 + " has " + C1753b.localVideo + ": " + eyVar.f1839b.f2014b, null);
            }
            if (z) {
                so.m2470a(2, "VunglePrepare", z4 + " has " + C1753b.postRoll + ": " + p.f1824g.f2014b, null);
            }
        } else {
            mo4457a(C1722c.invalid);
        }
        return z2;
    }

    public final boolean mo4458b() {
        return qt.m2372a(m1335h());
    }

    public final String mo4463q() throws SQLException {
        String q = super.mo4463q();
        if (this.f1855p != null) {
            this.f1855p.mo4400v();
        }
        return q;
    }

    public final int b_() {
        int b_ = super.b_();
        if (b_ == 1 && this.f1855p != null) {
            this.f1855p.b_();
        }
        return b_;
    }

    public final /* bridge */ /* synthetic */ C1759a mo4464r() {
        return this.f1858s;
    }

    public final /* bridge */ /* synthetic */ C1718a mo4456a() {
        return this.f1858s;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1858s;
    }
}
