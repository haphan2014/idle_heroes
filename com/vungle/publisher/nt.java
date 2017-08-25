package com.vungle.publisher;

import com.vungle.publisher.nl.C1837b;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nt implements MembersInjector<C1837b> {
    static final /* synthetic */ boolean f2699a = (!nt.class.desiredAssertionStatus());
    private final Provider<qh> f2700b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1837b c1837b = (C1837b) obj;
        if (c1837b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1837b.f1341v = (qh) this.f2700b.get();
    }

    private nt(Provider<qh> provider) {
        if (f2699a || provider != null) {
            this.f2700b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1837b> m2239a(Provider<qh> provider) {
        return new nt(provider);
    }
}
