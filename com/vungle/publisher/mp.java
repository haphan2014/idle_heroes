package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class mp implements MembersInjector<mn> {
    static final /* synthetic */ boolean f2578a = (!mp.class.desiredAssertionStatus());
    private final Provider<qh> f2579b;

    public final /* synthetic */ void injectMembers(Object obj) {
        mn mnVar = (mn) obj;
        if (mnVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mnVar.f2575a = (qh) this.f2579b.get();
    }

    private mp(Provider<qh> provider) {
        if (f2578a || provider != null) {
            this.f2579b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<mn> m2168a(Provider<qh> provider) {
        return new mp(provider);
    }
}
