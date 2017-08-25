package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hq implements Factory<hp> {
    static final /* synthetic */ boolean f2090a = (!hq.class.desiredAssertionStatus());
    private final MembersInjector<hp> f2091b;

    private hq(MembersInjector<hp> membersInjector) {
        if (f2090a || membersInjector != null) {
            this.f2091b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<hp> m1920a(MembersInjector<hp> membersInjector) {
        return new hq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (hp) MembersInjectors.injectMembers(this.f2091b, new hp());
    }
}
