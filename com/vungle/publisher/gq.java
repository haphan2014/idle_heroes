package com.vungle.publisher;

import com.vungle.publisher.ey.C1758a;
import com.vungle.publisher.ez.C1760a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gq implements MembersInjector<ey> {
    static final /* synthetic */ boolean f2008a = (!gq.class.desiredAssertionStatus());
    private final Provider<cq> f2009b;
    private final Provider<C1760a> f2010c;
    private final Provider<C1758a> f2011d;

    public final /* synthetic */ void injectMembers(Object obj) {
        ey eyVar = (ey) obj;
        if (eyVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        eyVar.f1551v = (cq) this.f2009b.get();
        eyVar.f1840c = (C1760a) this.f2010c.get();
        eyVar.f1841d = (C1758a) this.f2011d.get();
    }

    private gq(Provider<cq> provider, Provider<C1760a> provider2, Provider<C1758a> provider3) {
        if (f2008a || provider != null) {
            this.f2009b = provider;
            if (f2008a || provider2 != null) {
                this.f2010c = provider2;
                if (f2008a || provider3 != null) {
                    this.f2011d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ey> m1840a(Provider<cq> provider, Provider<C1760a> provider2, Provider<C1758a> provider3) {
        return new gq(provider, provider2, provider3);
    }
}
