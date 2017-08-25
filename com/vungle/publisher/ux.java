package com.vungle.publisher;

import com.vungle.publisher.uv.C1890a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ux implements MembersInjector<C1890a> {
    static final /* synthetic */ boolean f3398a = (!ux.class.desiredAssertionStatus());
    private final Provider<pj> f3399b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1890a c1890a = (C1890a) obj;
        if (c1890a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1890a.f779a = (pj) this.f3399b.get();
    }

    private ux(Provider<pj> provider) {
        if (f3398a || provider != null) {
            this.f3399b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1890a> m2535a(Provider<pj> provider) {
        return new ux(provider);
    }
}
