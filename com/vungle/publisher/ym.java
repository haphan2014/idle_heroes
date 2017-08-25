package com.vungle.publisher;

import com.vungle.publisher.yl.C1919a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ym implements Factory<C1919a> {
    static final /* synthetic */ boolean f3687a = (!ym.class.desiredAssertionStatus());
    private final MembersInjector<C1919a> f3688b;

    private ym(MembersInjector<C1919a> membersInjector) {
        if (f3687a || membersInjector != null) {
            this.f3688b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1919a> m2658a(MembersInjector<C1919a> membersInjector) {
        return new ym(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1919a) MembersInjectors.injectMembers(this.f3688b, new C1919a());
    }
}
