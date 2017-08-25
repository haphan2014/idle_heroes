package com.vungle.publisher;

import com.vungle.publisher.fk.C1767a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fn implements MembersInjector<C1767a> {
    static final /* synthetic */ boolean f1907a = (!fn.class.desiredAssertionStatus());
    private final Provider<cq> f1908b;
    private final Provider<fk> f1909c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1767a c1767a = (C1767a) obj;
        if (c1767a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1767a.f1530d = (cq) this.f1908b.get();
        c1767a.f1901a = this.f1909c;
    }

    private fn(Provider<cq> provider, Provider<fk> provider2) {
        if (f1907a || provider != null) {
            this.f1908b = provider;
            if (f1907a || provider2 != null) {
                this.f1909c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1767a> m1786a(Provider<cq> provider, Provider<fk> provider2) {
        return new fn(provider, provider2);
    }
}
