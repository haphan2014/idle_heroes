package com.vungle.publisher;

import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.jz.C1772b;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ir extends jz<il> {
    @Inject
    C1793a f2198e;

    @Singleton
    /* compiled from: vungle */
    static class C1793a extends C1772b<ir, il> {
        @Inject
        Provider<ir> f2197a;

        @Inject
        protected C1793a() {
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new ir[i];
        }

        protected final /* synthetic */ dw c_() {
            return (ir) this.f2197a.get();
        }
    }

    @Inject
    protected ir() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2198e;
    }
}
