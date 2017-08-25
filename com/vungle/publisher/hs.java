package com.vungle.publisher;

import com.vungle.publisher.hp.C1784a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hs implements MembersInjector<C1784a> {
    static final /* synthetic */ boolean f2094a = (!hs.class.desiredAssertionStatus());
    private final Provider<cq> f2095b;
    private final Provider<hp> f2096c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1784a c1784a = (C1784a) obj;
        if (c1784a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1784a.f1530d = (cq) this.f2095b.get();
        c1784a.f2088a = this.f2096c;
    }

    private hs(Provider<cq> provider, Provider<hp> provider2) {
        if (f2094a || provider != null) {
            this.f2095b = provider;
            if (f2094a || provider2 != null) {
                this.f2096c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1784a> m1922a(Provider<cq> provider, Provider<hp> provider2) {
        return new hs(provider, provider2);
    }
}
