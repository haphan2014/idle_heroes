package com.vungle.publisher;

import com.vungle.publisher.zp.C1926a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zq implements Factory<C1926a> {
    static final /* synthetic */ boolean f3798a = (!zq.class.desiredAssertionStatus());
    private final MembersInjector<C1926a> f3799b;

    private zq(MembersInjector<C1926a> membersInjector) {
        if (f3798a || membersInjector != null) {
            this.f3799b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1926a> m2716a(MembersInjector<C1926a> membersInjector) {
        return new zq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1926a) MembersInjectors.injectMembers(this.f3799b, new C1926a());
    }
}
