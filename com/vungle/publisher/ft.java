package com.vungle.publisher;

import com.vungle.publisher.fp.C1769a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ft implements MembersInjector<fp> {
    static final /* synthetic */ boolean f1924a = (!ft.class.desiredAssertionStatus());
    private final Provider<cq> f1925b;
    private final Provider<C1769a> f1926c;

    public final /* synthetic */ void injectMembers(Object obj) {
        fp fpVar = (fp) obj;
        if (fpVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        fpVar.f1551v = (cq) this.f1925b.get();
        fpVar.f1915e = (C1769a) this.f1926c.get();
    }

    private ft(Provider<cq> provider, Provider<C1769a> provider2) {
        if (f1924a || provider != null) {
            this.f1925b = provider;
            if (f1924a || provider2 != null) {
                this.f1926c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<fp> m1793a(Provider<cq> provider, Provider<C1769a> provider2) {
        return new ft(provider, provider2);
    }
}
