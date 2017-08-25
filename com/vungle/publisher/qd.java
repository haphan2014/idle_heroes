package com.vungle.publisher;

import com.vungle.publisher.qb.C1868a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class qd implements Factory<C1868a> {
    static final /* synthetic */ boolean f3000a = (!qd.class.desiredAssertionStatus());
    private final MembersInjector<C1868a> f3001b;

    private qd(MembersInjector<C1868a> membersInjector) {
        if (f3000a || membersInjector != null) {
            this.f3001b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1868a> m2358a(MembersInjector<C1868a> membersInjector) {
        return new qd(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1868a) MembersInjectors.injectMembers(this.f3001b, new C1868a());
    }
}
