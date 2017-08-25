package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class qc implements Factory<qb> {
    static final /* synthetic */ boolean f2998a = (!qc.class.desiredAssertionStatus());
    private final MembersInjector<qb> f2999b;

    private qc(MembersInjector<qb> membersInjector) {
        if (f2998a || membersInjector != null) {
            this.f2999b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<qb> m2357a(MembersInjector<qb> membersInjector) {
        return new qc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (qb) MembersInjectors.injectMembers(this.f2999b, new qb());
    }
}
