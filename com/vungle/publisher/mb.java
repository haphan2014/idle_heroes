package com.vungle.publisher;

import com.vungle.publisher.ly.C1813a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class mb implements MembersInjector<C1813a> {
    static final /* synthetic */ boolean f2552a = (!mb.class.desiredAssertionStatus());
    private final Provider<ly> f2553b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1813a c1813a = (C1813a) obj;
        if (c1813a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1813a.f2510a = this.f2553b;
    }

    private mb(Provider<ly> provider) {
        if (f2552a || provider != null) {
            this.f2553b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1813a> m2160a(Provider<ly> provider) {
        return new mb(provider);
    }
}
