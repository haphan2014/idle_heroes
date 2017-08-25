package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afp implements Factory<afo> {
    static final /* synthetic */ boolean f1372a = (!afp.class.desiredAssertionStatus());
    private final MembersInjector<afo> f1373b;

    private afp(MembersInjector<afo> membersInjector) {
        if (f1372a || membersInjector != null) {
            this.f1373b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<afo> m1195a(MembersInjector<afo> membersInjector) {
        return new afp(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (afo) MembersInjectors.injectMembers(this.f1373b, new afo());
    }
}
