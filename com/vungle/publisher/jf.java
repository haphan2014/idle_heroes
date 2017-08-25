package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jf implements Factory<C1789if> {
    static final /* synthetic */ boolean f2246a = (!jf.class.desiredAssertionStatus());
    private final MembersInjector<C1789if> f2247b;

    private jf(MembersInjector<C1789if> membersInjector) {
        if (f2246a || membersInjector != null) {
            this.f2247b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1789if> m2002a(MembersInjector<C1789if> membersInjector) {
        return new jf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1789if) MembersInjectors.injectMembers(this.f2247b, new C1789if());
    }
}
