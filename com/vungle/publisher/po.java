package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class po implements Factory<pl> {
    static final /* synthetic */ boolean f2909a = (!po.class.desiredAssertionStatus());
    private final MembersInjector<pl> f2910b;

    private po(MembersInjector<pl> membersInjector) {
        if (f2909a || membersInjector != null) {
            this.f2910b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<pl> m2339a(MembersInjector<pl> membersInjector) {
        return new po(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (pl) MembersInjectors.injectMembers(this.f2910b, new pl());
    }
}
