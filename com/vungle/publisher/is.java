package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class is implements Factory<ir> {
    static final /* synthetic */ boolean f2199a = (!is.class.desiredAssertionStatus());
    private final MembersInjector<ir> f2200b;

    private is(MembersInjector<ir> membersInjector) {
        if (f2199a || membersInjector != null) {
            this.f2200b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ir> m1986a(MembersInjector<ir> membersInjector) {
        return new is(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ir) MembersInjectors.injectMembers(this.f2200b, new ir());
    }
}
