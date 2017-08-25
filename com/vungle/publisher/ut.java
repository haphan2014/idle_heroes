package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ut implements Factory<us> {
    static final /* synthetic */ boolean f3390a = (!ut.class.desiredAssertionStatus());
    private final MembersInjector<us> f3391b;

    private ut(MembersInjector<us> membersInjector) {
        if (f3390a || membersInjector != null) {
            this.f3391b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<us> m2529a(MembersInjector<us> membersInjector) {
        return new ut(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (us) MembersInjectors.injectMembers(this.f3391b, new us());
    }
}
