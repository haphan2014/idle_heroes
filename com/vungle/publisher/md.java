package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class md implements Factory<mc> {
    static final /* synthetic */ boolean f2556a = (!md.class.desiredAssertionStatus());
    private final MembersInjector<mc> f2557b;

    private md(MembersInjector<mc> membersInjector) {
        if (f2556a || membersInjector != null) {
            this.f2557b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<mc> m2163a(MembersInjector<mc> membersInjector) {
        return new md(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (mc) MembersInjectors.injectMembers(this.f2557b, new mc());
    }
}
