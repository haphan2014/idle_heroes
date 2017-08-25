package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lj implements Factory<li> {
    static final /* synthetic */ boolean f2465a = (!lj.class.desiredAssertionStatus());
    private final MembersInjector<li> f2466b;

    private lj(MembersInjector<li> membersInjector) {
        if (f2465a || membersInjector != null) {
            this.f2466b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<li> m2126a(MembersInjector<li> membersInjector) {
        return new lj(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (li) MembersInjectors.injectMembers(this.f2466b, new li());
    }
}
