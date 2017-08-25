package com.vungle.publisher;

import com.vungle.publisher.lr.C1811a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lt implements Factory<C1811a> {
    static final /* synthetic */ boolean f2499a = (!lt.class.desiredAssertionStatus());
    private final MembersInjector<C1811a> f2500b;

    private lt(MembersInjector<C1811a> membersInjector) {
        if (f2499a || membersInjector != null) {
            this.f2500b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1811a> m2144a(MembersInjector<C1811a> membersInjector) {
        return new lt(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1811a) MembersInjectors.injectMembers(this.f2500b, new C1811a());
    }
}
