package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ss implements Factory<sr> {
    static final /* synthetic */ boolean f3192a = (!ss.class.desiredAssertionStatus());
    private final MembersInjector<sr> f3193b;

    private ss(MembersInjector<sr> membersInjector) {
        if (f3192a || membersInjector != null) {
            this.f3193b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<sr> m2476a(MembersInjector<sr> membersInjector) {
        return new ss(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (sr) MembersInjectors.injectMembers(this.f3193b, new sr());
    }
}
