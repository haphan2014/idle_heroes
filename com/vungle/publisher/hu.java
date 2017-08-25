package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hu implements Factory<ho> {
    static final /* synthetic */ boolean f2100a = (!hu.class.desiredAssertionStatus());
    private final MembersInjector<ho> f2101b;

    private hu(MembersInjector<ho> membersInjector) {
        if (f2100a || membersInjector != null) {
            this.f2101b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ho> m1924a(MembersInjector<ho> membersInjector) {
        return new hu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ho) MembersInjectors.injectMembers(this.f2101b, new ho());
    }
}
