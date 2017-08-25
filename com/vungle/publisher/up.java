package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class up implements Factory<uo> {
    static final /* synthetic */ boolean f3383a = (!up.class.desiredAssertionStatus());
    private final MembersInjector<uo> f3384b;

    private up(MembersInjector<uo> membersInjector) {
        if (f3383a || membersInjector != null) {
            this.f3384b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<uo> m2527a(MembersInjector<uo> membersInjector) {
        return new up(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (uo) MembersInjectors.injectMembers(this.f3384b, new uo());
    }
}
