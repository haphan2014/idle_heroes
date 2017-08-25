package com.vungle.publisher;

import com.vungle.publisher.dc.C1732a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.fv.C1773a;
import com.vungle.publisher.jx.C1768a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class fp extends jx<fu, fp, fv> {
    @Inject
    C1769a f1915e;

    @Singleton
    /* compiled from: vungle */
    static class C1769a extends C1768a<fu, fp, fv, ez, ey> {
        @Inject
        Provider<fp> f1913a;
        @Inject
        C1773a f1914b;

        @Inject
        protected C1769a() {
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new fp[i];
        }

        protected final /* synthetic */ dw c_() {
            return (fp) this.f1913a.get();
        }
    }

    @Inject
    protected fp() {
    }

    protected final /* bridge */ /* synthetic */ C1732a mo4469b() {
        return this.f1915e.f1914b;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1915e;
    }
}
