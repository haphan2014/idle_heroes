package com.vungle.publisher;

import com.vungle.publisher.wy.C1903a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xa implements MembersInjector<C1903a> {
    static final /* synthetic */ boolean f3554a = (!xa.class.desiredAssertionStatus());
    private final Provider<pj> f3555b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1903a c1903a = (C1903a) obj;
        if (c1903a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1903a.f779a = (pj) this.f3555b.get();
    }

    private xa(Provider<pj> provider) {
        if (f3554a || provider != null) {
            this.f3555b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1903a> m2597a(Provider<pj> provider) {
        return new xa(provider);
    }
}
