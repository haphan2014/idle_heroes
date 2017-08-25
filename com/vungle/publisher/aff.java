package com.vungle.publisher;

import com.vungle.publisher.afd.C1699a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aff implements MembersInjector<C1699a> {
    static final /* synthetic */ boolean f1322a = (!aff.class.desiredAssertionStatus());
    private final Provider<pu> f1323b;
    private final Provider<pl> f1324c;
    private final Provider<qh> f1325d;
    private final Provider<ce> f1326e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1699a c1699a = (C1699a) obj;
        if (c1699a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1699a.f1316a = (pu) this.f1323b.get();
        c1699a.f1317b = (pl) this.f1324c.get();
        c1699a.f1318c = (qh) this.f1325d.get();
        c1699a.f1319d = (ce) this.f1326e.get();
    }

    private aff(Provider<pu> provider, Provider<pl> provider2, Provider<qh> provider3, Provider<ce> provider4) {
        if (f1322a || provider != null) {
            this.f1323b = provider;
            if (f1322a || provider2 != null) {
                this.f1324c = provider2;
                if (f1322a || provider3 != null) {
                    this.f1325d = provider3;
                    if (f1322a || provider4 != null) {
                        this.f1326e = provider4;
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

    public static MembersInjector<C1699a> m1168a(Provider<pu> provider, Provider<pl> provider2, Provider<qh> provider3, Provider<ce> provider4) {
        return new aff(provider, provider2, provider3, provider4);
    }
}
