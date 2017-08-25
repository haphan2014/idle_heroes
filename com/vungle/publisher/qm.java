package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class qm implements Factory<ql> {
    static final /* synthetic */ boolean f3014a = (!qm.class.desiredAssertionStatus());
    private final MembersInjector<ql> f3015b;

    private qm(MembersInjector<ql> membersInjector) {
        if (f3014a || membersInjector != null) {
            this.f3015b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ql> m2364a(MembersInjector<ql> membersInjector) {
        return new qm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ql) MembersInjectors.injectMembers(this.f3015b, new ql());
    }
}
