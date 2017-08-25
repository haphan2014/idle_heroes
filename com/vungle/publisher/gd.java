package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.fp.C1769a;
import com.vungle.publisher.fu.C1771a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gd implements MembersInjector<fu> {
    static final /* synthetic */ boolean f1960a = (!gd.class.desiredAssertionStatus());
    private final Provider<cq> f1961b;
    private final Provider<C1733a> f1962c;
    private final Provider<agg> f1963d;
    private final Provider<C1771a> f1964e;
    private final Provider<C1769a> f1965f;

    public final /* synthetic */ void injectMembers(Object obj) {
        fu fuVar = (fu) obj;
        if (fuVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        fuVar.f1551v = (cq) this.f1961b.get();
        fuVar.f1622r = (C1733a) this.f1962c.get();
        fuVar.f1623s = (agg) this.f1963d.get();
        fuVar.f1931w = (C1771a) this.f1964e.get();
        fuVar.f1932x = (C1769a) this.f1965f.get();
    }

    private gd(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1771a> provider4, Provider<C1769a> provider5) {
        if (f1960a || provider != null) {
            this.f1961b = provider;
            if (f1960a || provider2 != null) {
                this.f1962c = provider2;
                if (f1960a || provider3 != null) {
                    this.f1963d = provider3;
                    if (f1960a || provider4 != null) {
                        this.f1964e = provider4;
                        if (f1960a || provider5 != null) {
                            this.f1965f = provider5;
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

    public static MembersInjector<fu> m1816a(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1771a> provider4, Provider<C1769a> provider5) {
        return new gd(provider, provider2, provider3, provider4, provider5);
    }
}
