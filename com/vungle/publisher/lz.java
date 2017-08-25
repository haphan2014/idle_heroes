package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lz implements Factory<ly> {
    static final /* synthetic */ boolean f2513a = (!lz.class.desiredAssertionStatus());
    private final MembersInjector<ly> f2514b;

    private lz(MembersInjector<ly> membersInjector) {
        if (f2513a || membersInjector != null) {
            this.f2514b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ly> m2152a(MembersInjector<ly> membersInjector) {
        return new lz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ly) MembersInjectors.injectMembers(this.f2514b, new ly());
    }
}
