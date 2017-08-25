package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wp implements Factory<wo> {
    static final /* synthetic */ boolean f3526a = (!wp.class.desiredAssertionStatus());
    private final MembersInjector<wo> f3527b;

    private wp(MembersInjector<wo> membersInjector) {
        if (f3526a || membersInjector != null) {
            this.f3527b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<wo> m2585a(MembersInjector<wo> membersInjector) {
        return new wp(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (wo) MembersInjectors.injectMembers(this.f3527b, new wo());
    }
}
