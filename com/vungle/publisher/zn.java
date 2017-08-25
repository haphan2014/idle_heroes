package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zn implements Factory<zm> {
    static final /* synthetic */ boolean f3791a = (!zn.class.desiredAssertionStatus());
    private final MembersInjector<zm> f3792b;

    private zn(MembersInjector<zm> membersInjector) {
        if (f3791a || membersInjector != null) {
            this.f3792b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<zm> m2710a(MembersInjector<zm> membersInjector) {
        return new zn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (zm) MembersInjectors.injectMembers(this.f3792b, new zm());
    }
}
