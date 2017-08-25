package com.vungle.publisher;

import com.vungle.publisher.mx.C1823a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class na implements Factory<C1823a> {
    static final /* synthetic */ boolean f2612a = (!na.class.desiredAssertionStatus());
    private final MembersInjector<C1823a> f2613b;

    private na(MembersInjector<C1823a> membersInjector) {
        if (f2612a || membersInjector != null) {
            this.f2613b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1823a> m2186a(MembersInjector<C1823a> membersInjector) {
        return new na(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1823a) MembersInjectors.injectMembers(this.f2613b, new C1823a());
    }
}
