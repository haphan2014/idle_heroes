package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ps implements Factory<pr> {
    static final /* synthetic */ boolean f2923a = (!ps.class.desiredAssertionStatus());
    private final MembersInjector<pr> f2924b;

    private ps(MembersInjector<pr> membersInjector) {
        if (f2923a || membersInjector != null) {
            this.f2924b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<pr> m2345a(MembersInjector<pr> membersInjector) {
        return new ps(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (pr) MembersInjectors.injectMembers(this.f2924b, new pr());
    }
}
