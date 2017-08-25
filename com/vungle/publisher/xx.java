package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xx implements Factory<xw> {
    static final /* synthetic */ boolean f3638a = (!xx.class.desiredAssertionStatus());
    private final MembersInjector<xw> f3639b;

    private xx(MembersInjector<xw> membersInjector) {
        if (f3638a || membersInjector != null) {
            this.f3639b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xw> m2635a(MembersInjector<xw> membersInjector) {
        return new xx(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xw) MembersInjectors.injectMembers(this.f3639b, new xw());
    }
}
