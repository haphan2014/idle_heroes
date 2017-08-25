package com.vungle.publisher;

import com.vungle.publisher.he.C1781a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hg implements Factory<C1781a> {
    static final /* synthetic */ boolean f2062a = (!hg.class.desiredAssertionStatus());
    private final MembersInjector<C1781a> f2063b;

    private hg(MembersInjector<C1781a> membersInjector) {
        if (f2062a || membersInjector != null) {
            this.f2063b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1781a> m1895a(MembersInjector<C1781a> membersInjector) {
        return new hg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1781a) MembersInjectors.injectMembers(this.f2063b, new C1781a());
    }
}
