package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xl implements MembersInjector<xj> {
    static final /* synthetic */ boolean f3577a = (!xl.class.desiredAssertionStatus());
    private final Provider<wa> f3578b;

    public final /* synthetic */ void injectMembers(Object obj) {
        xj xjVar = (xj) obj;
        if (xjVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        xjVar.f3574a = (wa) this.f3578b.get();
    }

    private xl(Provider<wa> provider) {
        if (f3577a || provider != null) {
            this.f3578b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<xj> m2609a(Provider<wa> provider) {
        return new xl(provider);
    }
}
