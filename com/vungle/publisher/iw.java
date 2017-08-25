package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class iw implements Factory<iq> {
    static final /* synthetic */ boolean f2209a = (!iw.class.desiredAssertionStatus());
    private final MembersInjector<iq> f2210b;

    private iw(MembersInjector<iq> membersInjector) {
        if (f2209a || membersInjector != null) {
            this.f2210b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<iq> m1990a(MembersInjector<iq> membersInjector) {
        return new iw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (iq) MembersInjectors.injectMembers(this.f2210b, new iq());
    }
}
