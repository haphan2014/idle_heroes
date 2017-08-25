package com.vungle.publisher;

import com.vungle.publisher.dz.C1739a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ec implements MembersInjector<C1739a> {
    static final /* synthetic */ boolean f1720a = (!ec.class.desiredAssertionStatus());
    private final Provider<dz> f1721b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1739a c1739a = (C1739a) obj;
        if (c1739a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1739a.f1705a = this.f1721b;
    }

    private ec(Provider<dz> provider) {
        if (f1720a || provider != null) {
            this.f1721b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1739a> m1559a(Provider<dz> provider) {
        return new ec(provider);
    }
}
