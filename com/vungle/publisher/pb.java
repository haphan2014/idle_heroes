package com.vungle.publisher;

import com.vungle.publisher.ov.C1858a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pb implements MembersInjector<C1858a> {
    static final /* synthetic */ boolean f2870a = (!pb.class.desiredAssertionStatus());
    private final Provider<qh> f2871b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1858a c1858a = (C1858a) obj;
        if (c1858a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1858a.f1341v = (qh) this.f2871b.get();
    }

    private pb(Provider<qh> provider) {
        if (f2870a || provider != null) {
            this.f2871b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1858a> m2318a(Provider<qh> provider) {
        return new pb(provider);
    }
}
