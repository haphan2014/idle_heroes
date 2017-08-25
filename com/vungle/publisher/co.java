package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class co implements Factory<cn> {
    static final /* synthetic */ boolean f1510a = (!co.class.desiredAssertionStatus());
    private final MembersInjector<cn> f1511b;

    private co(MembersInjector<cn> membersInjector) {
        if (f1510a || membersInjector != null) {
            this.f1511b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<cn> m1262a(MembersInjector<cn> membersInjector) {
        return new co(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (cn) MembersInjectors.injectMembers(this.f1511b, new cn());
    }
}
