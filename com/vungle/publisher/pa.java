package com.vungle.publisher;

import com.vungle.publisher.ov.C1858a;
import com.vungle.publisher.ov.C1858a.C1857a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pa implements MembersInjector<C1857a> {
    static final /* synthetic */ boolean f2868a = (!pa.class.desiredAssertionStatus());
    private final Provider<C1858a> f2869b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1857a c1857a = (C1857a) obj;
        if (c1857a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1857a.f2844a = (C1858a) this.f2869b.get();
    }

    private pa(Provider<C1858a> provider) {
        if (f2868a || provider != null) {
            this.f2869b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1857a> m2317a(Provider<C1858a> provider) {
        return new pa(provider);
    }
}
