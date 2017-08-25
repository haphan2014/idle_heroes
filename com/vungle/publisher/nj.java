package com.vungle.publisher;

import com.vungle.publisher.ni.C1832a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nj implements Factory<C1832a> {
    static final /* synthetic */ boolean f2648a = (!nj.class.desiredAssertionStatus());
    private final MembersInjector<C1832a> f2649b;

    private nj(MembersInjector<C1832a> membersInjector) {
        if (f2648a || membersInjector != null) {
            this.f2649b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1832a> m2210a(MembersInjector<C1832a> membersInjector) {
        return new nj(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1832a) MembersInjectors.injectMembers(this.f2649b, new C1832a());
    }
}
