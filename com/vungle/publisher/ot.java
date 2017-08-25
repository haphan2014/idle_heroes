package com.vungle.publisher;

import com.vungle.publisher.oq.C1853a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ot implements MembersInjector<C1853a> {
    static final /* synthetic */ boolean f2829a = (!ot.class.desiredAssertionStatus());
    private final Provider<oq> f2830b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1853a c1853a = (C1853a) obj;
        if (c1853a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1853a.f2785a = this.f2830b;
    }

    private ot(Provider<oq> provider) {
        if (f2829a || provider != null) {
            this.f2830b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1853a> m2305a(Provider<oq> provider) {
        return new ot(provider);
    }
}
