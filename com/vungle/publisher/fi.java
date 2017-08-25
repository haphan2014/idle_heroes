package com.vungle.publisher;

import com.vungle.publisher.ff.C1765a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fi implements MembersInjector<C1765a> {
    static final /* synthetic */ boolean f1895a = (!fi.class.desiredAssertionStatus());
    private final Provider<ff> f1896b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1765a c1765a = (C1765a) obj;
        if (c1765a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1765a.f1890a = (ff) this.f1896b.get();
    }

    private fi(Provider<ff> provider) {
        if (f1895a || provider != null) {
            this.f1896b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1765a> m1777a(Provider<ff> provider) {
        return new fi(provider);
    }
}
