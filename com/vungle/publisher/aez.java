package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aez implements Factory<aey> {
    static final /* synthetic */ boolean f1299a = (!aez.class.desiredAssertionStatus());
    private final MembersInjector<aey> f1300b;

    private aez(MembersInjector<aey> membersInjector) {
        if (f1299a || membersInjector != null) {
            this.f1300b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aey> m1161a(MembersInjector<aey> membersInjector) {
        return new aez(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aey) MembersInjectors.injectMembers(this.f1300b, new aey());
    }
}
