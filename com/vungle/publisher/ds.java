package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ds implements Factory<dr> {
    static final /* synthetic */ boolean f1691a = (!ds.class.desiredAssertionStatus());
    private final MembersInjector<dr> f1692b;

    private ds(MembersInjector<dr> membersInjector) {
        if (f1691a || membersInjector != null) {
            this.f1692b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<dr> m1538a(MembersInjector<dr> membersInjector) {
        return new ds(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (dr) MembersInjectors.injectMembers(this.f1692b, new dr());
    }
}
