package com.vungle.publisher;

import com.vungle.publisher.tb.C1879a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class tc implements Factory<C1879a> {
    static final /* synthetic */ boolean f3249a = (!tc.class.desiredAssertionStatus());
    private final MembersInjector<C1879a> f3250b;

    private tc(MembersInjector<C1879a> membersInjector) {
        if (f3249a || membersInjector != null) {
            this.f3250b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1879a> m2491a(MembersInjector<C1879a> membersInjector) {
        return new tc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1879a) MembersInjectors.injectMembers(this.f3250b, new C1879a());
    }
}
