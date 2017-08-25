package com.vungle.publisher;

import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.facebook.AppEventsConstants;
import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.ff.C1765a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.id.C1786a;
import com.vungle.publisher.kj.C1803a;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class ei<A extends cu, R extends acr, F extends C1718a<A, R>> {
    @Inject
    cq f1745a;
    @Inject
    C1748c f1746b;
    @Inject
    agg f1747c;
    C1718a<A, R> f1748d;

    /* compiled from: vungle */
    public static abstract class C1742a<A extends cu, R extends acr, F extends C1718a<A, R>, C extends ei<A, R, F>> {
        abstract C mo4466a();

        public final C m1569a(F f) {
            C a = mo4466a();
            a.f1748d = f;
            return a;
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1747b {
        @Inject
        cq f1734a;
        @Inject
        C1892a f1735b;
        @Inject
        C1721b f1736c;
        @Inject
        C1778a f1737d;
        @Inject
        C1803a f1738e;
        @Inject
        C1765a f1739f;
        @Inject
        C1748c f1740g;

        /* compiled from: vungle */
        public abstract class C1743a {
            final /* synthetic */ C1747b f1730b;

            abstract int mo4422a(ei<?, ?, ?> eiVar);

            private C1743a(C1747b c1747b) {
                this.f1730b = c1747b;
            }

            public final int m1570a() {
                int i = 0;
                C1747b c1747b = this.f1730b;
                ei[] eiVarArr = new ei[]{c1747b.f1736c.m1310a(C1893v.vungle_mraid).i_(), c1747b.f1736c.m1310a(C1893v.vungle_local).i_()};
                int i2 = 0;
                while (i < 2) {
                    i2 += mo4422a(eiVarArr[i]);
                    i++;
                }
                return i2;
            }
        }

        /* compiled from: vungle */
        public class C17441 extends C1743a {
            final /* synthetic */ C1747b f1731a;

            public C17441(C1747b c1747b) {
                this.f1731a = c1747b;
                super();
            }

            final int mo4422a(ei<?, ?, ?> eiVar) {
                return eiVar.m1580a();
            }
        }

        /* compiled from: vungle */
        public class C17452 extends C1743a {
            final /* synthetic */ C1747b f1732a;

            public C17452(C1747b c1747b) {
                this.f1732a = c1747b;
                super();
            }

            final int mo4422a(ei<?, ?, ?> eiVar) {
                return eiVar.m1582b();
            }
        }

        /* compiled from: vungle */
        class C17463 extends C1743a {
            final /* synthetic */ C1747b f1733a;

            C17463(C1747b c1747b) {
                this.f1733a = c1747b;
                super();
            }

            final int mo4422a(ei<?, ?, ?> eiVar) {
                return eiVar.m1583c();
            }
        }

        @Inject
        C1747b() {
        }

        public final int m1575a() {
            return new C17463(this).m1570a();
        }

        public final dy<?> m1577b() {
            return m1576a(C1722c.ready);
        }

        public final Long m1578c() {
            Cursor a;
            Throwable th;
            Long l = null;
            try {
                String[] strArr = new String[]{C1722c.viewed.toString(), C1722c.deleting.toString()};
                C1786a c1786a = new C1786a();
                c1786a.f2134a = "ad";
                a = this.f1734a.m1265a(c1786a.m1935a("status NOT IN (" + cm.m1256a(2) + ")").m1935a(" ORDER BY expiration_timestamp_seconds ASC").m1935a(" LIMIT ?").m1936a(strArr).m1936a(new String[]{AppEventsConstants.EVENT_PARAM_VALUE_YES}).m1937a());
                try {
                    if (a.moveToFirst()) {
                        Long e = cm.m1260e(a, "expiration_timestamp_seconds");
                        if (e == null) {
                            so.m2470a(5, "VunglePrepare", "next ad expiration time seconds is null", null);
                        } else {
                            l = Long.valueOf(e.longValue() * 1000);
                            so.m2470a(3, "VunglePrepare", "next ad expiration time millis " + l, null);
                        }
                    }
                    if (a != null) {
                        a.close();
                    }
                    return l;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }

        public final <A extends cu, R extends acr> dy<?> m1576a(C1722c... c1722cArr) {
            Throwable e;
            Cursor cursor = null;
            String[] a = afz.m1206a(c1722cArr);
            Cursor a2;
            try {
                String[] a3 = afz.m1206a(new C1893v[]{C1893v.vungle_local, C1893v.vungle_mraid, C1893v.third_party_mraid});
                String[] strArr = new String[]{Long.toString(System.currentTimeMillis() / 1000), AppEventsConstants.EVENT_PARAM_VALUE_YES};
                C1786a c1786a = new C1786a();
                c1786a.f2134a = "ad";
                id a4 = c1786a.m1935a("status IN (" + cm.m1256a(a.length) + ")").m1935a(" AND type IN (" + cm.m1256a(a3.length) + ")").m1935a(" AND expiration_timestamp_seconds > ?").m1935a(" ORDER BY received_timestamp_millis ASC").m1935a(" LIMIT ?").m1936a(a).m1936a(a3).m1936a(strArr).m1937a();
                so.m2470a(2, "VunglePrepare", "built query: " + a4.m1938a(), null);
                a2 = this.f1734a.m1265a(a4);
                try {
                    dy<?> dyVar;
                    int count = a2.getCount();
                    switch (count) {
                        case 0:
                            so.m2470a(3, "VunglePrepare", "no record found for " + a4.m1938a(), null);
                            dyVar = null;
                            break;
                        case 1:
                            if (!a2.moveToFirst()) {
                                dyVar = null;
                                break;
                            }
                            C1718a j_ = this.f1736c.m1310a(this.f1735b.m2539a(a2, "type")).j_();
                            dyVar = (dy) j_.mo4445a((cu) j_.c_(), a2, true);
                            break;
                        default:
                            throw new SQLException("fetched " + count);
                    }
                    if (a2 == null) {
                        return dyVar;
                    }
                    a2.close();
                    return dyVar;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        this.f1737d.m1865a("VunglePrepare", "could not get next ad by status", e);
                        if (a2 != null) {
                            return null;
                        }
                        a2.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        cursor = a2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a2 = null;
                this.f1737d.m1865a("VunglePrepare", "could not get next ad by status", e);
                if (a2 != null) {
                    return null;
                }
                a2.close();
                return null;
            } catch (Throwable th2) {
                e = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw e;
            }
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1748c {
        @Inject
        cq f1741a;
        @Inject
        C1892a f1742b;
        @Inject
        C1778a f1743c;
        @Inject
        agg f1744d;

        @Inject
        C1748c() {
        }
    }

    public final int m1581a(List<A> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }
        if (Log.isLoggable("Vungle", 3)) {
            StringBuilder stringBuilder = new StringBuilder("deleting ");
            int i = 1;
            for (A a : list) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(a.mo4389z());
            }
            so.m2470a(3, "VunglePrepare", stringBuilder.toString(), null);
        }
        this.f1748d.m1288a(m1579b(list), C1722c.deleting);
        return this.f1748d.m1296b();
    }

    private static List<A> m1579b(List<A> list) {
        List<A> arrayList = new ArrayList();
        for (A a : list) {
            int i = a.f1561j;
            a.f1561j = i + 1;
            if (a.mo4458b() || i >= 3) {
                arrayList.add(a);
            } else {
                so.m2470a(5, "VunglePrepare", "unable to delete files for " + a.mo4389z() + " attempt " + i, null);
                a.b_();
            }
        }
        return arrayList;
    }

    protected final int m1580a() {
        so.m2470a(3, "VunglePrepare", "deleting expired " + this.f1748d.mo4451a() + " ad records without pending reports", null);
        return m1581a(this.f1748d.m1277a("type = ? AND expiration_timestamp_seconds <= ?", new String[]{r0.toString(), String.valueOf(System.currentTimeMillis() / 1000)}, null));
    }

    protected final int m1582b() {
        List a = this.f1748d.m1277a("type = ? AND " + cu.f1553b + " ORDER BY insert_timestamp_millis DESC LIMIT ? OFFSET ?", new String[]{this.f1748d.mo4451a().toString(), Integer.toString(Integer.MAX_VALUE), Integer.toString(4)}, null);
        so.m2470a(3, "VunglePrepare", "deleting " + a.size() + " extra " + this.f1748d.mo4451a() + " ad records to reach target size 4", null);
        return m1581a(a);
    }

    protected final int m1583c() {
        List a = this.f1748d.m1277a("type = ?", new String[]{this.f1748d.mo4451a().toString()}, null);
        so.m2470a(3, "VunglePrepare", "deleting " + a.size() + " " + this.f1748d.mo4451a() + " ad records", null);
        return m1581a(a);
    }
}
