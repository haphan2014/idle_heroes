package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.js.C1775a;
import com.vungle.publisher.ju.C1757a;
import java.util.List;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class jv<A extends jv<A, V, R>, V extends ju<A>, R extends adq> extends cu {
    protected boolean f1849A;
    @Inject
    qh f1850B;
    protected String f1851w;
    protected String f1852x;
    protected V f1853y;
    protected js<?, A, R, jw, ?, ?> f1854z;

    /* compiled from: vungle */
    public static abstract class C1759a<A extends jv<A, V, R>, V extends ju<A>, R extends adq> extends C1718a<A, R> {
        protected abstract C1775a<?, A, R, jw, ?, ?> mo4452e();

        protected abstract C1757a<A, V, R> mo4453f();

        protected C1759a() {
        }

        protected final /* synthetic */ cu mo4446a(cu cuVar, acr com_vungle_publisher_acr) {
            return m1716b((jv) cuVar, (adq) com_vungle_publisher_acr);
        }

        public final /* synthetic */ int mo4447b(cu cuVar, acr com_vungle_publisher_acr) {
            return m1717a((jv) cuVar, (adq) com_vungle_publisher_acr);
        }

        public A mo4449a(R r) {
            jv jvVar = (jv) super.mo4444a((acr) r);
            jvVar.f1854z = mo4452e().m1819a(jvVar, r);
            jvVar.f1853y = mo4453f().mo4442a(jvVar, (adq) r);
            return jvVar;
        }

        public final int m1717a(A a, R r) {
            m1716b((jv) a, (adq) r);
            C1757a.m1681a(a.m1751u(), (adq) r).b_();
            a.f1854z.m1825a((acr) r);
            return super.mo4447b(a, r);
        }

        private A m1716b(A a, R r) {
            super.mo4446a((cu) a, (acr) r);
            Object c = r.m1052c();
            String e = r.m1054e();
            if (TextUtils.isEmpty(c)) {
                a.f1851w = e;
            } else {
                a.f1851w = c;
                a.f1852x = e;
            }
            return a;
        }

        protected A mo4450a(A a, Cursor cursor, boolean z) {
            super.mo4445a(a, cursor, z);
            a.f1851w = cm.m1261f(cursor, "call_to_action_final_url");
            a.f1852x = cm.m1261f(cursor, "call_to_action_url");
            a.f1854z = mo4452e().m1818a(a);
            if (z) {
                m1722a((jv) a, z);
            }
            return a;
        }

        protected final V m1722a(A a, boolean z) {
            if (a.f1849A) {
                return a.f1853y;
            }
            V a2 = mo4453f().m1686a((String) a.u, z);
            a.f1853y = a2;
            a.f1849A = true;
            return a2;
        }
    }

    protected abstract C1759a<A, V, R> mo4464r();

    protected /* synthetic */ C1718a mo4456a() {
        return mo4464r();
    }

    public /* synthetic */ Object mo4400v() {
        return mo4463q();
    }

    public final String m1749s() {
        return this.f1851w;
    }

    public final String m1750t() {
        return this.f1852x;
    }

    public final List<String> m1745a(jt jtVar) {
        return this.f1854z.m1824a(jtVar);
    }

    public final V m1751u() {
        return mo4464r().m1722a(this, false);
    }

    public String mo4463q() throws SQLException {
        String str = (String) super.mo4400v();
        if (this.f1854z != null) {
            this.f1854z.m1827b();
        }
        if (this.f1853y != null) {
            this.f1853y.mo4400v();
        }
        return str;
    }

    public int b_() {
        int b_ = super.b_();
        if (b_ == 1 && this.f1853y != null) {
            this.f1853y.b_();
        }
        return b_;
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        a.put("call_to_action_final_url", this.f1851w);
        a.put("call_to_action_url", this.f1852x);
        return a;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "call_to_action_final_url", this.f1851w, false);
        dw.m1312a(m, "call_to_action_url", this.f1852x, false);
        this.f1854z.m1826a(m);
        return m;
    }
}
