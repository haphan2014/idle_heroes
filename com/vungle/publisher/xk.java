package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xk implements Factory<xj> {
    static final /* synthetic */ boolean f3575a = (!xk.class.desiredAssertionStatus());
    private final MembersInjector<xj> f3576b;

    private xk(MembersInjector<xj> membersInjector) {
        if (f3575a || membersInjector != null) {
            this.f3576b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xj> m2608a(MembersInjector<xj> membersInjector) {
        return new xk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xj) MembersInjectors.injectMembers(this.f3576b, new xj());
    }
}
