package com.vungle.publisher;

import com.vungle.publisher.abx.C1655a.C1653a;
import com.vungle.publisher.abx.C1655a.C1653a.C1651a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class acb implements MembersInjector<C1653a> {
    static final /* synthetic */ boolean f994a = (!acb.class.desiredAssertionStatus());
    private final Provider<C1651a> f995b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1653a c1653a = (C1653a) obj;
        if (c1653a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1653a.f977a = (C1651a) this.f995b.get();
    }

    private acb(Provider<C1651a> provider) {
        if (f994a || provider != null) {
            this.f995b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1653a> m979a(Provider<C1651a> provider) {
        return new acb(provider);
    }
}
