package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abt implements Factory<abs> {
    static final /* synthetic */ boolean f968a = (!abt.class.desiredAssertionStatus());
    private final MembersInjector<abs> f969b;

    private abt(MembersInjector<abs> membersInjector) {
        if (f968a || membersInjector != null) {
            this.f969b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<abs> m962a(MembersInjector<abs> membersInjector) {
        return new abt(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (abs) MembersInjectors.injectMembers(this.f969b, new abs());
    }
}
