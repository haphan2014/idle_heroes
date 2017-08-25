package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class cf implements Factory<ce> {
    static final /* synthetic */ boolean f1485a = (!cf.class.desiredAssertionStatus());
    private final MembersInjector<ce> f1486b;

    private cf(MembersInjector<ce> membersInjector) {
        if (f1485a || membersInjector != null) {
            this.f1486b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ce> m1247a(MembersInjector<ce> membersInjector) {
        return new cf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ce) MembersInjectors.injectMembers(this.f1486b, new ce());
    }
}
