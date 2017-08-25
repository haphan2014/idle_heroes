package com.vungle.publisher;

import com.vungle.publisher.abs.C1650a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class abv implements MembersInjector<C1650a> {
    static final /* synthetic */ boolean f972a = (!abv.class.desiredAssertionStatus());
    private final Provider<abs> f973b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1650a c1650a = (C1650a) obj;
        if (c1650a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1650a.f964a = this.f973b;
    }

    private abv(Provider<abs> provider) {
        if (f972a || provider != null) {
            this.f973b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1650a> m964a(Provider<abs> provider) {
        return new abv(provider);
    }
}
