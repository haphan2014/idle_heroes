package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class im implements Factory<il> {
    static final /* synthetic */ boolean f2174a = (!im.class.desiredAssertionStatus());
    private final MembersInjector<il> f2175b;

    private im(MembersInjector<il> membersInjector) {
        if (f2174a || membersInjector != null) {
            this.f2175b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<il> m1972a(MembersInjector<il> membersInjector) {
        return new im(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (il) MembersInjectors.injectMembers(this.f2175b, new il());
    }
}
