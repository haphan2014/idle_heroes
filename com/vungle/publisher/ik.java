package com.vungle.publisher;

import com.vungle.publisher.ig.C1790a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ik implements MembersInjector<ig> {
    static final /* synthetic */ boolean f2168a = (!ik.class.desiredAssertionStatus());
    private final Provider<cq> f2169b;
    private final Provider<C1790a> f2170c;

    public final /* synthetic */ void injectMembers(Object obj) {
        ig igVar = (ig) obj;
        if (igVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        igVar.f1551v = (cq) this.f2169b.get();
        igVar.f2160d = (C1790a) this.f2170c.get();
    }

    private ik(Provider<cq> provider, Provider<C1790a> provider2) {
        if (f2168a || provider != null) {
            this.f2169b = provider;
            if (f2168a || provider2 != null) {
                this.f2170c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ig> m1969a(Provider<cq> provider, Provider<C1790a> provider2) {
        return new ik(provider, provider2);
    }
}
