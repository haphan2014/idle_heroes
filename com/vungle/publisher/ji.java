package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ji implements MembersInjector<C1789if> {
    static final /* synthetic */ boolean f2257a = (!ji.class.desiredAssertionStatus());
    private final Provider<cq> f2258b;
    private final Provider<qh> f2259c;
    private final Provider<C1788a> f2260d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1789if c1789if = (C1789if) obj;
        if (c1789if == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1789if.f1551v = (cq) this.f2258b.get();
        c1789if.f1850B = (qh) this.f2259c.get();
        c1789if.f2158p = (C1788a) this.f2260d.get();
    }

    private ji(Provider<cq> provider, Provider<qh> provider2, Provider<C1788a> provider3) {
        if (f2257a || provider != null) {
            this.f2258b = provider;
            if (f2257a || provider2 != null) {
                this.f2259c = provider2;
                if (f2257a || provider3 != null) {
                    this.f2260d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1789if> m2005a(Provider<cq> provider, Provider<qh> provider2, Provider<C1788a> provider3) {
        return new ji(provider, provider2, provider3);
    }
}
