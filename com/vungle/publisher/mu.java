package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class mu implements Factory<mt> {
    static final /* synthetic */ boolean f2587a = (!mu.class.desiredAssertionStatus());
    private final MembersInjector<mt> f2588b;

    private mu(MembersInjector<mt> membersInjector) {
        if (f2587a || membersInjector != null) {
            this.f2588b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<mt> m2173a(MembersInjector<mt> membersInjector) {
        return new mu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (mt) MembersInjectors.injectMembers(this.f2588b, new mt());
    }
}
