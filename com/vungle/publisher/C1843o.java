package com.vungle.publisher;

import com.vungle.publisher.C1821m.C1818a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1843o implements MembersInjector<C1818a> {
    static final /* synthetic */ boolean f2724a = (!C1843o.class.desiredAssertionStatus());
    private final Provider<qh> f2725b;
    private final Provider<C1821m> f2726c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1818a c1818a = (C1818a) obj;
        if (c1818a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1818a.f1341v = (qh) this.f2725b.get();
        c1818a.f2520a = (C1821m) this.f2726c.get();
    }

    private C1843o(Provider<qh> provider, Provider<C1821m> provider2) {
        if (f2724a || provider != null) {
            this.f2725b = provider;
            if (f2724a || provider2 != null) {
                this.f2726c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1818a> m2250a(Provider<qh> provider, Provider<C1821m> provider2) {
        return new C1843o(provider, provider2);
    }
}
