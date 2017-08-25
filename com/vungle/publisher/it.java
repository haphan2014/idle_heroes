package com.vungle.publisher;

import com.vungle.publisher.ir.C1793a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class it implements Factory<C1793a> {
    static final /* synthetic */ boolean f2201a = (!it.class.desiredAssertionStatus());
    private final MembersInjector<C1793a> f2202b;

    private it(MembersInjector<C1793a> membersInjector) {
        if (f2201a || membersInjector != null) {
            this.f2202b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1793a> m1987a(MembersInjector<C1793a> membersInjector) {
        return new it(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1793a) MembersInjectors.injectMembers(this.f2202b, new C1793a());
    }
}
