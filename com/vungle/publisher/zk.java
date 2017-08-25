package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zk implements Factory<zj> {
    static final /* synthetic */ boolean f3779a = (!zk.class.desiredAssertionStatus());
    private final MembersInjector<zj> f3780b;

    private zk(MembersInjector<zj> membersInjector) {
        if (f3779a || membersInjector != null) {
            this.f3780b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<zj> m2707a(MembersInjector<zj> membersInjector) {
        return new zk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (zj) MembersInjectors.injectMembers(this.f3780b, new zj());
    }
}
