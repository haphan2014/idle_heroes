package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gz implements Factory<C1778a> {
    static final /* synthetic */ boolean f2042a = (!gz.class.desiredAssertionStatus());
    private final MembersInjector<C1778a> f2043b;

    private gz(MembersInjector<C1778a> membersInjector) {
        if (f2042a || membersInjector != null) {
            this.f2043b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1778a> m1875a(MembersInjector<C1778a> membersInjector) {
        return new gz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1778a) MembersInjectors.injectMembers(this.f2043b, new C1778a());
    }
}
