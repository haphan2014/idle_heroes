package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.games.Games;
import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.db.C1731c;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.hd.C1780a;
import com.vungle.publisher.kd.C1801a;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class cu extends dw<String> {
    protected static final String f1552a = ("(SELECT DISTINCT ad_id FROM ad_report WHERE status IN ('" + C1731c.reportable + "', '" + C1731c.playing + "'))");
    protected static final String f1553b = ("id NOT IN " + f1552a);
    protected C1893v f1554c;
    protected C1722c f1555d;
    protected long f1556e;
    protected long f1557f;
    protected long f1558g;
    protected String f1559h;
    protected String f1560i;
    int f1561j;
    Long f1562k;
    String f1563l;
    int f1564m;
    long f1565n;
    String f1566o;

    /* compiled from: vungle */
    public static abstract class C1718a<A extends cu, R extends acr> extends C1717a<A, String> {
        @Inject
        qh f1531a;
        @Inject
        agg f1532b;

        protected abstract C1893v mo4451a();

        protected /* synthetic */ Object[] mo4384b(int i) {
            return a_(i);
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        public A mo4444a(R r) {
            cu cuVar = (cu) c_();
            cuVar.u = r.f1047f;
            cuVar.f1554c = mo4451a();
            cuVar.t = String.class;
            cuVar.f1562k = r.f1044c;
            mo4446a(cuVar, (acr) r);
            return cuVar;
        }

        protected final int m1296b() {
            so.m2470a(3, "VungleDatabase", "deleting " + mo4451a() + " records without pending reports in status " + C1722c.deleting, null);
            return this.d.getWritableDatabase().delete("ad", cu.f1553b + " AND status = ?", new String[]{r0.toString()});
        }

        public final boolean m1295a(cu cuVar) {
            if (!m1281b("id = ? AND " + cu.f1553b + " AND ((expiration_timestamp_seconds IS NULL OR expiration_timestamp_seconds <= ?) OR status != ?)", new String[]{(String) cuVar.mo4410w(), Long.toString(System.currentTimeMillis() / 1000), C1722c.ready.toString()})) {
                return false;
            }
            so.m2470a(3, "VungleDatabase", "deleting ad after successful report", null);
            if (cuVar.mo4395n() > 0) {
                return true;
            }
            return false;
        }

        protected final int m1288a(List<? extends cu> list, C1722c c1722c) {
            int size = list.size();
            Object[] objArr = new String[size];
            int i = 0;
            int i2 = 0;
            for (cu cuVar : list) {
                int i3;
                int i4 = i + 1;
                objArr[i] = (String) cuVar.mo4410w();
                C1722c g = cuVar.m1334g();
                if (c1722c != C1722c.ready && g == C1722c.ready) {
                    i3 = -1;
                } else if (c1722c != C1722c.ready || g == C1722c.ready) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                i3 += i2;
                cuVar.mo4457a(c1722c);
                i = i4;
                i2 = i3;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(Games.EXTRA_STATUS, c1722c.toString());
            String str = "id IN (" + cm.m1256a(size) + ")";
            so.m2470a(3, "VungleDatabase", "updating status of ads " + agf.m1217a(objArr) + " to " + c1722c, null);
            int updateWithOnConflict = this.d.getWritableDatabase().updateWithOnConflict(mo4385c(), contentValues, str, objArr, 3);
            if (updateWithOnConflict > 0) {
                if (i2 > 0) {
                    so.m2470a(3, "VungleDatabase", "ad availability increased by " + i2, null);
                    this.f1531a.m2361a(new as());
                } else if (i2 < 0) {
                    so.m2470a(3, "VungleDatabase", "ad availability decreased by " + i2, null);
                    this.f1531a.m2361a(new an());
                }
            }
            return updateWithOnConflict;
        }

        protected A mo4445a(A a, Cursor cursor, boolean z) {
            a.f1560i = cm.m1261f(cursor, "advertising_app_vungle_id");
            a.f1559h = cm.m1261f(cursor, "delivery_id");
            a.u = cm.m1261f(cursor, "id");
            a.f1556e = cm.m1260e(cursor, "insert_timestamp_millis").longValue();
            a.f1555d = (C1722c) cm.m1254a(cursor, Games.EXTRA_STATUS, C1722c.class);
            a.f1554c = (C1893v) cm.m1254a(cursor, "type", C1893v.class);
            a.f1557f = cm.m1260e(cursor, "update_timestamp_millis").longValue();
            a.f1558g = cm.m1260e(cursor, "failed_timestamp_millis").longValue();
            a.f1561j = cm.m1258c(cursor, "delete_local_content_attempts");
            a.f1562k = cm.m1260e(cursor, "expiration_timestamp_seconds");
            a.f1564m = cm.m1258c(cursor, "prepare_retry_count");
            a.f1565n = System.currentTimeMillis();
            return a;
        }

        protected String mo4385c() {
            return "ad";
        }

        protected String[] a_(int i) {
            return new String[i];
        }

        protected A mo4446a(A a, R r) {
            a.f1560i = r.f1049h;
            a.f1559h = r.m1009a();
            return a;
        }

        public int mo4447b(A a, R r) {
            a.f1562k = r.f1044c;
            return a.b_();
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1721b {
        @Inject
        C1760a f1537a;
        @Inject
        C1788a f1538b;
        @Inject
        C1801a f1539c;
        @Inject
        C1780a f1540d;

        /* compiled from: vungle */
        public class C17202 extends aa<cu> {
            final /* synthetic */ String f1535a;
            final /* synthetic */ C1721b f1536b;

            public C17202(C1721b c1721b, String str) {
                this.f1536b = c1721b;
                this.f1535a = str;
            }

            protected final /* synthetic */ Object mo4375d() {
                return (cu) this.f1536b.f1540d.m1275a(this.f1535a);
            }

            protected final /* synthetic */ Object mo4374c() {
                return (cu) this.f1536b.f1539c.m1275a(this.f1535a);
            }

            protected final /* synthetic */ Object mo4373b() {
                return (cu) this.f1536b.f1538b.m1275a(this.f1535a);
            }

            protected final /* bridge */ /* synthetic */ Object mo4372a() {
                return (cu) this.f1536b.f1537a.m1275a(this.f1535a);
            }
        }

        @Inject
        C1721b() {
        }

        public final <A extends cu, R extends acr, F extends eh<A, R>> F m1310a(final C1893v c1893v) {
            return (eh) new aa<F>(this) {
                final /* synthetic */ C1721b f1534b;

                protected final /* bridge */ /* synthetic */ Object mo4375d() {
                    return this.f1534b.f1540d;
                }

                protected final /* bridge */ /* synthetic */ Object mo4374c() {
                    return this.f1534b.f1539c;
                }

                protected final /* synthetic */ Object mo4373b() {
                    throw new IllegalArgumentException("cannot get cacheable factory for ad type: " + c1893v);
                }

                protected final /* bridge */ /* synthetic */ Object mo4372a() {
                    return this.f1534b.f1537a;
                }
            }.m811a(c1893v);
        }
    }

    /* compiled from: vungle */
    public enum C1722c {
        aware,
        failed,
        invalid,
        preparing,
        ready,
        viewed,
        deleting
    }

    protected abstract C1718a<?, ?> mo4456a();

    protected abstract boolean mo4458b();

    protected final String mo4391c() {
        return "ad";
    }

    protected final boolean d_() {
        return false;
    }

    public final String m1332e() {
        return this.f1560i;
    }

    public final C1893v m1333f() {
        return this.f1554c;
    }

    public final C1722c m1334g() {
        return this.f1555d;
    }

    public final void m1327a(String str) {
        this.f1563l = str;
        this.f1566o = null;
    }

    public final String m1335h() {
        if (this.f1566o == null) {
            this.f1566o = qt.m2369a(this.f1563l, qt.m2375c((String) this.u));
        }
        return this.f1566o;
    }

    public final int m1336i() {
        return this.f1564m;
    }

    public final void m1337j() {
        this.f1564m = 0;
    }

    public final long m1338k() {
        return this.f1558g;
    }

    public void mo4457a(C1722c c1722c) {
        so.m2470a(2, "VunglePrepare", "setting status from " + this.f1555d + " to " + c1722c + " for " + mo4389z(), null);
        this.f1555d = c1722c;
        if (c1722c == C1722c.failed) {
            this.f1558g = System.currentTimeMillis();
        }
    }

    public final void m1329b(C1722c c1722c) {
        mo4456a().m1288a(Arrays.asList(new cu[]{this}), c1722c);
    }

    protected ContentValues mo4390a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f1557f = currentTimeMillis;
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("id", (String) mo4410w());
            this.f1556e = currentTimeMillis;
            contentValues.put("insert_timestamp_millis", Long.valueOf(currentTimeMillis));
            contentValues.put("type", this.f1554c.toString());
        }
        contentValues.put("advertising_app_vungle_id", this.f1560i);
        contentValues.put("delivery_id", this.f1559h);
        contentValues.put(Games.EXTRA_STATUS, this.f1555d.toString());
        contentValues.put("update_timestamp_millis", Long.valueOf(currentTimeMillis));
        contentValues.put("failed_timestamp_millis", Long.valueOf(this.f1558g));
        contentValues.put("delete_local_content_attempts", Integer.valueOf(this.f1561j));
        contentValues.put("expiration_timestamp_seconds", this.f1562k);
        contentValues.put("parent_path", this.f1563l);
        contentValues.put("prepare_retry_count", Integer.valueOf(this.f1564m));
        contentValues.put("received_timestamp_millis", Long.valueOf(this.f1565n));
        return contentValues;
    }

    protected final StringBuilder e_() {
        StringBuilder e_ = super.e_();
        dw.m1312a(e_, "type", this.f1554c, false);
        return e_;
    }

    protected StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "advertising_app_vungle_id", this.f1560i, false);
        dw.m1312a(m, "delivery_id", this.f1559h, false);
        dw.m1312a(m, "insert_timestamp_millis", Long.valueOf(this.f1556e), false);
        dw.m1312a(m, Games.EXTRA_STATUS, this.f1555d, false);
        dw.m1312a(m, "update_timestamp_millis", Long.valueOf(this.f1557f), false);
        dw.m1312a(m, "failed_timestamp_millis", Long.valueOf(this.f1558g), false);
        dw.m1312a(m, "delete_local_content_attempts", Integer.valueOf(this.f1561j), false);
        dw.m1312a(m, "expiration_timestamp_seconds", this.f1562k, false);
        dw.m1312a(m, "parent_path", this.f1563l, false);
        dw.m1312a(m, "prepare_retry_count", Integer.valueOf(this.f1564m), false);
        dw.m1312a(m, "received_timestamp_millis", Long.valueOf(this.f1565n), false);
        return m;
    }

    public final int mo4395n() {
        int i = this.f1561j;
        this.f1561j = i + 1;
        if (mo4458b()) {
            return super.mo4395n();
        }
        so.m2470a(5, "VungleDatabase", "unable to delete files for " + mo4389z() + " attempt " + i, null);
        b_();
        return 0;
    }

    public boolean equals(Object ad) {
        return (ad instanceof cu) && m1328a((cu) ad);
    }

    public final boolean m1328a(cu cuVar) {
        return (cuVar == null || cuVar.u == null || !((String) cuVar.u).equals(this.u)) ? false : true;
    }

    public int hashCode() {
        return this.u == null ? super.hashCode() : ((String) this.u).hashCode();
    }

    public final boolean m1341o() {
        return mo4456a().m1295a(this);
    }
}
