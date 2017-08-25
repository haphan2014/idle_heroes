package com.vungle.publisher;

import com.vungle.publisher.ei.C1748c;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class kn implements MembersInjector<kj> {
    static final /* synthetic */ boolean f2382a = (!kn.class.desiredAssertionStatus());
    private final Provider<cq> f2383b;
    private final Provider<C1748c> f2384c;
    private final Provider<agg> f2385d;

    public final /* synthetic */ void injectMembers(Object obj) {
        kj kjVar = (kj) obj;
        if (kjVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        kjVar.f1745a = (cq) this.f2383b.get();
        kjVar.f1746b = (C1748c) this.f2384c.get();
        kjVar.f1747c = (agg) this.f2385d.get();
    }

    private kn(Provider<cq> provider, Provider<C1748c> provider2, Provider<agg> provider3) {
        if (f2382a || provider != null) {
            this.f2383b = provider;
            if (f2382a || provider2 != null) {
                this.f2384c = provider2;
                if (f2382a || provider3 != null) {
                    this.f2385d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<kj> m2072a(Provider<cq> provider, Provider<C1748c> provider2, Provider<agg> provider3) {
        return new kn(provider, provider2, provider3);
    }
}
