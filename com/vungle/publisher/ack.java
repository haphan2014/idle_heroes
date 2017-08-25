package com.vungle.publisher;

import com.vungle.publisher.acg.C1659a.C1658a;
import com.vungle.publisher.acg.C1659a.C1658a.C1657a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ack implements MembersInjector<C1658a> {
    static final /* synthetic */ boolean f1025a = (!ack.class.desiredAssertionStatus());
    private final Provider<C1657a> f1026b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1658a c1658a = (C1658a) obj;
        if (c1658a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1658a.f1009a = (C1657a) this.f1026b.get();
    }

    private ack(Provider<C1657a> provider) {
        if (f1025a || provider != null) {
            this.f1026b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1658a> m993a(Provider<C1657a> provider) {
        return new ack(provider);
    }
}
