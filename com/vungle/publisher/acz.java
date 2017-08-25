package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class acz implements MembersInjector<acv> {
    static final /* synthetic */ boolean f1075a = (!acz.class.desiredAssertionStatus());
    private final Provider<pj> f1076b;
    private final Provider<pq> f1077c;

    public final /* synthetic */ void injectMembers(Object obj) {
        acv com_vungle_publisher_acv = (acv) obj;
        if (com_vungle_publisher_acv == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_acv.f1061a = (pj) this.f1076b.get();
        com_vungle_publisher_acv.f1062b = (pq) this.f1077c.get();
    }

    private acz(Provider<pj> provider, Provider<pq> provider2) {
        if (f1075a || provider != null) {
            this.f1076b = provider;
            if (f1075a || provider2 != null) {
                this.f1077c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<acv> m1025a(Provider<pj> provider, Provider<pq> provider2) {
        return new acz(provider, provider2);
    }
}
