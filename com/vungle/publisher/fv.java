package com.vungle.publisher;

import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.jz.C1772b;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class fv extends jz<fp> {
    @Inject
    C1773a f1935e;

    @Singleton
    /* compiled from: vungle */
    static class C1773a extends C1772b<fv, fp> {
        @Inject
        Provider<fv> f1934a;

        @Inject
        protected C1773a() {
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new fv[i];
        }

        protected final /* synthetic */ dw c_() {
            return (fv) this.f1934a.get();
        }
    }

    @Inject
    protected fv() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1935e;
    }
}
