package com.vungle.publisher;

import com.vungle.publisher.C1763f.C1762a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1785i implements MembersInjector<C1762a> {
    static final /* synthetic */ boolean f2119a = (!C1785i.class.desiredAssertionStatus());
    private final Provider<qh> f2120b;
    private final Provider<ql> f2121c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1762a c1762a = (C1762a) obj;
        if (c1762a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1762a.f1341v = (qh) this.f2120b.get();
        c1762a.f1860a = (ql) this.f2121c.get();
    }

    private C1785i(Provider<qh> provider, Provider<ql> provider2) {
        if (f2119a || provider != null) {
            this.f2120b = provider;
            if (f2119a || provider2 != null) {
                this.f2121c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1762a> m1931a(Provider<qh> provider, Provider<ql> provider2) {
        return new C1785i(provider, provider2);
    }
}
