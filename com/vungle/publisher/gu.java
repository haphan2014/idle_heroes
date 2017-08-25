package com.vungle.publisher;

import com.vungle.publisher.gs.C1777a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gu implements Factory<C1777a> {
    static final /* synthetic */ boolean f2020a = (!gu.class.desiredAssertionStatus());
    private final MembersInjector<C1777a> f2021b;

    private gu(MembersInjector<C1777a> membersInjector) {
        if (f2020a || membersInjector != null) {
            this.f2021b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1777a> m1856a(MembersInjector<C1777a> membersInjector) {
        return new gu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1777a) MembersInjectors.injectMembers(this.f2021b, new C1777a());
    }
}
