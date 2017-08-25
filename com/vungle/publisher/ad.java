package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ad implements Factory<ac> {
    static final /* synthetic */ boolean f1078a = (!ad.class.desiredAssertionStatus());
    private final MembersInjector<ac> f1079b;

    private ad(MembersInjector<ac> membersInjector) {
        if (f1078a || membersInjector != null) {
            this.f1079b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ac> m1026a(MembersInjector<ac> membersInjector) {
        return new ad(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ac) MembersInjectors.injectMembers(this.f1079b, new ac());
    }
}
