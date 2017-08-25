package com.vungle.publisher;

import com.vungle.publisher.hj.C1782a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hl implements Factory<C1782a> {
    static final /* synthetic */ boolean f2075a = (!hl.class.desiredAssertionStatus());
    private final MembersInjector<C1782a> f2076b;

    private hl(MembersInjector<C1782a> membersInjector) {
        if (f2075a || membersInjector != null) {
            this.f2076b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1782a> m1905a(MembersInjector<C1782a> membersInjector) {
        return new hl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1782a) MembersInjectors.injectMembers(this.f2076b, new C1782a());
    }
}
