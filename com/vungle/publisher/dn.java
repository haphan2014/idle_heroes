package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class dn implements Factory<dm> {
    static final /* synthetic */ boolean f1666a = (!dn.class.desiredAssertionStatus());
    private final MembersInjector<dm> f1667b;

    private dn(MembersInjector<dm> membersInjector) {
        if (f1666a || membersInjector != null) {
            this.f1667b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<dm> m1478a(MembersInjector<dm> membersInjector) {
        return new dn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (dm) MembersInjectors.injectMembers(this.f1667b, new dm());
    }
}
