package com.vungle.publisher;

import com.vungle.publisher.yi.C1918a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yj implements Factory<C1918a> {
    static final /* synthetic */ boolean f3676a = (!yj.class.desiredAssertionStatus());
    private final MembersInjector<C1918a> f3677b;

    private yj(MembersInjector<C1918a> membersInjector) {
        if (f3676a || membersInjector != null) {
            this.f3677b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1918a> m2653a(MembersInjector<C1918a> membersInjector) {
        return new yj(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1918a) MembersInjectors.injectMembers(this.f3677b, new C1918a());
    }
}
