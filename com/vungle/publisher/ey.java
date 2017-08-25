package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.gs.C1738b;
import com.vungle.publisher.gs.C1777a;
import com.vungle.publisher.ju.C1757a;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ey extends ju<ez> implements C1738b<ez> {
    String f1838a;
    public gs f1839b;
    @Inject
    C1760a f1840c;
    @Inject
    C1758a f1841d;

    @Singleton
    /* compiled from: vungle */
    public static class C1758a extends C1757a<ez, ey, ade> {
        private static final C1753b f1825c = C1753b.localVideo;
        @Inject
        Provider<ey> f1826a;
        @Inject
        C1777a f1827b;

        @Inject
        protected C1758a() {
        }

        protected final C1753b mo4440a() {
            return f1825c;
        }

        private ey m1690a(ez ezVar, ade com_vungle_publisher_ade) {
            ey eyVar = (ey) super.mo4442a((jv) ezVar, (adq) com_vungle_publisher_ade);
            if (eyVar != null) {
                eyVar.f1838a = com_vungle_publisher_ade.f1119m;
                eyVar.mo4411a(com_vungle_publisher_ade.f1118l);
                eyVar.f1839b.f2014b = com_vungle_publisher_ade.m1059j();
                eyVar.r = f1825c;
            }
            return eyVar;
        }

        private ey m1689a(ey eyVar, Cursor cursor, boolean z) {
            super.mo4441a((ju) eyVar, cursor, z);
            eyVar.f1839b.m1846a(cursor);
            eyVar.f1838a = cm.m1261f(cursor, "checksum");
            return eyVar;
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new ey[i];
        }

        protected final /* synthetic */ dw c_() {
            ey eyVar = (ey) this.f1826a.get();
            eyVar.f1839b = this.f1827b.m1841a(eyVar);
            return eyVar;
        }
    }

    @Inject
    protected ey() {
    }

    public final String mo4412e() {
        return mo4409t() + ".mp4";
    }

    public final String mo4413f() {
        return this.f1839b.f2014b;
    }

    public final void mo4411a(Integer num) {
        this.f1839b.f2015c = num;
    }

    public final String mo4414g() {
        return this.f1839b.m1849c();
    }

    public final Uri mo4443q() {
        return Uri.fromFile(new File(this.f1839b.m1849c()));
    }

    public final boolean mo4415h() {
        return this.f1839b.m1851e();
    }

    public final boolean mo4419o() {
        return this.f1839b.m1852f();
    }

    public final boolean mo4416i() {
        return this.f1839b.m1852f();
    }

    public final boolean mo4420p() {
        return this.f1839b.m1853g();
    }

    public final int mo4395n() {
        return this.f1839b.m1850d();
    }

    public final boolean mo4417j() {
        return this.f1839b.m1854h();
    }

    public final int mo4418k() {
        return super.mo4395n();
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        this.f1839b.m1845a(a);
        a.put("checksum", this.f1838a);
        return a;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        this.f1839b.m1847a(m);
        dw.m1312a(m, "checksum", this.f1838a, false);
        return m;
    }

    protected final /* bridge */ /* synthetic */ C1718a mo4421r() {
        return this.f1840c;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1841d;
    }
}
