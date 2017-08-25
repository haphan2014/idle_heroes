package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dm.C1734a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.gs.C1738b;
import com.vungle.publisher.gs.C1777a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ka.C1736a;
import com.vungle.publisher.qw.C1754a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class ex<A extends cu, V extends ex<A, V>> extends ka<A> implements C1738b<A> {
    dm[] f1818a;
    boolean f1819b;
    boolean f1820c;
    boolean f1821d;
    @Inject
    C1778a f1822e;
    @Inject
    C1734a f1823f;
    @Inject
    gs f1824g;

    /* compiled from: vungle */
    static abstract class C1756a<A extends cu, V extends ex<A, V>, R extends acr> extends C1736a<A, V, R> {
        @Inject
        C1777a f1817a;

        protected final /* bridge */ /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            return m1656a((ex) dwVar, cursor, false);
        }

        protected C1756a() {
        }

        V mo4465a(A a, R r, C1753b c1753b) {
            ex exVar = (ex) super.mo4439a((cu) a, (acr) r);
            if (exVar != null) {
                exVar.r = c1753b;
            }
            return exVar;
        }

        private V m1656a(V v, Cursor cursor, boolean z) {
            super.mo4402a((ka) v, cursor, z);
            v.f1824g.m1846a(cursor);
            if (z) {
                v.m1679q();
            }
            return v;
        }
    }

    public final String mo4412e() {
        return mo4409t() + ".zip";
    }

    public final String mo4413f() {
        return this.f1824g.f2014b;
    }

    public final void m1667a(String str) {
        this.f1824g.f2014b = str;
    }

    public final void mo4411a(Integer num) {
        this.f1824g.f2015c = num;
    }

    public final dm[] m1679q() {
        if (!this.f1819b) {
            m1662a(this.f1823f.m1468a(this), false);
        }
        return this.f1818a;
    }

    private void m1662a(dm[] dmVarArr, boolean z) {
        this.f1818a = dmVarArr;
        this.f1820c = z;
        this.f1819b = true;
    }

    final String m1680u() {
        return qt.m2369a(mo4406d(), this.r);
    }

    public final File m1663B() {
        return new File(mo4486C());
    }

    public String mo4486C() {
        return qt.m2369a(m1680u(), "index.html");
    }

    public final String mo4414g() {
        return this.f1824g.m1849c();
    }

    public final boolean mo4415h() {
        return this.f1824g.m1851e();
    }

    public final boolean mo4419o() {
        if (this.f1824g.m1853g() && m1660E()) {
            return mo4420p();
        }
        return false;
    }

    private boolean m1660E() {
        File a = this.f1824g.m1844a();
        try {
            final List arrayList = new ArrayList();
            qw.m2377a(a, new File(m1680u()), new C1754a(this) {
                final /* synthetic */ ex f1816b;

                public final void mo4438a(File file, String str, long j) {
                    so.m2470a(2, "VunglePrepare", "extracted " + file + ": " + j + " bytes", null);
                    List list = arrayList;
                    C1734a c1734a = this.f1816b.f1823f;
                    ex exVar = this.f1816b;
                    int i = (int) j;
                    dm a = c1734a.m1465a();
                    a.f1662a = exVar;
                    a.f1663b = str;
                    a.f1664c = Integer.valueOf(i);
                    list.add(a);
                }
            });
            m1662a((dm[]) arrayList.toArray(new dm[arrayList.size()]), true);
            return true;
        } catch (Throwable e) {
            this.f1822e.m1867b("VunglePrepare", "error extracting " + a, e);
            return false;
        }
    }

    public final boolean mo4416i() {
        return this.f1824g.m1852f();
    }

    public final boolean mo4420p() {
        dm[] q = m1679q();
        int length = q.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            File file;
            dm dmVar = q[i];
            String a = qt.m2369a(dmVar.f1662a.m1680u(), dmVar.f1663b);
            if (a == null) {
                file = null;
            } else {
                file = new File(a);
            }
            if (dmVar.f1664c == null) {
                so.m2470a(5, "VunglePrepare", file + " size is null", null);
                z = false;
            } else {
                boolean z2;
                int length2 = (int) file.length();
                int intValue = dmVar.f1664c.intValue();
                if (length2 == intValue) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    so.m2470a(2, "VunglePrepare", file + " size verified " + length2, null);
                    z = z2;
                } else {
                    so.m2470a(3, "VunglePrepare", file + " size " + length2 + " doesn't match expected " + intValue, null);
                    z = file.exists();
                }
            }
            if (!z) {
                return false;
            }
            i++;
            z = true;
        }
        return z;
    }

    public final int mo4395n() {
        m1661F();
        return this.f1824g.m1850d();
    }

    private boolean m1661F() {
        String u = m1680u();
        so.m2470a(3, "VungleDatabase", "deleting " + this.r + " directory " + u, null);
        boolean a = qt.m2372a(m1680u());
        if (a) {
            so.m2470a(2, "VungleDatabase", "deleting " + this.r + " directory " + u, null);
            this.f1818a = null;
            this.f1821d = true;
        } else {
            so.m2470a(5, "VungleDatabase", "failed to delete " + this.r + " directory " + u, null);
        }
        return a;
    }

    public final int mo4418k() {
        return super.mo4395n();
    }

    public final int b_() {
        int b_ = super.b_();
        if (b_ == 1) {
            if (this.f1821d) {
                this.f1823f.m1463a((Integer) this.u);
                m1661F();
                so.m2470a(2, "VungleDatabase", "resetting areArchiveEntriesDeleted = false", null);
                this.f1821d = false;
            } else if (this.f1820c) {
                C1717a.m1270a(this.f1818a);
                so.m2470a(2, "VungleDatabase", "resetting areArchiveEntriesNew = false", null);
                this.f1820c = false;
            }
        }
        return b_;
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        this.f1824g.m1845a(a);
        return a;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        this.f1824g.m1847a(m);
        return m;
    }

    public final boolean mo4417j() {
        return this.f1824g.m1854h() & m1661F();
    }
}
