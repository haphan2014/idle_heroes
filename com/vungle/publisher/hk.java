package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hk implements Factory<hj> {
    static final /* synthetic */ boolean f2073a = (!hk.class.desiredAssertionStatus());
    private final MembersInjector<hj> f2074b;

    private hk(MembersInjector<hj> membersInjector) {
        if (f2073a || membersInjector != null) {
            this.f2074b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<hj> m1904a(MembersInjector<hj> membersInjector) {
        return new hk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (hj) MembersInjectors.injectMembers(this.f2074b, new hj());
    }
}
