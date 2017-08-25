package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class wc implements MembersInjector<wa> {
    static final /* synthetic */ boolean f3496a = (!wc.class.desiredAssertionStatus());
    private final Provider<C1778a> f3497b;

    public final /* synthetic */ void injectMembers(Object obj) {
        wa waVar = (wa) obj;
        if (waVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        waVar.f3493a = (C1778a) this.f3497b.get();
    }

    private wc(Provider<C1778a> provider) {
        if (f3496a || provider != null) {
            this.f3497b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<wa> m2568a(Provider<C1778a> provider) {
        return new wc(provider);
    }
}
