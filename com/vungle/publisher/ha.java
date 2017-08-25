package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ha implements MembersInjector<C1778a> {
    static final /* synthetic */ boolean f2046a = (!ha.class.desiredAssertionStatus());
    private final Provider<cq> f2047b;
    private final Provider<pj> f2048c;
    private final Provider<pr> f2049d;
    private final Provider<gx> f2050e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1778a c1778a = (C1778a) obj;
        if (c1778a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1778a.f1530d = (cq) this.f2047b.get();
        c1778a.f2027a = (pj) this.f2048c.get();
        c1778a.f2028b = (pr) this.f2049d.get();
        c1778a.f2029c = this.f2050e;
    }

    private ha(Provider<cq> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<gx> provider4) {
        if (f2046a || provider != null) {
            this.f2047b = provider;
            if (f2046a || provider2 != null) {
                this.f2048c = provider2;
                if (f2046a || provider3 != null) {
                    this.f2049d = provider3;
                    if (f2046a || provider4 != null) {
                        this.f2050e = provider4;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1778a> m1877a(Provider<cq> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<gx> provider4) {
        return new ha(provider, provider2, provider3, provider4);
    }
}
