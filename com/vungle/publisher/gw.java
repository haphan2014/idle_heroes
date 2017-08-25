package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gw implements MembersInjector<gs> {
    static final /* synthetic */ boolean f2024a = (!gw.class.desiredAssertionStatus());
    private final Provider<pj> f2025b;
    private final Provider<pu> f2026c;

    public final /* synthetic */ void injectMembers(Object obj) {
        gs gsVar = (gs) obj;
        if (gsVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        gsVar.f2016d = (pj) this.f2025b.get();
        gsVar.f2017e = (pu) this.f2026c.get();
    }

    private gw(Provider<pj> provider, Provider<pu> provider2) {
        if (f2024a || provider != null) {
            this.f2025b = provider;
            if (f2024a || provider2 != null) {
                this.f2026c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<gs> m1858a(Provider<pj> provider, Provider<pu> provider2) {
        return new gw(provider, provider2);
    }
}
