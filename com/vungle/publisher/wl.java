package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wl implements Factory<wk> {
    static final /* synthetic */ boolean f3514a = (!wl.class.desiredAssertionStatus());
    private final MembersInjector<wk> f3515b;

    private wl(MembersInjector<wk> membersInjector) {
        if (f3514a || membersInjector != null) {
            this.f3515b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<wk> m2581a(MembersInjector<wk> membersInjector) {
        return new wl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (wk) MembersInjectors.injectMembers(this.f3515b, new wk());
    }
}
