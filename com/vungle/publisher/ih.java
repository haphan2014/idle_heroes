package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ih implements Factory<ig> {
    static final /* synthetic */ boolean f2161a = (!ih.class.desiredAssertionStatus());
    private final MembersInjector<ig> f2162b;

    private ih(MembersInjector<ig> membersInjector) {
        if (f2161a || membersInjector != null) {
            this.f2162b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ig> m1966a(MembersInjector<ig> membersInjector) {
        return new ih(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ig) MembersInjectors.injectMembers(this.f2162b, new ig());
    }
}
