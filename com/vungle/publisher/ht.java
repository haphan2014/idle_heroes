package com.vungle.publisher;

import com.vungle.publisher.hp.C1784a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ht implements MembersInjector<hp> {
    static final /* synthetic */ boolean f2097a = (!ht.class.desiredAssertionStatus());
    private final Provider<cq> f2098b;
    private final Provider<C1784a> f2099c;

    public final /* synthetic */ void injectMembers(Object obj) {
        hp hpVar = (hp) obj;
        if (hpVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        hpVar.f1551v = (cq) this.f2098b.get();
        hpVar.f2089e = (C1784a) this.f2099c.get();
    }

    private ht(Provider<cq> provider, Provider<C1784a> provider2) {
        if (f2097a || provider != null) {
            this.f2098b = provider;
            if (f2097a || provider2 != null) {
                this.f2099c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<hp> m1923a(Provider<cq> provider, Provider<C1784a> provider2) {
        return new ht(provider, provider2);
    }
}
