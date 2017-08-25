package com.vungle.publisher;

import com.vungle.publisher.hd.C1780a;
import com.vungle.publisher.he.C1781a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ib implements MembersInjector<C1780a> {
    static final /* synthetic */ boolean f2124a = (!ib.class.desiredAssertionStatus());
    private final Provider<cq> f2125b;
    private final Provider<qh> f2126c;
    private final Provider<agg> f2127d;
    private final Provider<hd> f2128e;
    private final Provider<C1781a> f2129f;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1780a c1780a = (C1780a) obj;
        if (c1780a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1780a.f1530d = (cq) this.f2125b.get();
        c1780a.f1531a = (qh) this.f2126c.get();
        c1780a.f1532b = (agg) this.f2127d.get();
        c1780a.f2054c = this.f2128e;
        c1780a.f2055e = (C1781a) this.f2129f.get();
    }

    private ib(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<hd> provider4, Provider<C1781a> provider5) {
        if (f2124a || provider != null) {
            this.f2125b = provider;
            if (f2124a || provider2 != null) {
                this.f2126c = provider2;
                if (f2124a || provider3 != null) {
                    this.f2127d = provider3;
                    if (f2124a || provider4 != null) {
                        this.f2128e = provider4;
                        if (f2124a || provider5 != null) {
                            this.f2129f = provider5;
                            return;
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1780a> m1933a(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<hd> provider4, Provider<C1781a> provider5) {
        return new ib(provider, provider2, provider3, provider4, provider5);
    }
}
