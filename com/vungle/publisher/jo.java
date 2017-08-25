package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jo implements Factory<jn> {
    static final /* synthetic */ boolean f2280a = (!jo.class.desiredAssertionStatus());
    private final MembersInjector<jn> f2281b;

    private jo(MembersInjector<jn> membersInjector) {
        if (f2280a || membersInjector != null) {
            this.f2281b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<jn> m2026a(MembersInjector<jn> membersInjector) {
        return new jo(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (jn) MembersInjectors.injectMembers(this.f2281b, new jn());
    }
}
