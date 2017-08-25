package com.vungle.publisher;

import com.vungle.publisher.li.C1809a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lk implements Factory<C1809a> {
    static final /* synthetic */ boolean f2467a = (!lk.class.desiredAssertionStatus());
    private final MembersInjector<C1809a> f2468b;

    private lk(MembersInjector<C1809a> membersInjector) {
        if (f2467a || membersInjector != null) {
            this.f2468b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1809a> m2127a(MembersInjector<C1809a> membersInjector) {
        return new lk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1809a) MembersInjectors.injectMembers(this.f2468b, new C1809a());
    }
}
