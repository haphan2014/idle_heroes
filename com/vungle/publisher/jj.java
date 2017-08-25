package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jj implements Factory<ie> {
    static final /* synthetic */ boolean f2261a = (!jj.class.desiredAssertionStatus());
    private final MembersInjector<ie> f2262b;

    private jj(MembersInjector<ie> membersInjector) {
        if (f2261a || membersInjector != null) {
            this.f2262b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ie> m2006a(MembersInjector<ie> membersInjector) {
        return new jj(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ie) MembersInjectors.injectMembers(this.f2262b, new ie());
    }
}
