package com.vungle.publisher;

import com.vungle.publisher.su.C1876a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class sw implements Factory<C1876a> {
    static final /* synthetic */ boolean f3218a = (!sw.class.desiredAssertionStatus());
    private final MembersInjector<C1876a> f3219b;

    private sw(MembersInjector<C1876a> membersInjector) {
        if (f3218a || membersInjector != null) {
            this.f3219b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1876a> m2484a(MembersInjector<C1876a> membersInjector) {
        return new sw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1876a) MembersInjectors.injectMembers(this.f3219b, new C1876a());
    }
}
