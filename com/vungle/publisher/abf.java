package com.vungle.publisher;

import com.vungle.publisher.abc.C1641a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class abf implements MembersInjector<C1641a> {
    static final /* synthetic */ boolean f929a = (!abf.class.desiredAssertionStatus());
    private final Provider<abc> f930b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1641a c1641a = (C1641a) obj;
        if (c1641a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1641a.f923a = this.f930b;
    }

    private abf(Provider<abc> provider) {
        if (f929a || provider != null) {
            this.f930b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1641a> m927a(Provider<abc> provider) {
        return new abf(provider);
    }
}
