package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1859p implements Factory<C1821m> {
    static final /* synthetic */ boolean f2866a = (!C1859p.class.desiredAssertionStatus());
    private final MembersInjector<C1821m> f2867b;

    private C1859p(MembersInjector<C1821m> membersInjector) {
        if (f2866a || membersInjector != null) {
            this.f2867b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1821m> m2316a(MembersInjector<C1821m> membersInjector) {
        return new C1859p(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1821m) MembersInjectors.injectMembers(this.f2867b, new C1821m());
    }
}
