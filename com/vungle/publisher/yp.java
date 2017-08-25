package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yp implements Factory<yo> {
    static final /* synthetic */ boolean f3699a = (!yp.class.desiredAssertionStatus());
    private final MembersInjector<yo> f3700b;

    private yp(MembersInjector<yo> membersInjector) {
        if (f3699a || membersInjector != null) {
            this.f3700b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<yo> m2662a(MembersInjector<yo> membersInjector) {
        return new yp(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (yo) MembersInjectors.injectMembers(this.f3700b, new yo());
    }
}
