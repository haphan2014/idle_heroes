package com.vungle.publisher;

import com.vungle.publisher.fv.C1773a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fz implements MembersInjector<fv> {
    static final /* synthetic */ boolean f1943a = (!fz.class.desiredAssertionStatus());
    private final Provider<cq> f1944b;
    private final Provider<C1773a> f1945c;

    public final /* synthetic */ void injectMembers(Object obj) {
        fv fvVar = (fv) obj;
        if (fvVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        fvVar.f1551v = (cq) this.f1944b.get();
        fvVar.f1935e = (C1773a) this.f1945c.get();
    }

    private fz(Provider<cq> provider, Provider<C1773a> provider2) {
        if (f1943a || provider != null) {
            this.f1944b = provider;
            if (f1943a || provider2 != null) {
                this.f1945c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<fv> m1811a(Provider<cq> provider, Provider<C1773a> provider2) {
        return new fz(provider, provider2);
    }
}
