package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.C1821m.C1820c;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1889u implements MembersInjector<C1820c> {
    static final /* synthetic */ boolean f3329a = (!C1889u.class.desiredAssertionStatus());
    private final Provider<qh> f3330b;
    private final Provider<C1788a> f3331c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1820c c1820c = (C1820c) obj;
        if (c1820c == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1820c.f1341v = (qh) this.f3330b.get();
        c1820c.f2528e = (C1788a) this.f3331c.get();
    }

    private C1889u(Provider<qh> provider, Provider<C1788a> provider2) {
        if (f3329a || provider != null) {
            this.f3330b = provider;
            if (f3329a || provider2 != null) {
                this.f3331c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1820c> m2514a(Provider<qh> provider, Provider<C1788a> provider2) {
        return new C1889u(provider, provider2);
    }
}
