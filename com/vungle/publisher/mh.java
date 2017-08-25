package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class mh implements Factory<mg> {
    static final /* synthetic */ boolean f2570a = (!mh.class.desiredAssertionStatus());
    private final MembersInjector<mg> f2571b;

    private mh(MembersInjector<mg> membersInjector) {
        if (f2570a || membersInjector != null) {
            this.f2571b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<mg> m2165a(MembersInjector<mg> membersInjector) {
        return new mh(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (mg) MembersInjectors.injectMembers(this.f2571b, new mg());
    }
}
