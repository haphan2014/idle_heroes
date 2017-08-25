package com.vungle.publisher;

import com.vungle.publisher.aat.C1636b.C1633a.C1632a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aaz implements MembersInjector<C1632a> {
    static final /* synthetic */ boolean f909a = (!aaz.class.desiredAssertionStatus());
    private final Provider<pj> f910b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1632a c1632a = (C1632a) obj;
        if (c1632a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1632a.f856a = (pj) this.f910b.get();
    }

    private aaz(Provider<pj> provider) {
        if (f909a || provider != null) {
            this.f910b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1632a> m892a(Provider<pj> provider) {
        return new aaz(provider);
    }
}
