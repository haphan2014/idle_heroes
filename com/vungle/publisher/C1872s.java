package com.vungle.publisher;

import com.vungle.publisher.C1821m.C1819b;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1872s implements MembersInjector<C1819b> {
    static final /* synthetic */ boolean f3164a = (!C1872s.class.desiredAssertionStatus());
    private final Provider<qh> f3165b;
    private final Provider<C1821m> f3166c;
    private final Provider<C1778a> f3167d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1819b c1819b = (C1819b) obj;
        if (c1819b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1819b.f1341v = (qh) this.f3165b.get();
        c1819b.f2522b = (C1821m) this.f3166c.get();
        c1819b.f2523c = (C1778a) this.f3167d.get();
    }

    private C1872s(Provider<qh> provider, Provider<C1821m> provider2, Provider<C1778a> provider3) {
        if (f3164a || provider != null) {
            this.f3165b = provider;
            if (f3164a || provider2 != null) {
                this.f3166c = provider2;
                if (f3164a || provider3 != null) {
                    this.f3167d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1819b> m2423a(Provider<qh> provider, Provider<C1821m> provider2, Provider<C1778a> provider3) {
        return new C1872s(provider, provider2, provider3);
    }
}
