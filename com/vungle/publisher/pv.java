package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class pv implements Factory<pu> {
    static final /* synthetic */ boolean f2947a = (!pv.class.desiredAssertionStatus());
    private final MembersInjector<pu> f2948b;

    private pv(MembersInjector<pu> membersInjector) {
        if (f2947a || membersInjector != null) {
            this.f2948b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<pu> m2351a(MembersInjector<pu> membersInjector) {
        return new pv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (pu) MembersInjectors.injectMembers(this.f2948b, new pu());
    }
}
