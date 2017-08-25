package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xo implements MembersInjector<xm> {
    static final /* synthetic */ boolean f3582a = (!xo.class.desiredAssertionStatus());
    private final Provider<vv> f3583b;

    public final /* synthetic */ void injectMembers(Object obj) {
        xm xmVar = (xm) obj;
        if (xmVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        xmVar.f3579a = (vv) this.f3583b.get();
    }

    private xo(Provider<vv> provider) {
        if (f3582a || provider != null) {
            this.f3583b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<xm> m2611a(Provider<vv> provider) {
        return new xo(provider);
    }
}
