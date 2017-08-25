package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class mr implements Factory<mq> {
    static final /* synthetic */ boolean f2582a = (!mr.class.desiredAssertionStatus());
    private final MembersInjector<mq> f2583b;

    private mr(MembersInjector<mq> membersInjector) {
        if (f2582a || membersInjector != null) {
            this.f2583b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<mq> m2169a(MembersInjector<mq> membersInjector) {
        return new mr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (mq) MembersInjectors.injectMembers(this.f2583b, new mq());
    }
}
