package com.vungle.publisher;

import com.vungle.publisher.ko.C1804a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class kr implements MembersInjector<C1804a> {
    static final /* synthetic */ boolean f2392a = (!kr.class.desiredAssertionStatus());
    private final Provider<cq> f2393b;
    private final Provider<ko> f2394c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1804a c1804a = (C1804a) obj;
        if (c1804a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1804a.f1530d = (cq) this.f2393b.get();
        c1804a.f2386a = this.f2394c;
    }

    private kr(Provider<cq> provider, Provider<ko> provider2) {
        if (f2392a || provider != null) {
            this.f2393b = provider;
            if (f2392a || provider2 != null) {
                this.f2394c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1804a> m2084a(Provider<cq> provider, Provider<ko> provider2) {
        return new kr(provider, provider2);
    }
}
