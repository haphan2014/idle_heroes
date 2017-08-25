package com.vungle.publisher;

import com.vungle.publisher.ei.C1748c;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fj implements MembersInjector<ff> {
    static final /* synthetic */ boolean f1897a = (!fj.class.desiredAssertionStatus());
    private final Provider<cq> f1898b;
    private final Provider<C1748c> f1899c;
    private final Provider<agg> f1900d;

    public final /* synthetic */ void injectMembers(Object obj) {
        ff ffVar = (ff) obj;
        if (ffVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ffVar.f1745a = (cq) this.f1898b.get();
        ffVar.f1746b = (C1748c) this.f1899c.get();
        ffVar.f1747c = (agg) this.f1900d.get();
    }

    private fj(Provider<cq> provider, Provider<C1748c> provider2, Provider<agg> provider3) {
        if (f1897a || provider != null) {
            this.f1898b = provider;
            if (f1897a || provider2 != null) {
                this.f1899c = provider2;
                if (f1897a || provider3 != null) {
                    this.f1900d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ff> m1778a(Provider<cq> provider, Provider<C1748c> provider2, Provider<agg> provider3) {
        return new fj(provider, provider2, provider3);
    }
}
