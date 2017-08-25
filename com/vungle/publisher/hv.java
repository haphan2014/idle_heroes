package com.vungle.publisher;

import com.vungle.publisher.ho.C1783a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hv implements Factory<C1783a> {
    static final /* synthetic */ boolean f2102a = (!hv.class.desiredAssertionStatus());
    private final MembersInjector<C1783a> f2103b;

    private hv(MembersInjector<C1783a> membersInjector) {
        if (f2102a || membersInjector != null) {
            this.f2103b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1783a> m1925a(MembersInjector<C1783a> membersInjector) {
        return new hv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1783a) MembersInjectors.injectMembers(this.f2103b, new C1783a());
    }
}
