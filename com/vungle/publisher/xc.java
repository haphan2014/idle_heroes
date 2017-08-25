package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xc implements Factory<xb> {
    static final /* synthetic */ boolean f3559a = (!xc.class.desiredAssertionStatus());
    private final MembersInjector<xb> f3560b;

    private xc(MembersInjector<xb> membersInjector) {
        if (f3559a || membersInjector != null) {
            this.f3560b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xb> m2599a(MembersInjector<xb> membersInjector) {
        return new xc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xb) MembersInjectors.injectMembers(this.f3560b, new xb());
    }
}
