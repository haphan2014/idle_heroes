package com.vungle.publisher;

import com.vungle.publisher.ep.C1750a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class et implements MembersInjector<ep> {
    static final /* synthetic */ boolean f1799a = (!et.class.desiredAssertionStatus());
    private final Provider<cq> f1800b;
    private final Provider<C1750a> f1801c;

    public final /* synthetic */ void injectMembers(Object obj) {
        ep epVar = (ep) obj;
        if (epVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        epVar.f1551v = (cq) this.f1800b.get();
        epVar.f1791h = (C1750a) this.f1801c.get();
    }

    private et(Provider<cq> provider, Provider<C1750a> provider2) {
        if (f1799a || provider != null) {
            this.f1800b = provider;
            if (f1799a || provider2 != null) {
                this.f1801c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ep> m1652a(Provider<cq> provider, Provider<C1750a> provider2) {
        return new et(provider, provider2);
    }
}
