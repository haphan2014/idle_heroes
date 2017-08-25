package com.vungle.publisher;

import com.vungle.publisher.il.C1791a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ip implements MembersInjector<il> {
    static final /* synthetic */ boolean f2189a = (!ip.class.desiredAssertionStatus());
    private final Provider<cq> f2190b;
    private final Provider<C1791a> f2191c;

    public final /* synthetic */ void injectMembers(Object obj) {
        il ilVar = (il) obj;
        if (ilVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ilVar.f1551v = (cq) this.f2190b.get();
        ilVar.f2173e = (C1791a) this.f2191c.get();
    }

    private ip(Provider<cq> provider, Provider<C1791a> provider2) {
        if (f2189a || provider != null) {
            this.f2190b = provider;
            if (f2189a || provider2 != null) {
                this.f2191c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<il> m1978a(Provider<cq> provider, Provider<C1791a> provider2) {
        return new ip(provider, provider2);
    }
}
