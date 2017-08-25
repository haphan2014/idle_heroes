package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ms implements MembersInjector<mq> {
    static final /* synthetic */ boolean f2584a = (!ms.class.desiredAssertionStatus());
    private final Provider<qh> f2585b;
    private final Provider<mt> f2586c;

    public final /* synthetic */ void injectMembers(Object obj) {
        mq mqVar = (mq) obj;
        if (mqVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mqVar.f2580a = (qh) this.f2585b.get();
        mqVar.f2581b = (mt) this.f2586c.get();
    }

    private ms(Provider<qh> provider, Provider<mt> provider2) {
        if (f2584a || provider != null) {
            this.f2585b = provider;
            if (f2584a || provider2 != null) {
                this.f2586c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<mq> m2170a(Provider<qh> provider, Provider<mt> provider2) {
        return new ms(provider, provider2);
    }
}
