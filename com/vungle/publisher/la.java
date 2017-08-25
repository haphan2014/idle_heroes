package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class la implements Factory<kz> {
    static final /* synthetic */ boolean f2435a = (!la.class.desiredAssertionStatus());
    private final MembersInjector<kz> f2436b;

    private la(MembersInjector<kz> membersInjector) {
        if (f2435a || membersInjector != null) {
            this.f2436b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<kz> m2115a(MembersInjector<kz> membersInjector) {
        return new la(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (kz) MembersInjectors.injectMembers(this.f2436b, new kz());
    }
}
