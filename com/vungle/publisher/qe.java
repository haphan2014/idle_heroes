package com.vungle.publisher;

import com.vungle.publisher.qb.C1868a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class qe implements MembersInjector<C1868a> {
    static final /* synthetic */ boolean f3002a = (!qe.class.desiredAssertionStatus());
    private final Provider<qb> f3003b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1868a c1868a = (C1868a) obj;
        if (c1868a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1868a.f2991a = this.f3003b;
    }

    private qe(Provider<qb> provider) {
        if (f3002a || provider != null) {
            this.f3003b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1868a> m2359a(Provider<qb> provider) {
        return new qe(provider);
    }
}
