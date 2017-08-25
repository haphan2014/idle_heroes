package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ga implements Factory<fu> {
    static final /* synthetic */ boolean f1948a = (!ga.class.desiredAssertionStatus());
    private final MembersInjector<fu> f1949b;

    private ga(MembersInjector<fu> membersInjector) {
        if (f1948a || membersInjector != null) {
            this.f1949b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<fu> m1813a(MembersInjector<fu> membersInjector) {
        return new ga(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (fu) MembersInjectors.injectMembers(this.f1949b, new fu());
    }
}
