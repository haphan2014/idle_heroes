package com.vungle.publisher;

import com.vungle.publisher.dr.C1737a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class dt implements Factory<C1737a> {
    static final /* synthetic */ boolean f1693a = (!dt.class.desiredAssertionStatus());
    private final MembersInjector<C1737a> f1694b;

    private dt(MembersInjector<C1737a> membersInjector) {
        if (f1693a || membersInjector != null) {
            this.f1694b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1737a> m1539a(MembersInjector<C1737a> membersInjector) {
        return new dt(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1737a) MembersInjectors.injectMembers(this.f1694b, new C1737a());
    }
}
