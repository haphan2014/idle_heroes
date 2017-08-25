package com.vungle.publisher;

import com.vungle.publisher.ei.C1748c;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hi implements MembersInjector<he> {
    static final /* synthetic */ boolean f2066a = (!hi.class.desiredAssertionStatus());
    private final Provider<cq> f2067b;
    private final Provider<C1748c> f2068c;
    private final Provider<agg> f2069d;

    public final /* synthetic */ void injectMembers(Object obj) {
        he heVar = (he) obj;
        if (heVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        heVar.f1745a = (cq) this.f2067b.get();
        heVar.f1746b = (C1748c) this.f2068c.get();
        heVar.f1747c = (agg) this.f2069d.get();
    }

    private hi(Provider<cq> provider, Provider<C1748c> provider2, Provider<agg> provider3) {
        if (f2066a || provider != null) {
            this.f2067b = provider;
            if (f2066a || provider2 != null) {
                this.f2068c = provider2;
                if (f2066a || provider3 != null) {
                    this.f2069d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<he> m1897a(Provider<cq> provider, Provider<C1748c> provider2, Provider<agg> provider3) {
        return new hi(provider, provider2, provider3);
    }
}
