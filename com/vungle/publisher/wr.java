package com.vungle.publisher;

import com.vungle.publisher.wo.C1902a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class wr implements MembersInjector<C1902a> {
    static final /* synthetic */ boolean f3530a = (!wr.class.desiredAssertionStatus());
    private final Provider<wo> f3531b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1902a c1902a = (C1902a) obj;
        if (c1902a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1902a.f3523a = this.f3531b;
    }

    private wr(Provider<wo> provider) {
        if (f3530a || provider != null) {
            this.f3531b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1902a> m2587a(Provider<wo> provider) {
        return new wr(provider);
    }
}
