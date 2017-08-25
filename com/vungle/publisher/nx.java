package com.vungle.publisher;

import com.vungle.publisher.nu.C1842a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nx implements Factory<C1842a> {
    static final /* synthetic */ boolean f2718a = (!nx.class.desiredAssertionStatus());
    private final MembersInjector<C1842a> f2719b;

    private nx(MembersInjector<C1842a> membersInjector) {
        if (f2718a || membersInjector != null) {
            this.f2719b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1842a> m2247a(MembersInjector<C1842a> membersInjector) {
        return new nx(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1842a) MembersInjectors.injectMembers(this.f2719b, new C1842a());
    }
}
