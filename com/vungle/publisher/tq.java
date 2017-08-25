package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class tq implements MembersInjector<tm> {
    static final /* synthetic */ boolean f3321a = (!tq.class.desiredAssertionStatus());
    private final Provider<nf> f3322b;

    public final /* synthetic */ void injectMembers(Object obj) {
        tm tmVar = (tm) obj;
        if (tmVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        tmVar.f3314o = (nf) this.f3322b.get();
    }

    private tq(Provider<nf> provider) {
        if (f3321a || provider != null) {
            this.f3322b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<tm> m2513a(Provider<nf> provider) {
        return new tq(provider);
    }
}
