package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gy implements Factory<gx> {
    static final /* synthetic */ boolean f2040a = (!gy.class.desiredAssertionStatus());
    private final MembersInjector<gx> f2041b;

    private gy(MembersInjector<gx> membersInjector) {
        if (f2040a || membersInjector != null) {
            this.f2041b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<gx> m1874a(MembersInjector<gx> membersInjector) {
        return new gy(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (gx) MembersInjectors.injectMembers(this.f2041b, new gx());
    }
}
