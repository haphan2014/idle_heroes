package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class sd implements MembersInjector<sb> {
    static final /* synthetic */ boolean f3171a = (!sd.class.desiredAssertionStatus());
    private final Provider<sf> f3172b;

    public final /* synthetic */ void injectMembers(Object obj) {
        sb sbVar = (sb) obj;
        if (sbVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        sbVar.f3168a = (sf) this.f3172b.get();
    }

    private sd(Provider<sf> provider) {
        if (f3171a || provider != null) {
            this.f3172b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<sb> m2439a(Provider<sf> provider) {
        return new sd(provider);
    }
}
