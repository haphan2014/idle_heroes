package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class qf implements MembersInjector<qb> {
    static final /* synthetic */ boolean f3004a = (!qf.class.desiredAssertionStatus());
    private final Provider<qh> f3005b;
    private final Provider<ce> f3006c;
    private final Provider<C1821m> f3007d;

    public final /* synthetic */ void injectMembers(Object obj) {
        qb qbVar = (qb) obj;
        if (qbVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        qbVar.f1341v = (qh) this.f3005b.get();
        qbVar.f2994c = (ce) this.f3006c.get();
        qbVar.f2995d = (C1821m) this.f3007d.get();
    }

    private qf(Provider<qh> provider, Provider<ce> provider2, Provider<C1821m> provider3) {
        if (f3004a || provider != null) {
            this.f3005b = provider;
            if (f3004a || provider2 != null) {
                this.f3006c = provider2;
                if (f3004a || provider3 != null) {
                    this.f3007d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<qb> m2360a(Provider<qh> provider, Provider<ce> provider2, Provider<C1821m> provider3) {
        return new qf(provider, provider2, provider3);
    }
}
