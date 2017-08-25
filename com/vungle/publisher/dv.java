package com.vungle.publisher;

import com.vungle.publisher.dr.C1737a;
import com.vungle.publisher.kd.C1801a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dv implements MembersInjector<dr> {
    static final /* synthetic */ boolean f1701a = (!dv.class.desiredAssertionStatus());
    private final Provider<cq> f1702b;
    private final Provider<C1801a> f1703c;
    private final Provider<C1737a> f1704d;

    public final /* synthetic */ void injectMembers(Object obj) {
        dr drVar = (dr) obj;
        if (drVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        drVar.f1551v = (cq) this.f1702b.get();
        drVar.f1689e = (C1801a) this.f1703c.get();
        drVar.f1690f = (C1737a) this.f1704d.get();
    }

    private dv(Provider<cq> provider, Provider<C1801a> provider2, Provider<C1737a> provider3) {
        if (f1701a || provider != null) {
            this.f1702b = provider;
            if (f1701a || provider2 != null) {
                this.f1703c = provider2;
                if (f1701a || provider3 != null) {
                    this.f1704d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<dr> m1541a(Provider<cq> provider, Provider<C1801a> provider2, Provider<C1737a> provider3) {
        return new dv(provider, provider2, provider3);
    }
}
