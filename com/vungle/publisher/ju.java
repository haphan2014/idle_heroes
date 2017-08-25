package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import com.vungle.publisher.adq.C1675a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ka.C1736a;

/* compiled from: vungle */
public abstract class ju<A extends cu> extends ka<A> {
    public Float f1828e;
    public Integer f1829f;
    public Integer f1830g;
    public Boolean f1831h;
    public Boolean f1832i;
    public Integer f1833j;
    public Integer f1834k;
    public Integer f1835l;
    Integer f1836m;
    public Integer f1837n;

    /* compiled from: vungle */
    public static abstract class C1757a<A extends jv<A, V, R>, V extends ju<A>, R extends adq> extends C1736a<A, V, R> {
        protected abstract C1753b mo4440a();

        protected C1757a() {
        }

        protected V mo4442a(A a, R r) {
            ju juVar = (ju) super.mo4439a((cu) a, (acr) r);
            if (juVar != null) {
                C1757a.m1681a(juVar, (adq) r);
            }
            return juVar;
        }

        static V m1681a(V v, adq com_vungle_publisher_adq) {
            v.f1830g = com_vungle_publisher_adq.m1058i();
            v.f1834k = com_vungle_publisher_adq.m1055f();
            v.f1835l = com_vungle_publisher_adq.m1056g();
            v.f1836m = com_vungle_publisher_adq.m1057h();
            v.f1837n = com_vungle_publisher_adq.m1060k();
            C1675a d = com_vungle_publisher_adq.m1053d();
            if (d != null) {
                v.f1828e = d.m1093c();
                v.f1829f = d.m1097h();
                v.f1831h = d.m1094e();
                v.f1832i = d.m1095f();
                v.f1833j = d.m1096g();
            }
            return v;
        }

        protected final V m1686a(String str, boolean z) throws SQLException {
            return (ju) m1486a(str, mo4440a(), z);
        }

        protected V mo4441a(V v, Cursor cursor, boolean z) {
            super.mo4402a((ka) v, cursor, z);
            v.f1828e = cm.m1257b(cursor, "cta_clickable_percent");
            v.f1829f = cm.m1259d(cursor, "enable_cta_delay_seconds");
            v.f1830g = cm.m1259d(cursor, "height");
            v.f1831h = cm.m1252a(cursor, "is_cta_enabled");
            v.f1832i = cm.m1252a(cursor, "is_cta_shown_on_touch");
            v.f1833j = cm.m1259d(cursor, "show_cta_delay_seconds");
            v.f1834k = cm.m1259d(cursor, "show_close_delay_incentivized_seconds");
            v.f1835l = cm.m1259d(cursor, "show_close_delay_interstitial_seconds");
            v.f1836m = cm.m1259d(cursor, "show_countdown_delay_seconds");
            v.f1837n = cm.m1259d(cursor, "width");
            return v;
        }
    }

    public abstract Uri mo4443q();

    protected ju() {
    }

    protected ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        a.put("cta_clickable_percent", this.f1828e);
        a.put("enable_cta_delay_seconds", this.f1829f);
        a.put("height", this.f1830g);
        a.put("is_cta_enabled", this.f1831h);
        a.put("is_cta_shown_on_touch", this.f1832i);
        a.put("show_cta_delay_seconds", this.f1833j);
        a.put("show_close_delay_incentivized_seconds", this.f1834k);
        a.put("show_close_delay_interstitial_seconds", this.f1835l);
        a.put("show_countdown_delay_seconds", this.f1836m);
        a.put("width", this.f1837n);
        return a;
    }

    protected StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "cta_clickable_percent", this.f1828e, false);
        dw.m1312a(m, "enable_cta_delay_seconds", this.f1829f, false);
        dw.m1312a(m, "height", this.f1830g, false);
        dw.m1312a(m, "is_cta_enabled", this.f1831h, false);
        dw.m1312a(m, "is_cta_shown_on_touch", this.f1832i, false);
        dw.m1312a(m, "show_cta_delay_seconds", this.f1833j, false);
        dw.m1312a(m, "show_close_delay_incentivized_seconds", this.f1834k, false);
        dw.m1312a(m, "show_close_delay_interstitial_seconds", this.f1835l, false);
        dw.m1312a(m, "show_countdown_delay_seconds", this.f1836m, false);
        dw.m1312a(m, "width", this.f1837n, false);
        return m;
    }
}
