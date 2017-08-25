package com.vungle.publisher;

import com.vungle.publisher.mx.C1823a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nb implements MembersInjector<C1823a> {
    static final /* synthetic */ boolean f2614a = (!nb.class.desiredAssertionStatus());
    private final Provider<qh> f2615b;
    private final Provider<pj> f2616c;
    private final Provider<ch> f2617d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1823a c1823a = (C1823a) obj;
        if (c1823a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1823a.f2596a = (qh) this.f2615b.get();
        c1823a.f2597b = (pj) this.f2616c.get();
        c1823a.f2598c = (ch) this.f2617d.get();
    }

    private nb(Provider<qh> provider, Provider<pj> provider2, Provider<ch> provider3) {
        if (f2614a || provider != null) {
            this.f2615b = provider;
            if (f2614a || provider2 != null) {
                this.f2616c = provider2;
                if (f2614a || provider3 != null) {
                    this.f2617d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1823a> m2187a(Provider<qh> provider, Provider<pj> provider2, Provider<ch> provider3) {
        return new nb(provider, provider2, provider3);
    }
}
