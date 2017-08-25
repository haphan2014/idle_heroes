package com.vungle.publisher;

import com.vungle.publisher.kj.C1803a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class km implements MembersInjector<C1803a> {
    static final /* synthetic */ boolean f2380a = (!km.class.desiredAssertionStatus());
    private final Provider<kj> f2381b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1803a c1803a = (C1803a) obj;
        if (c1803a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1803a.f2375a = (kj) this.f2381b.get();
    }

    private km(Provider<kj> provider) {
        if (f2380a || provider != null) {
            this.f2381b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1803a> m2071a(Provider<kj> provider) {
        return new km(provider);
    }
}
