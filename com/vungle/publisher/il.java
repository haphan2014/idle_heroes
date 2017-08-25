package com.vungle.publisher;

import com.vungle.publisher.dc.C1732a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ir.C1793a;
import com.vungle.publisher.jx.C1768a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class il extends jx<iq, il, ir> {
    @Inject
    C1791a f2173e;

    @Singleton
    /* compiled from: vungle */
    static class C1791a extends C1768a<iq, il, ir, C1789if, ie> {
        @Inject
        Provider<il> f2171a;
        @Inject
        C1793a f2172b;

        @Inject
        protected C1791a() {
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new il[i];
        }

        protected final /* synthetic */ dw c_() {
            return (il) this.f2171a.get();
        }
    }

    @Inject
    protected il() {
    }

    protected final /* bridge */ /* synthetic */ C1732a mo4469b() {
        return this.f2173e.f2172b;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2173e;
    }
}
