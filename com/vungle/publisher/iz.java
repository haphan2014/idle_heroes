package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.il.C1791a;
import com.vungle.publisher.iq.C1792a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class iz implements MembersInjector<iq> {
    static final /* synthetic */ boolean f2220a = (!iz.class.desiredAssertionStatus());
    private final Provider<cq> f2221b;
    private final Provider<C1733a> f2222c;
    private final Provider<agg> f2223d;
    private final Provider<C1792a> f2224e;
    private final Provider<C1791a> f2225f;

    public final /* synthetic */ void injectMembers(Object obj) {
        iq iqVar = (iq) obj;
        if (iqVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        iqVar.f1551v = (cq) this.f2221b.get();
        iqVar.f1622r = (C1733a) this.f2222c.get();
        iqVar.f1623s = (agg) this.f2223d.get();
        iqVar.f2195w = (C1792a) this.f2224e.get();
        iqVar.f2196x = (C1791a) this.f2225f.get();
    }

    private iz(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1792a> provider4, Provider<C1791a> provider5) {
        if (f2220a || provider != null) {
            this.f2221b = provider;
            if (f2220a || provider2 != null) {
                this.f2222c = provider2;
                if (f2220a || provider3 != null) {
                    this.f2223d = provider3;
                    if (f2220a || provider4 != null) {
                        this.f2224e = provider4;
                        if (f2220a || provider5 != null) {
                            this.f2225f = provider5;
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

    public static MembersInjector<iq> m1993a(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1792a> provider4, Provider<C1791a> provider5) {
        return new iz(provider, provider2, provider3, provider4, provider5);
    }
}
