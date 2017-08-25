package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class tn implements Factory<tm> {
    static final /* synthetic */ boolean f3315a = (!tn.class.desiredAssertionStatus());
    private final MembersInjector<tm> f3316b;

    private tn(MembersInjector<tm> membersInjector) {
        if (f3315a || membersInjector != null) {
            this.f3316b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<tm> m2510a(MembersInjector<tm> membersInjector) {
        return new tn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (tm) MembersInjectors.injectMembers(this.f3316b, new tm());
    }
}
