package com.vungle.publisher;

import com.vungle.publisher.kz.C1807a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ld implements MembersInjector<kz> {
    static final /* synthetic */ boolean f2442a = (!ld.class.desiredAssertionStatus());
    private final Provider<cq> f2443b;
    private final Provider<C1807a> f2444c;

    public final /* synthetic */ void injectMembers(Object obj) {
        kz kzVar = (kz) obj;
        if (kzVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        kzVar.f1551v = (cq) this.f2443b.get();
        kzVar.f2420e = (C1807a) this.f2444c.get();
    }

    private ld(Provider<cq> provider, Provider<C1807a> provider2) {
        if (f2442a || provider != null) {
            this.f2443b = provider;
            if (f2442a || provider2 != null) {
                this.f2444c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<kz> m2118a(Provider<cq> provider, Provider<C1807a> provider2) {
        return new ld(provider, provider2);
    }
}
