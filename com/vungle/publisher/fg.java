package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fg implements Factory<ff> {
    static final /* synthetic */ boolean f1891a = (!fg.class.desiredAssertionStatus());
    private final MembersInjector<ff> f1892b;

    private fg(MembersInjector<ff> membersInjector) {
        if (f1891a || membersInjector != null) {
            this.f1892b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ff> m1775a(MembersInjector<ff> membersInjector) {
        return new fg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ff) MembersInjectors.injectMembers(this.f1892b, new ff());
    }
}
