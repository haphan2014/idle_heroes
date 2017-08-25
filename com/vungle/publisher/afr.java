package com.vungle.publisher;

import com.vungle.publisher.afo.C1703a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afr implements MembersInjector<C1703a> {
    static final /* synthetic */ boolean f1376a = (!afr.class.desiredAssertionStatus());
    private final Provider<afo> f1377b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1703a c1703a = (C1703a) obj;
        if (c1703a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1703a.f1370a = (afo) this.f1377b.get();
    }

    private afr(Provider<afo> provider) {
        if (f1376a || provider != null) {
            this.f1377b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1703a> m1197a(Provider<afo> provider) {
        return new afr(provider);
    }
}
