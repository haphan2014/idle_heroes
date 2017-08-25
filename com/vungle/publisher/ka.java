package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.google.android.gms.games.Games;
import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dr.C1737a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1752a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ey.C1758a;
import com.vungle.publisher.fa.C1764a;
import com.vungle.publisher.ke.C1802a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class ka<A extends cu> extends dw<Integer> implements ew<A> {
    protected String f1680o;
    protected C1893v f1681p;
    protected C1752a f1682q;
    protected C1753b f1683r;
    protected A f1684s;

    /* compiled from: vungle */
    public static abstract class C1736a<A extends cu, W extends ka<A>, R extends acr> extends C1717a<W, Integer> {
        @Inject
        C1892a f1676e;

        protected C1736a() {
        }

        protected /* synthetic */ Object[] mo4384b(int i) {
            return mo4483d(i);
        }

        protected W mo4439a(A a, R r) {
            if (r == null) {
                return null;
            }
            ka kaVar = (ka) c_();
            kaVar.f1684s = a;
            kaVar.f1680o = r.f1047f;
            kaVar.f1681p = r.f1046e;
            kaVar.f1682q = C1752a.aware;
            return kaVar;
        }

        protected final W m1486a(String str, C1753b c1753b, boolean z) throws SQLException {
            ka kaVar = (ka) c_();
            kaVar.f1680o = str;
            kaVar.f1683r = c1753b;
            return m1482a(kaVar, z);
        }

        private W m1482a(W w, boolean z) throws SQLException {
            Cursor query;
            Throwable th;
            Integer num = (Integer) w.u;
            C1753b c1753b = w.f1683r;
            try {
                String str;
                W w2;
                String str2 = w.f1680o;
                String str3;
                if (num != null) {
                    str3 = "id: " + num;
                    so.m2470a(3, "VungleDatabase", "fetching " + c1753b + " by " + str3, null);
                    query = this.d.getReadableDatabase().query("viewable", null, "id = ?", new String[]{String.valueOf(num)}, null, null, null);
                    str = str3;
                } else if (str2 == null) {
                    so.m2470a(5, "VungleDatabase", "unable to fetch " + c1753b + ": no id or ad_id", null);
                    str = null;
                    query = null;
                } else {
                    str3 = "ad_id " + str2;
                    so.m2470a(3, "VungleDatabase", "fetching " + c1753b + " by " + str3, null);
                    query = this.d.getReadableDatabase().query("viewable", null, "ad_id = ? AND type = ?", new String[]{str2, String.valueOf(c1753b)}, null, null, null);
                    str = str3;
                }
                if (query != null) {
                    try {
                        int count = query.getCount();
                        switch (count) {
                            case 0:
                                so.m2470a(2, "VungleDatabase", "no " + c1753b + " found for " + str, null);
                                w2 = null;
                                break;
                            case 1:
                                so.m2470a(3, "VungleDatabase", "have " + c1753b + " for " + str, null);
                                query.moveToFirst();
                                w2 = mo4402a((ka) w, query, z);
                                break;
                            default:
                                throw new SQLException(count + " " + c1753b + " records for " + str);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                w2 = null;
                if (query != null) {
                    query.close();
                }
                so.m2470a(2, "VungleDatabase", "fetched " + w2, null);
                return w2;
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }

        protected W mo4402a(W w, Cursor cursor, boolean z) {
            w.u = cm.m1259d(cursor, "id");
            w.f1680o = cm.m1261f(cursor, "ad_id");
            w.f1682q = (C1752a) cm.m1254a(cursor, Games.EXTRA_STATUS, C1752a.class);
            w.f1683r = (C1753b) cm.m1254a(cursor, "type", C1753b.class);
            w.f1681p = this.f1676e.m2540a(cm.m1261f(cursor, "ad_type"));
            return w;
        }

        protected final String mo4385c() {
            return "viewable";
        }

        protected Integer[] mo4483d(int i) {
            return new Integer[i];
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1800b {
        @Inject
        cq f2323a;
        @Inject
        C1737a f2324b;
        @Inject
        C1802a f2325c;
        @Inject
        C1764a f2326d;
        @Inject
        C1758a f2327e;

        @Inject
        C1800b() {
        }
    }

    protected abstract C1718a<A, ?> mo4421r();

    protected ka() {
    }

    protected final String mo4391c() {
        return "viewable";
    }

    public final Integer m1502D() {
        return (Integer) this.u;
    }

    public final String mo4407l() {
        return this.f1680o;
    }

    public final C1752a mo4408s() {
        return this.f1682q;
    }

    public final void mo4404a(C1752a c1752a) {
        so.m2470a(2, "VunglePrepare", "setting " + this.f1683r + " status from " + this.f1682q + " to " + c1752a + " for ad_id: " + this.f1680o, null);
        this.f1682q = c1752a;
    }

    public final void mo4405b(C1752a c1752a) {
        so.m2470a(2, "VunglePrepare", "updating " + this.f1683r + " status from " + this.f1682q + " to " + c1752a + " for ad_id: " + this.f1680o, null);
        this.f1682q = c1752a;
        b_();
    }

    public final C1753b mo4409t() {
        return this.f1683r;
    }

    protected ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("id", (Integer) this.u);
            contentValues.put("ad_id", this.f1680o);
            contentValues.put("type", this.f1683r.toString());
            contentValues.put("ad_type", this.f1681p.toString());
        }
        contentValues.put(Games.EXTRA_STATUS, this.f1682q.toString());
        return contentValues;
    }

    protected StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "ad_id", this.f1680o, false);
        dw.m1312a(m, Games.EXTRA_STATUS, this.f1682q, false);
        dw.m1312a(m, "type", this.f1683r, false);
        return m;
    }

    public final String mo4406d() {
        if (this.f1684s == null) {
            this.f1684s = (cu) mo4421r().m1275a((Object) this.f1680o);
        }
        return this.f1684s.m1335h();
    }

    protected final String mo4403A() {
        return String.valueOf(this.f1683r);
    }

    public final /* bridge */ /* synthetic */ Object mo4410w() {
        return (Integer) this.u;
    }
}
