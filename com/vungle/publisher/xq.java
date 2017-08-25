package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xq implements Factory<xp> {
    static final /* synthetic */ boolean f3608a = (!xq.class.desiredAssertionStatus());
    private final MembersInjector<xp> f3609b;

    private xq(MembersInjector<xp> membersInjector) {
        if (f3608a || membersInjector != null) {
            this.f3609b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xp> m2620a(MembersInjector<xp> membersInjector) {
        return new xq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xp) MembersInjectors.injectMembers(this.f3609b, new xp());
    }
}
