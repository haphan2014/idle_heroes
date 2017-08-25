package com.vungle.publisher;

import com.vungle.publisher.hj.C1782a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hn implements MembersInjector<hj> {
    static final /* synthetic */ boolean f2081a = (!hn.class.desiredAssertionStatus());
    private final Provider<cq> f2082b;
    private final Provider<C1782a> f2083c;

    public final /* synthetic */ void injectMembers(Object obj) {
        hj hjVar = (hj) obj;
        if (hjVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        hjVar.f1551v = (cq) this.f2082b.get();
        hjVar.f2072e = (C1782a) this.f2083c.get();
    }

    private hn(Provider<cq> provider, Provider<C1782a> provider2) {
        if (f2081a || provider != null) {
            this.f2082b = provider;
            if (f2081a || provider2 != null) {
                this.f2083c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<hj> m1907a(Provider<cq> provider, Provider<C1782a> provider2) {
        return new hn(provider, provider2);
    }
}
