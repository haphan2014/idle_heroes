package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zt implements Factory<zs> {
    static final /* synthetic */ boolean f3810a = (!zt.class.desiredAssertionStatus());
    private final MembersInjector<zs> f3811b;

    private zt(MembersInjector<zs> membersInjector) {
        if (f3810a || membersInjector != null) {
            this.f3811b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<zs> m2719a(MembersInjector<zs> membersInjector) {
        return new zt(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (zs) MembersInjectors.injectMembers(this.f3811b, new zs());
    }
}
