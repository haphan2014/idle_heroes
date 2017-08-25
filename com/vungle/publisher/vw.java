package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class vw implements Factory<vv> {
    static final /* synthetic */ boolean f3482a = (!vw.class.desiredAssertionStatus());
    private final MembersInjector<vv> f3483b;

    private vw(MembersInjector<vv> membersInjector) {
        if (f3482a || membersInjector != null) {
            this.f3483b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<vv> m2562a(MembersInjector<vv> membersInjector) {
        return new vw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (vv) MembersInjectors.injectMembers(this.f3483b, new vv());
    }
}
