package com.vungle.publisher;

import com.vungle.publisher.nl.C1837b;
import com.vungle.publisher.nl.C1837b.C1836a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ns implements MembersInjector<C1836a> {
    static final /* synthetic */ boolean f2697a = (!ns.class.desiredAssertionStatus());
    private final Provider<C1837b> f2698b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1836a c1836a = (C1836a) obj;
        if (c1836a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1836a.f2656a = (C1837b) this.f2698b.get();
    }

    private ns(Provider<C1837b> provider) {
        if (f2697a || provider != null) {
            this.f2698b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1836a> m2238a(Provider<C1837b> provider) {
        return new ns(provider);
    }
}
