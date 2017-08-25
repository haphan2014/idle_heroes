package com.vungle.publisher;

import com.vungle.publisher.oh.C1845a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class oj implements MembersInjector<C1845a> {
    static final /* synthetic */ boolean f2753a = (!oj.class.desiredAssertionStatus());
    private final Provider<agj> f2754b;
    private final Provider<qh> f2755c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1845a c1845a = (C1845a) obj;
        if (c1845a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1845a.f2746a = (agj) this.f2754b.get();
        c1845a.f2747b = (qh) this.f2755c.get();
    }

    private oj(Provider<agj> provider, Provider<qh> provider2) {
        if (f2753a || provider != null) {
            this.f2754b = provider;
            if (f2753a || provider2 != null) {
                this.f2755c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1845a> m2265a(Provider<agj> provider, Provider<qh> provider2) {
        return new oj(provider, provider2);
    }
}
