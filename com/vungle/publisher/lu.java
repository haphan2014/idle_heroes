package com.vungle.publisher;

import com.vungle.publisher.lr.C1811a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lu implements MembersInjector<C1811a> {
    static final /* synthetic */ boolean f2501a = (!lu.class.desiredAssertionStatus());
    private final Provider<lr> f2502b;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1811a c1811a = (C1811a) obj;
        if (c1811a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1811a.f2495a = this.f2502b;
    }

    private lu(Provider<lr> provider) {
        if (f2501a || provider != null) {
            this.f2502b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1811a> m2145a(Provider<lr> provider) {
        return new lu(provider);
    }
}
