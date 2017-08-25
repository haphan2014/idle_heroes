package com.vungle.publisher;

import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.jw.C1766b;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class fk extends jw {
    @Inject
    C1767a f1902d;

    @Singleton
    /* compiled from: vungle */
    static class C1767a extends C1766b<ade> {
        @Inject
        Provider<fk> f1901a;

        @Inject
        C1767a() {
        }

        protected final /* synthetic */ dw c_() {
            return (fk) this.f1901a.get();
        }
    }

    @Inject
    fk() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1902d;
    }
}
