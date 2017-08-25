package com.vungle.publisher;

import com.vungle.publisher.hd.C1780a;
import com.vungle.publisher.ly.C1813a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ic implements MembersInjector<hd> {
    static final /* synthetic */ boolean f2130a = (!ic.class.desiredAssertionStatus());
    private final Provider<cq> f2131b;
    private final Provider<C1780a> f2132c;
    private final Provider<C1813a> f2133d;

    public final /* synthetic */ void injectMembers(Object obj) {
        hd hdVar = (hd) obj;
        if (hdVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        hdVar.f1551v = (cq) this.f2131b.get();
        hdVar.f2057q = (C1780a) this.f2132c.get();
        hdVar.f2058r = (C1813a) this.f2133d.get();
    }

    private ic(Provider<cq> provider, Provider<C1780a> provider2, Provider<C1813a> provider3) {
        if (f2130a || provider != null) {
            this.f2131b = provider;
            if (f2130a || provider2 != null) {
                this.f2132c = provider2;
                if (f2130a || provider3 != null) {
                    this.f2133d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<hd> m1934a(Provider<cq> provider, Provider<C1780a> provider2, Provider<C1813a> provider3) {
        return new ic(provider, provider2, provider3);
    }
}
