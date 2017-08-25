package com.vungle.publisher;

import com.vungle.publisher.hp.C1784a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hr implements Factory<C1784a> {
    static final /* synthetic */ boolean f2092a = (!hr.class.desiredAssertionStatus());
    private final MembersInjector<C1784a> f2093b;

    private hr(MembersInjector<C1784a> membersInjector) {
        if (f2092a || membersInjector != null) {
            this.f2093b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1784a> m1921a(MembersInjector<C1784a> membersInjector) {
        return new hr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1784a) MembersInjectors.injectMembers(this.f2093b, new C1784a());
    }
}
