package com.vungle.publisher;

import com.vungle.publisher.he.C1781a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hh implements MembersInjector<C1781a> {
    static final /* synthetic */ boolean f2064a = (!hh.class.desiredAssertionStatus());
    private final Provider<he> f2065b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1781a c1781a = (C1781a) obj;
        if (c1781a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1781a.f2059a = (he) this.f2065b.get();
    }

    private hh(Provider<he> provider) {
        if (f2064a || provider != null) {
            this.f2065b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1781a> m1896a(Provider<he> provider) {
        return new hh(provider);
    }
}
