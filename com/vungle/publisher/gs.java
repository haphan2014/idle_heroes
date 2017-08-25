package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.vungle.publisher.ew.C1752a;
import com.vungle.publisher.ew.C1753b;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class gs {
    C1738b<?> f2013a;
    public String f2014b;
    Integer f2015c;
    @Inject
    pj f2016d;
    @Inject
    pu f2017e;

    /* compiled from: vungle */
    public interface C1738b<A extends cu> extends gr<A> {
        String mo4412e();

        boolean mo4419o();

        boolean mo4420p();
    }

    @Singleton
    /* compiled from: vungle */
    static class C1777a {
        @Inject
        Provider<gs> f2012a;

        @Inject
        C1777a() {
        }

        final gs m1841a(C1738b<?> c1738b) {
            gs gsVar = (gs) this.f2012a.get();
            gsVar.f2013a = c1738b;
            return gsVar;
        }
    }

    @Inject
    gs() {
    }

    private String m1842i() {
        return this.f2013a.mo4407l();
    }

    final File m1844a() {
        String c = m1849c();
        return c == null ? null : new File(c);
    }

    final boolean m1848b() {
        File a = m1844a();
        if (a == null) {
            so.m2470a(5, "VunglePrepare", "null " + this.f2013a.mo4409t() + " file for ad " + m1842i(), null);
            return false;
        } else if (a.exists()) {
            so.m2470a(2, "VunglePrepare", a.getAbsolutePath() + " exists, " + a.length() + " bytes", null);
            return true;
        } else {
            so.m2470a(5, "VunglePrepare", a.getAbsolutePath() + " missing ", null);
            return false;
        }
    }

    final String m1849c() {
        return qt.m2369a(this.f2013a.mo4406d(), this.f2013a.mo4412e());
    }

    private C1753b m1843j() {
        return this.f2013a.mo4409t();
    }

    final int m1850d() {
        this.f2013a.mo4417j();
        return this.f2013a.mo4418k();
    }

    final boolean m1851e() {
        boolean o = this.f2013a.mo4419o();
        if (o) {
            C1752a c1752a = C1752a.ready;
            so.m2470a(4, "VunglePrepare", m1843j() + " " + c1752a + " for ad_id " + m1842i(), null);
            this.f2013a.mo4405b(c1752a);
        } else {
            Object obj = !TextUtils.isEmpty(afy.m1205a("com.vungle.debug")) ? 1 : null;
            if (obj != null) {
                so.m2470a(3, "VungleAd", "in debug mode", null);
            } else {
                so.m2470a(2, "VungleAd", "not in debug mode", null);
            }
            if (obj != null) {
                so.m2470a(4, "VunglePrepare", "debug mode: post-processing failed for " + this.f2013a.mo4389z() + " - not deleting " + m1849c(), null);
            } else {
                so.m2470a(3, "VunglePrepare", "post-processing failed for " + this.f2013a.mo4389z() + " - deleting " + m1849c(), null);
                this.f2013a.mo4417j();
            }
            this.f2013a.mo4405b(C1752a.aware);
        }
        return o;
    }

    final boolean m1852f() throws qo {
        C1752a c1752a;
        boolean p = this.f2013a.mo4420p();
        String i = m1842i();
        C1753b j = m1843j();
        if (p) {
            so.m2470a(4, "VunglePrepare", j + " verified for ad_id " + i, null);
            c1752a = C1752a.ready;
        } else {
            so.m2470a(5, "VunglePrepare", j + " failed verification; reprocessing ad_id " + i, null);
            c1752a = C1752a.aware;
        }
        this.f2013a.mo4405b(c1752a);
        return p;
    }

    final boolean m1853g() throws qo {
        if (this.f2016d.mo4432l()) {
            String i = m1842i();
            C1753b j = m1843j();
            if (this.f2015c == null) {
                so.m2470a(3, "VunglePrepare", j + " size " + this.f2015c + " for ad_id: " + i, null);
                return true;
            }
            int i2;
            File a = m1844a();
            if (a == null) {
                i2 = 0;
            } else {
                i2 = (int) a.length();
            }
            if (i2 == this.f2015c.intValue()) {
                so.m2470a(3, "VunglePrepare", j + " disk size matched size " + this.f2015c + " for ad_id: " + i, null);
                return true;
            }
            so.m2470a(3, "VunglePrepare", j + " disk size " + i2 + " failed to match size " + this.f2015c + " for ad_id: " + i, null);
            if (!m1848b()) {
                return false;
            }
            so.m2470a(3, "VunglePrepare", "ignoring " + j + " size mismatch - file exists", null);
            return true;
        }
        throw new qo();
    }

    final boolean m1854h() {
        File a = m1844a();
        so.m2470a(3, "VunglePrepare", "deleting " + a, null);
        return a != null && a.delete();
    }

    final void m1845a(ContentValues contentValues) {
        contentValues.put("url", this.f2014b);
        contentValues.put("size", this.f2015c);
    }

    final void m1846a(Cursor cursor) {
        this.f2014b = cm.m1261f(cursor, "url");
        this.f2015c = cm.m1259d(cursor, "size");
    }

    final void m1847a(StringBuilder stringBuilder) {
        dw.m1312a(stringBuilder, "url", this.f2014b, false);
        dw.m1312a(stringBuilder, "size", this.f2015c, false);
    }
}
