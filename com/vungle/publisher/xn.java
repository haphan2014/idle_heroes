package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xn implements Factory<xm> {
    static final /* synthetic */ boolean f3580a = (!xn.class.desiredAssertionStatus());
    private final MembersInjector<xm> f3581b;

    private xn(MembersInjector<xm> membersInjector) {
        if (f3580a || membersInjector != null) {
            this.f3581b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xm> m2610a(MembersInjector<xm> membersInjector) {
        return new xn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xm) MembersInjectors.injectMembers(this.f3581b, new xm());
    }
}
