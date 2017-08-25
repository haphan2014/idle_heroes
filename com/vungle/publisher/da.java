package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dc.C1732a;
import com.vungle.publisher.dw.C1717a;
import java.util.List;

/* compiled from: vungle */
public abstract class da<T extends db<T, P, E, ?>, P extends da<T, P, E>, E extends dc<P>> extends dw<Integer> {
    public T f1584a;
    public Integer f1585b;
    public Long f1586c;
    List<E> f1587d;

    /* compiled from: vungle */
    public static abstract class C1726a<T extends db<T, P, E, ?>, P extends da<T, P, E>, E extends dc<P>> extends C1717a<P, Integer> {
        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            da daVar = (da) dwVar;
            daVar.u = cm.m1259d(cursor, "id");
            daVar.f1585b = cm.m1259d(cursor, "watched_millis");
            daVar.f1586c = cm.m1260e(cursor, "start_millis");
            return daVar;
        }

        protected C1726a() {
        }

        protected final P m1358a(T t) {
            da daVar = (da) c_();
            daVar.f1584a = t;
            return daVar;
        }

        protected final List<P> m1360b(T t) {
            if (t == null) {
                throw new IllegalArgumentException("null ad_report");
            }
            if (((Integer) t.mo4410w()) == null) {
                throw new IllegalArgumentException("null report_id");
            }
            List<P> a = m1278a("report_id = ?", new String[]{((Integer) t.mo4410w()).toString()}, "start_millis ASC", null);
            for (P p : a) {
                p.f1584a = t;
            }
            return a;
        }

        protected final String mo4385c() {
            return "ad_play";
        }
    }

    protected abstract C1732a<P, E> mo4469b();

    protected da() {
    }

    public final void m1366a(jt jtVar, Object obj) {
        List f = m1363f();
        if (f.size() >= 1000) {
            so.m2470a(5, "VungleReport", "ignoring report event " + jtVar + " because the event buffer is full!", null);
            return;
        }
        String str;
        String str2 = "VungleReport";
        StringBuilder append = new StringBuilder("adding report event ").append(jtVar);
        if (obj == null) {
            str = "";
        } else {
            str = ", value " + obj + " for " + mo4389z();
        }
        so.m2470a(3, str2, append.append(str).toString(), null);
        dc a = mo4469b().m1431a(this, jtVar, obj);
        a.mo4400v();
        f.add(a);
    }

    public final E[] m1369e() {
        List f = m1363f();
        return (dc[]) f.toArray(mo4469b().mo4396a(f.size()));
    }

    private List<E> m1363f() {
        List<E> list = this.f1587d;
        if (list != null) {
            return list;
        }
        list = mo4469b().m1434a(this);
        this.f1587d = list;
        return list;
    }

    protected final String mo4391c() {
        return "ad_play";
    }

    private Integer m1364g() {
        return this.f1584a == null ? null : (Integer) this.f1584a.mo4410w();
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("report_id", m1364g());
        } else {
            contentValues.put("start_millis", this.f1586c);
            contentValues.put("watched_millis", this.f1585b);
        }
        return contentValues;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "report_id", m1364g(), false);
        dw.m1312a(m, "start_millis", this.f1586c, false);
        dw.m1312a(m, "watched_millis", this.f1585b, false);
        return m;
    }
}
