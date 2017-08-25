package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ln implements Factory<kd> {
    static final /* synthetic */ boolean f2474a = (!ln.class.desiredAssertionStatus());
    private final MembersInjector<kd> f2475b;

    private ln(MembersInjector<kd> membersInjector) {
        if (f2474a || membersInjector != null) {
            this.f2475b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<kd> m2130a(MembersInjector<kd> membersInjector) {
        return new ln(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (kd) MembersInjectors.injectMembers(this.f2475b, new kd());
    }
}
