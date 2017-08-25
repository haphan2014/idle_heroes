package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aaf implements Factory<aae> {
    static final /* synthetic */ boolean f809a = (!aaf.class.desiredAssertionStatus());
    private final MembersInjector<aae> f810b;

    private aaf(MembersInjector<aae> membersInjector) {
        if (f809a || membersInjector != null) {
            this.f810b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aae> m840a(MembersInjector<aae> membersInjector) {
        return new aaf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aae) MembersInjectors.injectMembers(this.f810b, new aae());
    }
}
