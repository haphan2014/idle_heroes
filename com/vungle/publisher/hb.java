package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hb implements MembersInjector<gx> {
    static final /* synthetic */ boolean f2051a = (!hb.class.desiredAssertionStatus());
    private final Provider<cq> f2052b;
    private final Provider<C1778a> f2053c;

    public final /* synthetic */ void injectMembers(Object obj) {
        gx gxVar = (gx) obj;
        if (gxVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        gxVar.f1551v = (cq) this.f2052b.get();
        gxVar.f2039j = (C1778a) this.f2053c.get();
    }

    private hb(Provider<cq> provider, Provider<C1778a> provider2) {
        if (f2051a || provider != null) {
            this.f2052b = provider;
            if (f2051a || provider2 != null) {
                this.f2053c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<gx> m1878a(Provider<cq> provider, Provider<C1778a> provider2) {
        return new hb(provider, provider2);
    }
}
