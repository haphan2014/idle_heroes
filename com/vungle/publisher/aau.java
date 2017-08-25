package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aau implements Factory<C1628a> {
    static final /* synthetic */ boolean f897a = (!aau.class.desiredAssertionStatus());
    private final MembersInjector<C1628a> f898b;

    private aau(MembersInjector<C1628a> membersInjector) {
        if (f897a || membersInjector != null) {
            this.f898b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1628a> m887a(MembersInjector<C1628a> membersInjector) {
        return new aau(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1628a) MembersInjectors.injectMembers(this.f898b, new C1628a());
    }
}
