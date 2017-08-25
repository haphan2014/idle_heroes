package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class vs implements Factory<vr> {
    static final /* synthetic */ boolean f3473a = (!vs.class.desiredAssertionStatus());
    private final MembersInjector<vr> f3474b;

    private vs(MembersInjector<vr> membersInjector) {
        if (f3473a || membersInjector != null) {
            this.f3474b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<vr> m2554a(MembersInjector<vr> membersInjector) {
        return new vs(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (vr) MembersInjectors.injectMembers(this.f3474b, new vr());
    }
}
