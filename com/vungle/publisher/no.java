package com.vungle.publisher;

import com.vungle.publisher.nl.C1835a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class no implements MembersInjector<C1835a> {
    static final /* synthetic */ boolean f2678a = (!no.class.desiredAssertionStatus());
    private final Provider<nl> f2679b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1835a c1835a = (C1835a) obj;
        if (c1835a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1835a.f2655a = this.f2679b;
    }

    private no(Provider<nl> provider) {
        if (f2678a || provider != null) {
            this.f2679b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1835a> m2234a(Provider<nl> provider) {
        return new no(provider);
    }
}
