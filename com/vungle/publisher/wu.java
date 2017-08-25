package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wu implements Factory<wt> {
    static final /* synthetic */ boolean f3538a = (!wu.class.desiredAssertionStatus());
    private final MembersInjector<wt> f3539b;

    private wu(MembersInjector<wt> membersInjector) {
        if (f3538a || membersInjector != null) {
            this.f3539b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<wt> m2590a(MembersInjector<wt> membersInjector) {
        return new wu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (wt) MembersInjectors.injectMembers(this.f3539b, new wt());
    }
}
