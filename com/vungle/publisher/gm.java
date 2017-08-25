package com.vungle.publisher;

import com.vungle.publisher.ez.C1760a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gm implements MembersInjector<ez> {
    static final /* synthetic */ boolean f1995a = (!gm.class.desiredAssertionStatus());
    private final Provider<cq> f1996b;
    private final Provider<qh> f1997c;
    private final Provider<C1760a> f1998d;

    public final /* synthetic */ void injectMembers(Object obj) {
        ez ezVar = (ez) obj;
        if (ezVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ezVar.f1551v = (cq) this.f1996b.get();
        ezVar.f1850B = (qh) this.f1997c.get();
        ezVar.f1858s = (C1760a) this.f1998d.get();
    }

    private gm(Provider<cq> provider, Provider<qh> provider2, Provider<C1760a> provider3) {
        if (f1995a || provider != null) {
            this.f1996b = provider;
            if (f1995a || provider2 != null) {
                this.f1997c = provider2;
                if (f1995a || provider3 != null) {
                    this.f1998d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ez> m1836a(Provider<cq> provider, Provider<qh> provider2, Provider<C1760a> provider3) {
        return new gm(provider, provider2, provider3);
    }
}
