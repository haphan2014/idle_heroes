package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class sc implements Factory<sb> {
    static final /* synthetic */ boolean f3169a = (!sc.class.desiredAssertionStatus());
    private final MembersInjector<sb> f3170b;

    private sc(MembersInjector<sb> membersInjector) {
        if (f3169a || membersInjector != null) {
            this.f3170b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<sb> m2438a(MembersInjector<sb> membersInjector) {
        return new sc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (sb) MembersInjectors.injectMembers(this.f3170b, new sb());
    }
}
