package com.vungle.publisher;

import com.vungle.publisher.oc.C1844a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class of implements MembersInjector<C1844a> {
    static final /* synthetic */ boolean f2736a = (!of.class.desiredAssertionStatus());
    private final Provider<oc> f2737b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1844a c1844a = (C1844a) obj;
        if (c1844a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1844a.f2730a = this.f2737b;
    }

    private of(Provider<oc> provider) {
        if (f2736a || provider != null) {
            this.f2737b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1844a> m2259a(Provider<oc> provider) {
        return new of(provider);
    }
}
