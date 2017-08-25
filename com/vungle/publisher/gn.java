package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gn implements Factory<ey> {
    static final /* synthetic */ boolean f1999a = (!gn.class.desiredAssertionStatus());
    private final MembersInjector<ey> f2000b;

    private gn(MembersInjector<ey> membersInjector) {
        if (f1999a || membersInjector != null) {
            this.f2000b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ey> m1837a(MembersInjector<ey> membersInjector) {
        return new gn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ey) MembersInjectors.injectMembers(this.f2000b, new ey());
    }
}
