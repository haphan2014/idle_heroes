package com.vungle.publisher;

import com.vungle.publisher.nl.C1837b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nq implements Factory<C1837b> {
    static final /* synthetic */ boolean f2693a = (!nq.class.desiredAssertionStatus());
    private final MembersInjector<C1837b> f2694b;

    private nq(MembersInjector<C1837b> membersInjector) {
        if (f2693a || membersInjector != null) {
            this.f2694b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1837b> m2236a(MembersInjector<C1837b> membersInjector) {
        return new nq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1837b) MembersInjectors.injectMembers(this.f2694b, new C1837b());
    }
}
