package com.vungle.publisher;

import com.vungle.publisher.C1821m.C1819b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1870r implements Factory<C1819b> {
    static final /* synthetic */ boolean f3041a = (!C1870r.class.desiredAssertionStatus());
    private final MembersInjector<C1819b> f3042b;

    private C1870r(MembersInjector<C1819b> membersInjector) {
        if (f3041a || membersInjector != null) {
            this.f3042b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1819b> m2380a(MembersInjector<C1819b> membersInjector) {
        return new C1870r(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1819b) MembersInjectors.injectMembers(this.f3042b, new C1819b());
    }
}
