package com.vungle.publisher;

import com.vungle.publisher.hj.C1782a;
import com.vungle.publisher.hp.C1784a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hm implements MembersInjector<C1782a> {
    static final /* synthetic */ boolean f2077a = (!hm.class.desiredAssertionStatus());
    private final Provider<cq> f2078b;
    private final Provider<hj> f2079c;
    private final Provider<C1784a> f2080d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1782a c1782a = (C1782a) obj;
        if (c1782a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1782a.f1530d = (cq) this.f2078b.get();
        c1782a.f2070a = this.f2079c;
        c1782a.f2071b = (C1784a) this.f2080d.get();
    }

    private hm(Provider<cq> provider, Provider<hj> provider2, Provider<C1784a> provider3) {
        if (f2077a || provider != null) {
            this.f2078b = provider;
            if (f2077a || provider2 != null) {
                this.f2079c = provider2;
                if (f2077a || provider3 != null) {
                    this.f2080d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1782a> m1906a(Provider<cq> provider, Provider<hj> provider2, Provider<C1784a> provider3) {
        return new hm(provider, provider2, provider3);
    }
}
