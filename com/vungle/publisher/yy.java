package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yy implements Factory<yx> {
    static final /* synthetic */ boolean f3729a = (!yy.class.desiredAssertionStatus());
    private final MembersInjector<yx> f3730b;

    private yy(MembersInjector<yx> membersInjector) {
        if (f3729a || membersInjector != null) {
            this.f3730b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<yx> m2676a(MembersInjector<yx> membersInjector) {
        return new yy(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (yx) MembersInjectors.injectMembers(this.f3730b, new yx());
    }
}
