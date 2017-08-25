package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aeq implements Factory<aep> {
    static final /* synthetic */ boolean f1238a = (!aeq.class.desiredAssertionStatus());
    private final MembersInjector<aep> f1239b;

    private aeq(MembersInjector<aep> membersInjector) {
        if (f1238a || membersInjector != null) {
            this.f1239b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aep> m1152a(MembersInjector<aep> membersInjector) {
        return new aeq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aep) MembersInjectors.injectMembers(this.f1239b, new aep());
    }
}
