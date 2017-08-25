package com.vungle.publisher;

import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.jw.C1766b;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ig extends jw {
    @Inject
    C1790a f2160d;

    @Singleton
    /* compiled from: vungle */
    static class C1790a extends C1766b<adn> {
        @Inject
        Provider<ig> f2159a;

        @Inject
        C1790a() {
        }

        protected final /* synthetic */ dw c_() {
            return (ig) this.f2159a.get();
        }
    }

    @Inject
    ig() {
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2160d;
    }
}
