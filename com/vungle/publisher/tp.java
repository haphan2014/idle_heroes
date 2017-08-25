package com.vungle.publisher;

import com.vungle.publisher.tm.C1888a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class tp implements MembersInjector<C1888a> {
    static final /* synthetic */ boolean f3319a = (!tp.class.desiredAssertionStatus());
    private final Provider<tm> f3320b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1888a c1888a = (C1888a) obj;
        if (c1888a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1888a.f3299a = this.f3320b;
    }

    private tp(Provider<tm> provider) {
        if (f3319a || provider != null) {
            this.f3320b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1888a> m2512a(Provider<tm> provider) {
        return new tp(provider);
    }
}
