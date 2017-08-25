package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fl implements Factory<fk> {
    static final /* synthetic */ boolean f1903a = (!fl.class.desiredAssertionStatus());
    private final MembersInjector<fk> f1904b;

    private fl(MembersInjector<fk> membersInjector) {
        if (f1903a || membersInjector != null) {
            this.f1904b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<fk> m1784a(MembersInjector<fk> membersInjector) {
        return new fl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (fk) MembersInjectors.injectMembers(this.f1904b, new fk());
    }
}
