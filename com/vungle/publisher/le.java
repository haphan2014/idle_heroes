package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class le implements Factory<ky> {
    static final /* synthetic */ boolean f2445a = (!le.class.desiredAssertionStatus());
    private final MembersInjector<ky> f2446b;

    private le(MembersInjector<ky> membersInjector) {
        if (f2445a || membersInjector != null) {
            this.f2446b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ky> m2119a(MembersInjector<ky> membersInjector) {
        return new le(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ky) MembersInjectors.injectMembers(this.f2446b, new ky());
    }
}
