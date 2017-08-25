package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xh implements Factory<xg> {
    static final /* synthetic */ boolean f3570a = (!xh.class.desiredAssertionStatus());
    private final MembersInjector<xg> f3571b;

    private xh(MembersInjector<xg> membersInjector) {
        if (f3570a || membersInjector != null) {
            this.f3571b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xg> m2605a(MembersInjector<xg> membersInjector) {
        return new xh(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xg) MembersInjectors.injectMembers(this.f3571b, new xg());
    }
}
