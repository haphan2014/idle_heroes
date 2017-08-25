package com.vungle.publisher;

import com.vungle.publisher.gs.C1777a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gv implements MembersInjector<C1777a> {
    static final /* synthetic */ boolean f2022a = (!gv.class.desiredAssertionStatus());
    private final Provider<gs> f2023b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1777a c1777a = (C1777a) obj;
        if (c1777a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1777a.f2012a = this.f2023b;
    }

    private gv(Provider<gs> provider) {
        if (f2022a || provider != null) {
            this.f2023b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1777a> m1857a(Provider<gs> provider) {
        return new gv(provider);
    }
}
