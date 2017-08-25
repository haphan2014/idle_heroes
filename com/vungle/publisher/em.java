package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.ei.C1748c;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class em implements MembersInjector<C1748c> {
    static final /* synthetic */ boolean f1761a = (!em.class.desiredAssertionStatus());
    private final Provider<cq> f1762b;
    private final Provider<C1892a> f1763c;
    private final Provider<C1778a> f1764d;
    private final Provider<agg> f1765e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1748c c1748c = (C1748c) obj;
        if (c1748c == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1748c.f1741a = (cq) this.f1762b.get();
        c1748c.f1742b = (C1892a) this.f1763c.get();
        c1748c.f1743c = (C1778a) this.f1764d.get();
        c1748c.f1744d = (agg) this.f1765e.get();
    }

    private em(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1778a> provider3, Provider<agg> provider4) {
        if (f1761a || provider != null) {
            this.f1762b = provider;
            if (f1761a || provider2 != null) {
                this.f1763c = provider2;
                if (f1761a || provider3 != null) {
                    this.f1764d = provider3;
                    if (f1761a || provider4 != null) {
                        this.f1765e = provider4;
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

    public static MembersInjector<C1748c> m1587a(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1778a> provider3, Provider<agg> provider4) {
        return new em(provider, provider2, provider3, provider4);
    }
}
