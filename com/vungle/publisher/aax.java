package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1630b.C1629a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aax implements MembersInjector<C1629a> {
    static final /* synthetic */ boolean f905a = (!aax.class.desiredAssertionStatus());
    private final Provider<sn> f906b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1629a c1629a = (C1629a) obj;
        if (c1629a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1629a.f847a = (sn) this.f906b.get();
    }

    private aax(Provider<sn> provider) {
        if (f905a || provider != null) {
            this.f906b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1629a> m890a(Provider<sn> provider) {
        return new aax(provider);
    }
}
