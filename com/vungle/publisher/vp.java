package com.vungle.publisher;

import com.vungle.publisher.vl.C1897a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class vp implements Factory<C1897a> {
    static final /* synthetic */ boolean f3464a = (!vp.class.desiredAssertionStatus());
    private final MembersInjector<C1897a> f3465b;

    private vp(MembersInjector<C1897a> membersInjector) {
        if (f3464a || membersInjector != null) {
            this.f3465b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1897a> m2551a(MembersInjector<C1897a> membersInjector) {
        return new vp(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1897a) MembersInjectors.injectMembers(this.f3465b, new C1897a());
    }
}
