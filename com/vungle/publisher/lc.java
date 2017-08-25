package com.vungle.publisher;

import com.vungle.publisher.kz.C1807a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lc implements MembersInjector<C1807a> {
    static final /* synthetic */ boolean f2439a = (!lc.class.desiredAssertionStatus());
    private final Provider<cq> f2440b;
    private final Provider<kz> f2441c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1807a c1807a = (C1807a) obj;
        if (c1807a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1807a.f1530d = (cq) this.f2440b.get();
        c1807a.f2419a = this.f2441c;
    }

    private lc(Provider<cq> provider, Provider<kz> provider2) {
        if (f2439a || provider != null) {
            this.f2440b = provider;
            if (f2439a || provider2 != null) {
                this.f2441c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1807a> m2117a(Provider<cq> provider, Provider<kz> provider2) {
        return new lc(provider, provider2);
    }
}
