package com.vungle.publisher;

import com.vungle.publisher.dm.C1734a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dq implements MembersInjector<dm> {
    static final /* synthetic */ boolean f1673a = (!dq.class.desiredAssertionStatus());
    private final Provider<cq> f1674b;
    private final Provider<C1734a> f1675c;

    public final /* synthetic */ void injectMembers(Object obj) {
        dm dmVar = (dm) obj;
        if (dmVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        dmVar.f1551v = (cq) this.f1674b.get();
        dmVar.f1665d = (C1734a) this.f1675c.get();
    }

    private dq(Provider<cq> provider, Provider<C1734a> provider2) {
        if (f1673a || provider != null) {
            this.f1674b = provider;
            if (f1673a || provider2 != null) {
                this.f1675c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<dm> m1481a(Provider<cq> provider, Provider<C1734a> provider2) {
        return new dq(provider, provider2);
    }
}
