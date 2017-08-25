package com.vungle.publisher;

import com.vungle.publisher.wy.C1903a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wz implements Factory<C1903a> {
    static final /* synthetic */ boolean f3550a = (!wz.class.desiredAssertionStatus());
    private final MembersInjector<C1903a> f3551b;

    private wz(MembersInjector<C1903a> membersInjector) {
        if (f3550a || membersInjector != null) {
            this.f3551b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1903a> m2595a(MembersInjector<C1903a> membersInjector) {
        return new wz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1903a) MembersInjectors.injectMembers(this.f3551b, new C1903a());
    }
}
