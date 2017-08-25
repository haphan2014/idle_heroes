package com.vungle.publisher;

import com.vungle.publisher.ke.C1802a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kg implements Factory<C1802a> {
    static final /* synthetic */ boolean f2361a = (!kg.class.desiredAssertionStatus());
    private final MembersInjector<C1802a> f2362b;

    private kg(MembersInjector<C1802a> membersInjector) {
        if (f2361a || membersInjector != null) {
            this.f2362b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1802a> m2065a(MembersInjector<C1802a> membersInjector) {
        return new kg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1802a) MembersInjectors.injectMembers(this.f2362b, new C1802a());
    }
}
