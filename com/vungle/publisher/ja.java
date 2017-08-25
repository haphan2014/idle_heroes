package com.vungle.publisher;

import com.vungle.publisher.eo.C1749a;
import com.vungle.publisher.ig.C1790a;
import com.vungle.publisher.js.C1775a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ja extends js<ja, C1789if, adn, jw, C1790a, aec> {
    @Inject
    C1795a f2236a;

    @Singleton
    /* compiled from: vungle */
    public static class C1795a extends C1775a<ja, C1789if, adn, jw, C1790a, aec> {
        @Inject
        Provider<ja> f2234a;
        @Inject
        C1790a f2235b;

        @Inject
        C1795a() {
        }

        public final /* bridge */ /* synthetic */ C1749a mo4478a() {
            return this.f2235b;
        }

        protected final /* synthetic */ js mo4479b() {
            return (ja) this.f2234a.get();
        }
    }

    @Inject
    ja() {
    }

    protected final /* bridge */ /* synthetic */ C1775a mo4480a() {
        return this.f2236a;
    }
}
