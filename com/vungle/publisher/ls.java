package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ls implements Factory<lr> {
    static final /* synthetic */ boolean f2497a = (!ls.class.desiredAssertionStatus());
    private final MembersInjector<lr> f2498b;

    private ls(MembersInjector<lr> membersInjector) {
        if (f2497a || membersInjector != null) {
            this.f2498b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<lr> m2143a(MembersInjector<lr> membersInjector) {
        return new ls(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (lr) MembersInjectors.injectMembers(this.f2498b, new lr());
    }
}
