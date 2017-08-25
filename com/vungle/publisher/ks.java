package com.vungle.publisher;

import com.vungle.publisher.ko.C1804a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ks implements MembersInjector<ko> {
    static final /* synthetic */ boolean f2395a = (!ks.class.desiredAssertionStatus());
    private final Provider<cq> f2396b;
    private final Provider<C1804a> f2397c;

    public final /* synthetic */ void injectMembers(Object obj) {
        ko koVar = (ko) obj;
        if (koVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        koVar.f1551v = (cq) this.f2396b.get();
        koVar.f2387d = (C1804a) this.f2397c.get();
    }

    private ks(Provider<cq> provider, Provider<C1804a> provider2) {
        if (f2395a || provider != null) {
            this.f2396b = provider;
            if (f2395a || provider2 != null) {
                this.f2397c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ko> m2085a(Provider<cq> provider, Provider<C1804a> provider2) {
        return new ks(provider, provider2);
    }
}
