package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.dw.C1717a;
import java.util.List;

/* compiled from: vungle */
public abstract class dc<P extends da<?, P, ?>> extends dw<Integer> {
    P f1624a;
    public jt f1625b;
    public long f1626c;
    public String f1627d;
    private String f1628e;

    /* compiled from: vungle */
    public static abstract class C1732a<P extends da<?, P, E>, E extends dc<P>> extends C1717a<E, Integer> {
        protected abstract jt mo4401a(Cursor cursor);

        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            dc dcVar = (dc) dwVar;
            dcVar.f1625b = mo4401a(cursor);
            dcVar.u = cm.m1259d(cursor, "id");
            dcVar.f1626c = cm.m1260e(cursor, "insert_timestamp_millis").longValue();
            dcVar.f1627d = cm.m1261f(cursor, "value");
            return dcVar;
        }

        protected C1732a() {
        }

        protected final E m1431a(P p, jt jtVar, Object obj) {
            if (p == null) {
                throw new IllegalArgumentException("null ad_play");
            } else if (jtVar == null) {
                throw new IllegalArgumentException("null event");
            } else {
                dc dcVar = (dc) c_();
                dcVar.f1624a = p;
                dcVar.f1625b = jtVar;
                dcVar.f1627d = obj == null ? null : obj.toString();
                return dcVar;
            }
        }

        protected final List<E> m1434a(P p) {
            if (p == null) {
                throw new IllegalArgumentException("null ad_play");
            }
            if (((Integer) p.mo4410w()) == null) {
                throw new IllegalArgumentException("null play_id");
            }
            List<E> a = m1277a("play_id = ?", new String[]{((Integer) p.mo4410w()).toString()}, "insert_timestamp_millis ASC");
            for (E e : a) {
                e.f1624a = p;
            }
            return a;
        }

        protected final String mo4385c() {
            return "ad_report_event";
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }
    }

    protected dc() {
    }

    private Integer m1437e() {
        return this.f1624a == null ? null : (Integer) this.f1624a.mo4410w();
    }

    protected final String mo4391c() {
        return "ad_report_event";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f1626c = currentTimeMillis;
            contentValues.put("insert_timestamp_millis", Long.valueOf(currentTimeMillis));
            contentValues.put("play_id", m1437e());
            contentValues.put(DataLayer.EVENT_KEY, this.f1625b.toString());
            contentValues.put("value", this.f1627d);
        }
        return contentValues;
    }

    public String toString() {
        String str = this.f1628e;
        if (str != null) {
            return str;
        }
        str = super.toString();
        this.f1628e = str;
        return str;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "play_id", m1437e(), false);
        dw.m1312a(m, DataLayer.EVENT_KEY, this.f1625b, false);
        dw.m1312a(m, "insert_timestamp_millis", Long.valueOf(this.f1626c), false);
        dw.m1312a(m, "value", this.f1627d, false);
        return m;
    }
}
