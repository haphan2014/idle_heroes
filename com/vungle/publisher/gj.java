package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gj implements Factory<ez> {
    static final /* synthetic */ boolean f1980a = (!gj.class.desiredAssertionStatus());
    private final MembersInjector<ez> f1981b;

    private gj(MembersInjector<ez> membersInjector) {
        if (f1980a || membersInjector != null) {
            this.f1981b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ez> m1833a(MembersInjector<ez> membersInjector) {
        return new gj(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ez) MembersInjectors.injectMembers(this.f1981b, new ez());
    }
}
