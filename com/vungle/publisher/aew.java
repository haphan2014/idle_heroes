package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aew implements Factory<aev> {
    static final /* synthetic */ boolean f1284a = (!aew.class.desiredAssertionStatus());
    private final MembersInjector<aev> f1285b;

    private aew(MembersInjector<aev> membersInjector) {
        if (f1284a || membersInjector != null) {
            this.f1285b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aev> m1159a(MembersInjector<aev> membersInjector) {
        return new aew(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aev) MembersInjectors.injectMembers(this.f1285b, new aev());
    }
}
