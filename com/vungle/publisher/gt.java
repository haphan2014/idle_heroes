package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gt implements Factory<gs> {
    static final /* synthetic */ boolean f2018a = (!gt.class.desiredAssertionStatus());
    private final MembersInjector<gs> f2019b;

    private gt(MembersInjector<gs> membersInjector) {
        if (f2018a || membersInjector != null) {
            this.f2019b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<gs> m1855a(MembersInjector<gs> membersInjector) {
        return new gt(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (gs) MembersInjectors.injectMembers(this.f2019b, new gs());
    }
}
