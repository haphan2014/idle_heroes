package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class qy implements Factory<qx> {
    static final /* synthetic */ boolean f3037a = (!qy.class.desiredAssertionStatus());
    private final MembersInjector<qx> f3038b;

    private qy(MembersInjector<qx> membersInjector) {
        if (f3037a || membersInjector != null) {
            this.f3038b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<qx> m2378a(MembersInjector<qx> membersInjector) {
        return new qy(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (qx) MembersInjectors.injectMembers(this.f3038b, new qx());
    }
}
