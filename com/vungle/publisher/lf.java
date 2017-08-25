package com.vungle.publisher;

import com.vungle.publisher.ky.C1806a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lf implements Factory<C1806a> {
    static final /* synthetic */ boolean f2447a = (!lf.class.desiredAssertionStatus());
    private final MembersInjector<C1806a> f2448b;

    private lf(MembersInjector<C1806a> membersInjector) {
        if (f2447a || membersInjector != null) {
            this.f2448b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1806a> m2120a(MembersInjector<C1806a> membersInjector) {
        return new lf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1806a) MembersInjectors.injectMembers(this.f2448b, new C1806a());
    }
}
