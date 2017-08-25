package com.vungle.publisher;

import com.vungle.publisher.ep.C1750a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class es implements MembersInjector<C1750a> {
    static final /* synthetic */ boolean f1796a = (!es.class.desiredAssertionStatus());
    private final Provider<cq> f1797b;
    private final Provider<ep> f1798c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1750a c1750a = (C1750a) obj;
        if (c1750a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1750a.f1530d = (cq) this.f1797b.get();
        c1750a.f1783a = this.f1798c;
    }

    private es(Provider<cq> provider, Provider<ep> provider2) {
        if (f1796a || provider != null) {
            this.f1797b = provider;
            if (f1796a || provider2 != null) {
                this.f1798c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1750a> m1651a(Provider<cq> provider, Provider<ep> provider2) {
        return new es(provider, provider2);
    }
}
