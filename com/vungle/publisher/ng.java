package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ng implements Factory<nf> {
    static final /* synthetic */ boolean f2630a = (!ng.class.desiredAssertionStatus());
    private final MembersInjector<nf> f2631b;

    private ng(MembersInjector<nf> membersInjector) {
        if (f2630a || membersInjector != null) {
            this.f2631b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<nf> m2196a(MembersInjector<nf> membersInjector) {
        return new ng(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (nf) MembersInjectors.injectMembers(this.f2631b, new nf());
    }
}
