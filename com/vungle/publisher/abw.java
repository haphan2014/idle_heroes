package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class abw implements MembersInjector<abs> {
    static final /* synthetic */ boolean f974a = (!abw.class.desiredAssertionStatus());
    private final Provider<pj> f975b;
    private final Provider<pq> f976c;

    public final /* synthetic */ void injectMembers(Object obj) {
        abs com_vungle_publisher_abs = (abs) obj;
        if (com_vungle_publisher_abs == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_abs.f966b = (pj) this.f975b.get();
        com_vungle_publisher_abs.f967c = (pq) this.f976c.get();
    }

    private abw(Provider<pj> provider, Provider<pq> provider2) {
        if (f974a || provider != null) {
            this.f975b = provider;
            if (f974a || provider2 != null) {
                this.f976c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<abs> m965a(Provider<pj> provider, Provider<pq> provider2) {
        return new abw(provider, provider2);
    }
}
