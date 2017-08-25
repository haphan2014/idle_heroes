package com.vungle.publisher;

import com.vungle.publisher.kz.C1807a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lb implements Factory<C1807a> {
    static final /* synthetic */ boolean f2437a = (!lb.class.desiredAssertionStatus());
    private final MembersInjector<C1807a> f2438b;

    private lb(MembersInjector<C1807a> membersInjector) {
        if (f2437a || membersInjector != null) {
            this.f2438b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1807a> m2116a(MembersInjector<C1807a> membersInjector) {
        return new lb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1807a) MembersInjectors.injectMembers(this.f2438b, new C1807a());
    }
}
