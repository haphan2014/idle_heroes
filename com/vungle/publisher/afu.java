package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afu implements Factory<aft> {
    static final /* synthetic */ boolean f1389a = (!afu.class.desiredAssertionStatus());
    private final MembersInjector<aft> f1390b;

    private afu(MembersInjector<aft> membersInjector) {
        if (f1389a || membersInjector != null) {
            this.f1390b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aft> m1201a(MembersInjector<aft> membersInjector) {
        return new afu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aft) MembersInjectors.injectMembers(this.f1390b, new aft());
    }
}
