package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.google.android.gms.games.Games;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.cv.C1723a;
import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.fu.C1771a;
import com.vungle.publisher.ho.C1783a;
import com.vungle.publisher.iq.C1792a;
import com.vungle.publisher.ky.C1806a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class db<T extends db<T, P, E, A>, P extends da<T, P, E>, E extends dc<P>, A extends cu> extends dw<Integer> {
    protected A f1605a;
    protected String f1606b;
    protected String f1607c;
    protected Long f1608d;
    protected boolean f1609e;
    protected String f1610f;
    protected C1731c f1611g;
    protected Long f1612h;
    protected Integer f1613i;
    protected Long f1614j;
    protected Long f1615k;
    eu f1616l;
    protected List<P> f1617m;
    protected List<cv> f1618n;
    Long f1619o;
    protected String f1620p;
    boolean f1621q;
    @Inject
    C1733a f1622r;
    @Inject
    agg f1623s;

    /* compiled from: vungle */
    public static abstract class C1727a<T extends db<T, P, E, A>, P extends da<T, P, E>, E extends dc<P>, A extends cu, R extends acr> extends C1717a<T, Integer> {
        @Inject
        C1733a f1588a;
        @Inject
        C1723a f1589b;

        protected abstract C1718a<A, R> mo4470a();

        protected abstract C1726a<T, P, E> mo4473e();

        public abstract C1893v mo4474f();

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        protected C1727a() {
        }

        public T mo4487a(A a) {
            db dbVar = (db) c_();
            dbVar.f1605a = a;
            dbVar.f1611g = C1731c.open;
            if (a != null) {
                dbVar.f1620p = a.f1560i;
            }
            mo4472a(dbVar, (cu) a, false);
            so.m2470a(3, "VungleDatabase", "creating new " + dbVar.mo4389z(), null);
            return dbVar;
        }

        protected final List<T> m1387g() {
            List<T> a = m1277a("status = ? AND ad_id IN (SELECT id FROM ad WHERE type = ?)", new String[]{C1731c.reportable.toString(), mo4474f().toString()}, "insert_timestamp_millis ASC");
            for (T a2 : a) {
                mo4472a((db) a2, null, true);
            }
            return a;
        }

        public final T m1379b(A a) {
            T d = m1371d(a);
            if (d != null) {
                return d;
            }
            d = mo4487a((cu) a);
            d.m1429u();
            return d;
        }

        public final T m1381c(A a) {
            return m1371d(a);
        }

        private T m1371d(A a) {
            String[] strArr = new String[]{C1731c.open.toString()};
            String str = "status = ?";
            if (a == null) {
                throw new IllegalArgumentException("null ad");
            }
            String str2 = (String) a.mo4410w();
            if (str2 == null) {
                throw new IllegalArgumentException("null ad_id");
            }
            Object[] objArr = new String[2];
            objArr[0] = str2;
            for (int i = 0; i <= 0; i++) {
                objArr[1] = strArr[0];
            }
            List a2 = m1277a("ad_id = ? AND " + str, objArr, "insert_timestamp_millis DESC");
            String str3 = "ad_id = ? AND " + str + ", with params: " + agf.m1217a(objArr);
            int size = a2.size();
            switch (size) {
                case 0:
                    return null;
                case 1:
                    T a3 = mo4472a((db) a2.get(0), (cu) a, false);
                    so.m2470a(3, "VungleDatabase", "fetched " + a3.mo4389z(), null);
                    return a3;
                default:
                    so.m2470a(5, "VungleDatabase", size + " ad_report records for " + str3, null);
                    return null;
            }
        }

        protected T mo4471a(T t, Cursor cursor, boolean z) {
            t.u = cm.m1259d(cursor, "id");
            t.m1406a(cm.m1261f(cursor, "ad_id"));
            t.f1607c = cm.m1261f(cursor, "incentivized_publisher_app_user_id");
            t.f1609e = cm.m1252a(cursor, "is_incentivized").booleanValue();
            t.f1608d = cm.m1260e(cursor, "insert_timestamp_millis");
            t.f1610f = cm.m1261f(cursor, "placement");
            t.f1611g = (C1731c) cm.m1254a(cursor, Games.EXTRA_STATUS, C1731c.class);
            t.f1612h = cm.m1260e(cursor, "update_timestamp_millis");
            t.f1613i = cm.m1259d(cursor, "video_duration_millis");
            t.f1614j = cm.m1260e(cursor, "view_end_millis");
            t.f1615k = cm.m1260e(cursor, "view_start_millis");
            t.f1620p = cm.m1261f(cursor, "app_id");
            return t;
        }

        protected T mo4472a(T t, A a, boolean z) {
            if (a == null) {
                t.f1605a = (cu) mo4470a().m1275a((Object) t.m1417g());
            } else {
                t.f1605a = a;
            }
            if (z) {
                t.f1617m = mo4473e().m1360b((db) t);
                t.f1616l = this.f1588a.m1447b((Integer) t.u);
                t.f1618n = this.f1589b.m1345a((Integer) t.u);
            }
            return t;
        }

        protected final String mo4385c() {
            return "ad_report";
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1730b {
        @Inject
        public cq f1594a;
        @Inject
        C1771a f1595b;
        @Inject
        C1792a f1596c;
        @Inject
        C1806a f1597d;
        @Inject
        C1783a f1598e;
        Map<C1893v, C1727a<?, ?, ?, ?, ?>> f1599f;

        @Inject
        C1730b() {
        }

        public final <A extends cu> en m1397a(dy<A> dyVar) {
            Object a = m1396a(dyVar.h_());
            try {
                return (en) a;
            } catch (Exception e) {
                throw new IllegalArgumentException("ad report type is not cacheable " + a);
            }
        }

        public final <A extends cu> en m1399b(dy<A> dyVar) {
            final cu h_ = dyVar.h_();
            try {
                return (en) ((db) new aa<db<?, ?, ?, A>>(this) {
                    final /* synthetic */ C1730b f1591b;

                    protected final /* synthetic */ Object mo4375d() {
                        return this.f1591b.f1598e.m1381c(h_);
                    }

                    protected final /* bridge */ /* synthetic */ Object mo4374c() {
                        return this.f1591b.f1597d.m1381c(h_);
                    }

                    protected final /* synthetic */ Object mo4373b() {
                        return this.f1591b.f1596c.m1381c(h_);
                    }

                    protected final /* synthetic */ Object mo4372a() {
                        return this.f1591b.f1595b.m1381c(h_);
                    }
                }.m810a(h_));
            } catch (Exception e) {
                throw new IllegalArgumentException("ad type is not cacheable " + h_);
            }
        }

        public final List<db<?, ?, ?, ?>> m1398a() {
            List<db<?, ?, ?, ?>> arrayList = new ArrayList();
            Map map;
            if (this.f1599f != null) {
                map = this.f1599f;
            } else {
                this.f1599f = new HashMap();
                this.f1599f.put(C1893v.vungle_local, this.f1595b);
                this.f1599f.put(C1893v.vungle_streaming, this.f1596c);
                this.f1599f.put(C1893v.vungle_mraid, this.f1597d);
                this.f1599f.put(C1893v.third_party_mraid, this.f1598e);
                map = this.f1599f;
            }
            for (C1727a g : r0.values()) {
                for (db add : g.m1387g()) {
                    arrayList.add(add);
                }
            }
            return arrayList;
        }

        public final <A extends cu> db<?, ?, ?, A> m1396a(final A a) {
            return (db) new aa<db<?, ?, ?, A>>(this) {
                final /* synthetic */ C1730b f1593b;

                protected final /* synthetic */ Object mo4375d() {
                    return this.f1593b.f1598e.m1379b(a);
                }

                protected final /* synthetic */ Object mo4374c() {
                    return this.f1593b.f1597d.m1379b(a);
                }

                protected final /* bridge */ /* synthetic */ Object mo4373b() {
                    return this.f1593b.f1596c.m1379b(a);
                }

                protected final /* synthetic */ Object mo4372a() {
                    return this.f1593b.f1595b.m1379b(a);
                }
            }.m810a((cu) a);
        }
    }

    /* compiled from: vungle */
    public enum C1731c {
        open,
        failed,
        playing,
        reportable
    }

    public abstract C1727a<T, P, E, A, ?> mo4476b();

    protected abstract C1726a<T, P, E> mo4477e();

    public final /* synthetic */ Object mo4400v() {
        return m1429u();
    }

    protected db() {
    }

    protected final String mo4391c() {
        return "ad_report";
    }

    public final List<cv> m1416f() {
        return this.f1618n;
    }

    protected final String m1417g() {
        return this.f1605a == null ? this.f1606b : (String) this.f1605a.mo4410w();
    }

    protected final void m1406a(String str) {
        this.f1606b = str;
    }

    public final A m1418h() {
        return this.f1605a;
    }

    public final void m1407a(Map<String, String> map) {
        eu euVar;
        C1733a c1733a = this.f1622r;
        Integer num = (Integer) this.u;
        if (map != null) {
            eu euVar2 = new eu();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                dd a = c1733a.m1443a();
                a.f1631a = num;
                a.f1632b = str;
                a.f1633c = str2;
                euVar2.put(str, a);
            }
            euVar = euVar2;
        } else {
            euVar = null;
        }
        this.f1616l = euVar;
        int size = euVar == null ? 0 : euVar.size();
        if (size <= 0) {
            so.m2470a(3, "VungleDatabase", "no new extras for " + mo4389z(), null);
            return;
        }
        so.m2470a(3, "VungleDatabase", size + " new extras for " + mo4389z(), null);
        this.f1621q = true;
        m1401C();
    }

    public final eu m1419i() {
        eu euVar = this.f1616l;
        if (euVar != null) {
            return euVar;
        }
        euVar = this.f1622r.m1447b((Integer) this.u);
        this.f1616l = euVar;
        return euVar;
    }

    public final boolean m1420j() {
        return this.f1609e;
    }

    public final void m1411b(boolean z) {
        this.f1609e = z;
    }

    public final String m1421k() {
        return this.f1607c;
    }

    public final void m1410b(String str) {
        this.f1607c = str;
    }

    public final void m1414c(String str) {
        this.f1610f = str;
    }

    public final String m1423o() {
        return this.f1610f;
    }

    public final void m1403a(C1731c c1731c) {
        so.m2470a(3, "VungleReport", "setting ad_report status " + c1731c + " for " + mo4389z(), null);
        this.f1611g = c1731c;
    }

    public final Integer m1424p() {
        return this.f1613i;
    }

    public final int m1425q() {
        if (this.f1615k == null) {
            so.m2470a(5, "VungleDatabase", "unable to calculate ad duration because view start millis was null", null);
            return -1;
        } else if (this.f1614j != null) {
            return (int) (this.f1614j.longValue() - this.f1615k.longValue());
        } else {
            so.m2470a(5, "VungleDatabase", "unable to calculate ad duration because view end millis was null", null);
            return -1;
        }
    }

    public final void m1405a(Long l) {
        so.m2470a(3, "VungleReport", "setting ad end millis " + l + " for " + mo4389z(), null);
        this.f1614j = l;
    }

    public final void m1409b(Long l) {
        m1405a(l);
        b_();
    }

    public final Long m1426r() {
        return this.f1615k;
    }

    public final void m1413c(Long l) {
        so.m2470a(3, "VungleReport", "setting ad start millis " + l + " for " + mo4389z(), null);
        this.f1615k = l;
    }

    public final P m1427s() {
        List B = m1400B();
        P a = mo4477e().m1358a(this);
        a.mo4400v();
        B.add(a);
        return a;
    }

    public final P[] m1428t() {
        List B = m1400B();
        return (da[]) B.toArray(mo4477e().mo4396a(B.size()));
    }

    private List<P> m1400B() {
        List<P> list = this.f1617m;
        if (list != null) {
            return list;
        }
        list = mo4477e().m1360b(this);
        this.f1617m = list;
        return list;
    }

    public final Integer m1429u() throws SQLException {
        Integer num = (Integer) super.mo4400v();
        m1401C();
        return num;
    }

    private void m1401C() {
        if (this.f1621q) {
            eu euVar = this.f1616l;
            if (this.u == null) {
                so.m2470a(3, "VungleDatabase", "delaying inserting extras for uninserted " + mo4389z(), null);
                return;
            }
            so.m2470a(3, "VungleDatabase", "replacing extras for " + mo4389z(), null);
            this.f1622r.m1441a((Integer) this.u);
            if (!(euVar == null || euVar.isEmpty())) {
                C1717a.m1270a((dw[]) (dd[]) euVar.values().toArray(new dd[euVar.size()]));
            }
            this.f1621q = false;
            return;
        }
        so.m2470a(2, "VungleDatabase", "no new extras to insert for " + mo4389z(), null);
    }

    public StringBuilder mo4394m() {
        Object obj;
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "ad_id", m1417g(), false);
        dw.m1312a(m, "insert_timestamp_millis", this.f1608d, false);
        dw.m1312a(m, "incentivized_publisher_app_user_id", this.f1607c, false);
        dw.m1312a(m, "is_incentivized", Boolean.valueOf(this.f1609e), false);
        dw.m1312a(m, "placement", this.f1610f, false);
        dw.m1312a(m, Games.EXTRA_STATUS, this.f1611g, false);
        dw.m1312a(m, "update_timestamp_millis", this.f1612h, false);
        dw.m1312a(m, "video_duration_millis", this.f1613i, false);
        dw.m1312a(m, "view_end_millis", this.f1614j, false);
        dw.m1312a(m, "view_start_millis", this.f1615k, false);
        String str = "plays";
        if (this.f1617m == null) {
            obj = "not fetched";
        } else {
            obj = Integer.valueOf(this.f1617m.size());
        }
        dw.m1312a(m, str, obj, false);
        return m;
    }

    public final void m1404a(Integer num) {
        so.m2470a(3, "VungleReport", "setting video duration millis " + num + " for " + mo4389z(), null);
        this.f1613i = num;
        b_();
    }

    protected ContentValues mo4390a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("ad_id", m1417g());
            Long valueOf = Long.valueOf(currentTimeMillis);
            this.f1608d = valueOf;
            contentValues.put("insert_timestamp_millis", valueOf);
        }
        contentValues.put("incentivized_publisher_app_user_id", this.f1607c);
        contentValues.put("is_incentivized", Boolean.valueOf(this.f1609e));
        contentValues.put("placement", this.f1610f);
        contentValues.put(Games.EXTRA_STATUS, agf.m1213a(this.f1611g));
        Long valueOf2 = Long.valueOf(currentTimeMillis);
        this.f1612h = valueOf2;
        contentValues.put("update_timestamp_millis", valueOf2);
        contentValues.put("video_duration_millis", this.f1613i);
        contentValues.put("view_end_millis", this.f1614j);
        contentValues.put("view_start_millis", this.f1615k);
        contentValues.put("app_id", this.f1620p);
        return contentValues;
    }
}
