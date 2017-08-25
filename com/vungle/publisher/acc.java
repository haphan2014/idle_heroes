package com.vungle.publisher;

import com.vungle.publisher.abx.C1655a.C1653a.C1651a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class acc implements Factory<C1651a> {
    static final /* synthetic */ boolean f996a = (!acc.class.desiredAssertionStatus());
    private final MembersInjector<C1651a> f997b;

    private acc(MembersInjector<C1651a> membersInjector) {
        if (f996a || membersInjector != null) {
            this.f997b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1651a> m980a(MembersInjector<C1651a> membersInjector) {
        return new acc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1651a) MembersInjectors.injectMembers(this.f997b, new C1651a());
    }
}
