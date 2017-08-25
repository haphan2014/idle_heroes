package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class de implements Factory<dd> {
    static final /* synthetic */ boolean f1635a = (!de.class.desiredAssertionStatus());
    private final MembersInjector<dd> f1636b;

    private de(MembersInjector<dd> membersInjector) {
        if (f1635a || membersInjector != null) {
            this.f1636b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<dd> m1455a(MembersInjector<dd> membersInjector) {
        return new de(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (dd) MembersInjectors.injectMembers(this.f1636b, new dd());
    }
}
