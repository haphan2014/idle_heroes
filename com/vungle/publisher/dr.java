package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.gs.C1738b;
import com.vungle.publisher.gs.C1777a;
import com.vungle.publisher.jn.C1796a;
import com.vungle.publisher.ka.C1736a;
import com.vungle.publisher.kd.C1801a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class dr extends ka<kd> implements C1738b<kd> {
    gs f1685a;
    String f1686b;
    String f1687c;
    jn f1688d;
    @Inject
    C1801a f1689e;
    @Inject
    C1737a f1690f;

    @Singleton
    /* compiled from: vungle */
    static class C1737a extends C1736a<kd, dr, ads> {
        @Inject
        Provider<dr> f1677a;
        @Inject
        C1777a f1678b;
        @Inject
        C1796a f1679c;

        @Inject
        C1737a() {
        }

        private dr m1490a(dr drVar, Cursor cursor, boolean z) {
            super.mo4402a((ka) drVar, cursor, z);
            drVar.f1686b = cm.m1261f(cursor, "extension");
            drVar.f1687c = cm.m1261f(cursor, "name");
            drVar.f1685a.m1846a(cursor);
            return drVar;
        }

        public final List<dr> m1493a(kd kdVar, ads com_vungle_publisher_ads) {
            Collection<aeg> values = com_vungle_publisher_ads.f1171l.f1221a.values();
            List arrayList = new ArrayList();
            for (aeg com_vungle_publisher_aeg : values) {
                dr drVar = null;
                if (com_vungle_publisher_ads != null) {
                    if (com_vungle_publisher_aeg != null) {
                        drVar = (dr) super.mo4439a((cu) kdVar, (acr) com_vungle_publisher_ads);
                        drVar.r = C1753b.asset;
                        String str = com_vungle_publisher_aeg.f1219b;
                        String str2 = com_vungle_publisher_aeg.f1218a;
                        String str3 = com_vungle_publisher_aeg.f1220c;
                        if (str == null) {
                            throw new IllegalArgumentException("asset object must have a non-null url");
                        } else if (str2 == null) {
                            throw new IllegalArgumentException("asset object must have a non-null extension");
                        } else if (str3 == null) {
                            throw new IllegalArgumentException("asset object must have a non-null name");
                        } else {
                            drVar.f1687c = str3;
                            drVar.f1686b = str2;
                            drVar.f1685a.f2014b = str;
                        }
                    } else {
                        throw new IllegalArgumentException("cannot create asset with null url");
                    }
                }
                drVar.f1688d = this.f1679c.m2014a((String) kdVar.mo4410w(), drVar.f1687c, drVar.f1685a.m1849c());
                arrayList.add(drVar);
            }
            return arrayList;
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new dr[i];
        }

        protected final /* synthetic */ dw c_() {
            dr drVar = (dr) this.f1677a.get();
            drVar.f1685a = this.f1678b.m1841a(drVar);
            return drVar;
        }
    }

    public final /* synthetic */ Object mo4400v() {
        return m1535q();
    }

    @Inject
    dr() {
    }

    public final String mo4412e() {
        return this.f1687c + "." + this.f1686b;
    }

    public final String mo4413f() {
        return this.f1685a.f2014b;
    }

    public final void mo4411a(Integer num) {
        this.f1685a.f2015c = num;
    }

    public final String mo4414g() {
        return this.f1685a.m1849c();
    }

    public final boolean mo4415h() {
        return this.f1685a.m1851e();
    }

    public final boolean mo4416i() {
        return this.f1685a.m1852f();
    }

    public final boolean mo4417j() {
        return this.f1685a.m1848b();
    }

    public final int mo4418k() {
        return super.mo4395n();
    }

    public final boolean mo4419o() {
        return true;
    }

    public final boolean mo4420p() {
        return true;
    }

    public final Integer m1535q() {
        Integer num = (Integer) super.mo4400v();
        if (this.f1688d != null) {
            this.f1688d.mo4400v();
        }
        return num;
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        this.f1685a.m1845a(a);
        a.put("name", this.f1687c);
        a.put("extension", this.f1686b);
        return a;
    }

    protected final /* bridge */ /* synthetic */ C1718a mo4421r() {
        return this.f1689e;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1690f;
    }
}
