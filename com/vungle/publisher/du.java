package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.dr.C1737a;
import com.vungle.publisher.gs.C1777a;
import com.vungle.publisher.jn.C1796a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class du implements MembersInjector<C1737a> {
    static final /* synthetic */ boolean f1695a = (!du.class.desiredAssertionStatus());
    private final Provider<cq> f1696b;
    private final Provider<C1892a> f1697c;
    private final Provider<dr> f1698d;
    private final Provider<C1777a> f1699e;
    private final Provider<C1796a> f1700f;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1737a c1737a = (C1737a) obj;
        if (c1737a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1737a.f1530d = (cq) this.f1696b.get();
        c1737a.f1676e = (C1892a) this.f1697c.get();
        c1737a.f1677a = this.f1698d;
        c1737a.f1678b = (C1777a) this.f1699e.get();
        c1737a.f1679c = (C1796a) this.f1700f.get();
    }

    private du(Provider<cq> provider, Provider<C1892a> provider2, Provider<dr> provider3, Provider<C1777a> provider4, Provider<C1796a> provider5) {
        if (f1695a || provider != null) {
            this.f1696b = provider;
            if (f1695a || provider2 != null) {
                this.f1697c = provider2;
                if (f1695a || provider3 != null) {
                    this.f1698d = provider3;
                    if (f1695a || provider4 != null) {
                        this.f1699e = provider4;
                        if (f1695a || provider5 != null) {
                            this.f1700f = provider5;
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

    public static MembersInjector<C1737a> m1540a(Provider<cq> provider, Provider<C1892a> provider2, Provider<dr> provider3, Provider<C1777a> provider4, Provider<C1796a> provider5) {
        return new du(provider, provider2, provider3, provider4, provider5);
    }
}
