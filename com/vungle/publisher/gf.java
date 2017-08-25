package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gf implements Factory<ge> {
    static final /* synthetic */ boolean f1971a = (!gf.class.desiredAssertionStatus());
    private final MembersInjector<ge> f1972b;

    private gf(MembersInjector<ge> membersInjector) {
        if (f1971a || membersInjector != null) {
            this.f1972b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ge> m1829a(MembersInjector<ge> membersInjector) {
        return new gf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ge) MembersInjectors.injectMembers(this.f1972b, new ge());
    }
}
