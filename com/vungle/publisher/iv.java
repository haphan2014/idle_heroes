package com.vungle.publisher;

import com.vungle.publisher.ir.C1793a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class iv implements MembersInjector<ir> {
    static final /* synthetic */ boolean f2206a = (!iv.class.desiredAssertionStatus());
    private final Provider<cq> f2207b;
    private final Provider<C1793a> f2208c;

    public final /* synthetic */ void injectMembers(Object obj) {
        ir irVar = (ir) obj;
        if (irVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        irVar.f1551v = (cq) this.f2207b.get();
        irVar.f2198e = (C1793a) this.f2208c.get();
    }

    private iv(Provider<cq> provider, Provider<C1793a> provider2) {
        if (f2206a || provider != null) {
            this.f2207b = provider;
            if (f2206a || provider2 != null) {
                this.f2208c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ir> m1989a(Provider<cq> provider, Provider<C1793a> provider2) {
        return new iv(provider, provider2);
    }
}
