package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nv implements Factory<nu> {
    static final /* synthetic */ boolean f2708a = (!nv.class.desiredAssertionStatus());
    private final MembersInjector<nu> f2709b;

    private nv(MembersInjector<nu> membersInjector) {
        if (f2708a || membersInjector != null) {
            this.f2709b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<nu> m2245a(MembersInjector<nu> membersInjector) {
        return new nv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (nu) MembersInjectors.injectMembers(this.f2709b, new nu());
    }
}
