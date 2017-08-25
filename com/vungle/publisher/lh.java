package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.ky.C1806a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lh implements MembersInjector<ky> {
    static final /* synthetic */ boolean f2457a = (!lh.class.desiredAssertionStatus());
    private final Provider<cq> f2458b;
    private final Provider<C1733a> f2459c;
    private final Provider<agg> f2460d;
    private final Provider<C1806a> f2461e;

    public final /* synthetic */ void injectMembers(Object obj) {
        ky kyVar = (ky) obj;
        if (kyVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        kyVar.f1551v = (cq) this.f2458b.get();
        kyVar.f1622r = (C1733a) this.f2459c.get();
        kyVar.f1623s = (agg) this.f2460d.get();
        kyVar.f2418y = (C1806a) this.f2461e.get();
    }

    private lh(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1806a> provider4) {
        if (f2457a || provider != null) {
            this.f2458b = provider;
            if (f2457a || provider2 != null) {
                this.f2459c = provider2;
                if (f2457a || provider3 != null) {
                    this.f2460d = provider3;
                    if (f2457a || provider4 != null) {
                        this.f2461e = provider4;
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

    public static MembersInjector<ky> m2122a(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1806a> provider4) {
        return new lh(provider, provider2, provider3, provider4);
    }
}
