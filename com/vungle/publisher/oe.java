package com.vungle.publisher;

import com.vungle.publisher.oc.C1844a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class oe implements Factory<C1844a> {
    static final /* synthetic */ boolean f2734a = (!oe.class.desiredAssertionStatus());
    private final MembersInjector<C1844a> f2735b;

    private oe(MembersInjector<C1844a> membersInjector) {
        if (f2734a || membersInjector != null) {
            this.f2735b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1844a> m2258a(MembersInjector<C1844a> membersInjector) {
        return new oe(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1844a) MembersInjectors.injectMembers(this.f2735b, new C1844a());
    }
}
