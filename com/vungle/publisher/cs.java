package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cs implements MembersInjector<cq> {
    static final /* synthetic */ boolean f1525a = (!cs.class.desiredAssertionStatus());
    private final Provider<qq> f1526b;
    private final Provider<qh> f1527c;
    private final Provider<pq> f1528d;
    private final Provider<ce> f1529e;

    public final /* synthetic */ void injectMembers(Object obj) {
        cq cqVar = (cq) obj;
        if (cqVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        cqVar.f1518a = (qq) this.f1526b.get();
        cqVar.f1519b = (qh) this.f1527c.get();
        cqVar.f1520c = (pq) this.f1528d.get();
        cqVar.f1521d = (ce) this.f1529e.get();
    }

    private cs(Provider<qq> provider, Provider<qh> provider2, Provider<pq> provider3, Provider<ce> provider4) {
        if (f1525a || provider != null) {
            this.f1526b = provider;
            if (f1525a || provider2 != null) {
                this.f1527c = provider2;
                if (f1525a || provider3 != null) {
                    this.f1528d = provider3;
                    if (f1525a || provider4 != null) {
                        this.f1529e = provider4;
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

    public static MembersInjector<cq> m1268a(Provider<qq> provider, Provider<qh> provider2, Provider<pq> provider3, Provider<ce> provider4) {
        return new cs(provider, provider2, provider3, provider4);
    }
}
