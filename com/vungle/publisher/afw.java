package com.vungle.publisher;

import com.vungle.publisher.aft.C1704a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afw implements MembersInjector<C1704a> {
    static final /* synthetic */ boolean f1393a = (!afw.class.desiredAssertionStatus());
    private final Provider<aft> f1394b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1704a c1704a = (C1704a) obj;
        if (c1704a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1704a.f1385a = (aft) this.f1394b.get();
    }

    private afw(Provider<aft> provider) {
        if (f1393a || provider != null) {
            this.f1394b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1704a> m1203a(Provider<aft> provider) {
        return new afw(provider);
    }
}
