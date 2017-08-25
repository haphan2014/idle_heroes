package com.vungle.publisher;

import com.vungle.publisher.pl.C1861a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pn implements MembersInjector<C1861a> {
    static final /* synthetic */ boolean f2907a = (!pn.class.desiredAssertionStatus());
    private final Provider<qh> f2908b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1861a c1861a = (C1861a) obj;
        if (c1861a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1861a.f2899a = (qh) this.f2908b.get();
    }

    private pn(Provider<qh> provider) {
        if (f2907a || provider != null) {
            this.f2908b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1861a> m2338a(Provider<qh> provider) {
        return new pn(provider);
    }
}
