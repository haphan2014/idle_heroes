package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kp implements Factory<ko> {
    static final /* synthetic */ boolean f2388a = (!kp.class.desiredAssertionStatus());
    private final MembersInjector<ko> f2389b;

    private kp(MembersInjector<ko> membersInjector) {
        if (f2388a || membersInjector != null) {
            this.f2389b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ko> m2082a(MembersInjector<ko> membersInjector) {
        return new kp(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ko) MembersInjectors.injectMembers(this.f2389b, new ko());
    }
}
