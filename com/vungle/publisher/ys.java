package com.vungle.publisher;

import com.vungle.publisher.yo.C1920a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ys implements MembersInjector<C1920a> {
    static final /* synthetic */ boolean f3706a = (!ys.class.desiredAssertionStatus());
    private final Provider<xp> f3707b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1920a c1920a = (C1920a) obj;
        if (c1920a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1920a.f3697a = (xp) this.f3707b.get();
    }

    private ys(Provider<xp> provider) {
        if (f3706a || provider != null) {
            this.f3707b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1920a> m2665a(Provider<xp> provider) {
        return new ys(provider);
    }
}
