package com.vungle.publisher;

import com.vungle.publisher.xt.C1915b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class xu implements Factory<C1915b> {
    static final /* synthetic */ boolean f3630a = (!xu.class.desiredAssertionStatus());
    private final MembersInjector<C1915b> f3631b;

    private xu(MembersInjector<C1915b> membersInjector) {
        if (f3630a || membersInjector != null) {
            this.f3631b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1915b> m2632a(MembersInjector<C1915b> membersInjector) {
        return new xu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1915b) MembersInjectors.injectMembers(this.f3631b, new C1915b());
    }
}
