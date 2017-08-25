package com.vungle.publisher;

import com.vungle.publisher.il.C1791a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class in implements Factory<C1791a> {
    static final /* synthetic */ boolean f2176a = (!in.class.desiredAssertionStatus());
    private final MembersInjector<C1791a> f2177b;

    private in(MembersInjector<C1791a> membersInjector) {
        if (f2176a || membersInjector != null) {
            this.f2177b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1791a> m1973a(MembersInjector<C1791a> membersInjector) {
        return new in(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1791a) MembersInjectors.injectMembers(this.f2177b, new C1791a());
    }
}
