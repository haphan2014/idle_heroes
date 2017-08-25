package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class mo implements Factory<mn> {
    static final /* synthetic */ boolean f2576a = (!mo.class.desiredAssertionStatus());
    private final MembersInjector<mn> f2577b;

    private mo(MembersInjector<mn> membersInjector) {
        if (f2576a || membersInjector != null) {
            this.f2577b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<mn> m2167a(MembersInjector<mn> membersInjector) {
        return new mo(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (mn) MembersInjectors.injectMembers(this.f2577b, new mn());
    }
}
