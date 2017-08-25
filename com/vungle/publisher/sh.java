package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class sh implements Factory<sg> {
    static final /* synthetic */ boolean f3184a = (!sh.class.desiredAssertionStatus());
    private final MembersInjector<sg> f3185b;

    private sh(MembersInjector<sg> membersInjector) {
        if (f3184a || membersInjector != null) {
            this.f3185b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<sg> m2454a(MembersInjector<sg> membersInjector) {
        return new sh(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (sg) MembersInjectors.injectMembers(this.f3185b, new sg());
    }
}
