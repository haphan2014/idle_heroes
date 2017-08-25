package com.vungle.publisher;

import com.vungle.publisher.eo.C1749a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: vungle */
public abstract class js<D extends js<D, A, R, E, F, T>, A extends cu, R extends acr, E extends eo, F extends C1749a<E, T, R>, T extends aeb> {
    protected Map<jt, List<E>> f1968b;
    protected cu f1969c;

    /* compiled from: vungle */
    static abstract class C1775a<D extends js<D, A, R, E, F, T>, A extends cu, R extends acr, E extends eo, F extends C1749a<E, T, R>, T extends aeb> {
        protected abstract F mo4478a();

        protected abstract D mo4479b();

        C1775a() {
        }

        public final D m1819a(A a, R r) {
            D b = mo4479b();
            b.f1969c = a;
            b.f1968b = mo4478a().mo4468a((String) a.u, r.f1045d);
            return b;
        }

        public final D m1818a(A a) {
            D b = mo4479b();
            b.f1969c = a;
            Map a2 = mo4478a().m1630a((String) a.u);
            if (a2 != null) {
                b.f1968b = a2;
                so.m2470a(3, "VungleReport", "got " + a2.size() + " event trackings by adId: " + ((String) a.u), null);
            } else {
                so.m2470a(3, "VungleReport", "no event trackings for adId: " + ((String) a.u), null);
            }
            return b;
        }
    }

    protected abstract C1775a<D, A, R, E, F, T> mo4480a();

    public final void m1827b() {
        if (this.f1968b != null) {
            for (List<eo> it : this.f1968b.values()) {
                for (eo v : it) {
                    v.mo4400v();
                }
            }
        }
    }

    public final List<String> m1824a(jt jtVar) {
        Map map = this.f1968b;
        if (map != null) {
            List<eo> list = (List) map.get(jtVar);
            if (list != null && list.size() > 0) {
                List<String> arrayList = new ArrayList();
                for (eo eoVar : list) {
                    arrayList.add(eoVar.f1780a);
                }
                return arrayList;
            }
        }
        return null;
    }

    public final void m1826a(StringBuilder stringBuilder) {
        Object obj;
        String str = "eventTrackings";
        if (this.f1968b == null) {
            obj = null;
        } else {
            obj = Integer.valueOf(this.f1968b.size());
        }
        dw.m1312a(stringBuilder, str, obj, false);
    }

    public final Map<jt, List<E>> m1825a(R r) {
        C1749a a = mo4480a().mo4478a();
        if (a != null) {
            this.f1968b = a.m1629a((acr) r);
        }
        return this.f1968b;
    }
}
