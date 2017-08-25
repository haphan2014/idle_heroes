package com.vungle.publisher;

import com.vungle.publisher.aej.C1682a;
import com.vungle.publisher.aej.C1682a.C1681a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ael implements MembersInjector<C1682a> {
    static final /* synthetic */ boolean f1227a = (!ael.class.desiredAssertionStatus());
    private final Provider<C1681a> f1228b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1682a c1682a = (C1682a) obj;
        if (c1682a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1682a.f1224a = (C1681a) this.f1228b.get();
    }

    private ael(Provider<C1681a> provider) {
        if (f1227a || provider != null) {
            this.f1228b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1682a> m1145a(Provider<C1681a> provider) {
        return new ael(provider);
    }
}
