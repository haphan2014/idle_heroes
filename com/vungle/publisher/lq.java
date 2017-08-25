package com.vungle.publisher;

import com.vungle.publisher.kd.C1801a;
import com.vungle.publisher.lr.C1811a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lq implements MembersInjector<kd> {
    static final /* synthetic */ boolean f2491a = (!lq.class.desiredAssertionStatus());
    private final Provider<cq> f2492b;
    private final Provider<C1801a> f2493c;
    private final Provider<C1811a> f2494d;

    public final /* synthetic */ void injectMembers(Object obj) {
        kd kdVar = (kd) obj;
        if (kdVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        kdVar.f1551v = (cq) this.f2492b.get();
        kdVar.f2346A = (C1801a) this.f2493c.get();
        kdVar.f2347B = (C1811a) this.f2494d.get();
    }

    private lq(Provider<cq> provider, Provider<C1801a> provider2, Provider<C1811a> provider3) {
        if (f2491a || provider != null) {
            this.f2492b = provider;
            if (f2491a || provider2 != null) {
                this.f2493c = provider2;
                if (f2491a || provider3 != null) {
                    this.f2494d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<kd> m2133a(Provider<cq> provider, Provider<C1801a> provider2, Provider<C1811a> provider3) {
        return new lq(provider, provider2, provider3);
    }
}
