package com.vungle.publisher;

import com.vungle.publisher.ady.C1678a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aea implements MembersInjector<C1678a> {
    static final /* synthetic */ boolean f1199a = (!aea.class.desiredAssertionStatus());
    private final Provider<pj> f1200b;
    private final Provider<pq> f1201c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1678a c1678a = (C1678a) obj;
        if (c1678a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1678a.f1189a = (pj) this.f1200b.get();
        c1678a.f1190b = (pq) this.f1201c.get();
    }

    private aea(Provider<pj> provider, Provider<pq> provider2) {
        if (f1199a || provider != null) {
            this.f1200b = provider;
            if (f1199a || provider2 != null) {
                this.f1201c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1678a> m1115a(Provider<pj> provider, Provider<pq> provider2) {
        return new aea(provider, provider2);
    }
}
