package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wb implements Factory<wa> {
    static final /* synthetic */ boolean f3494a = (!wb.class.desiredAssertionStatus());
    private final MembersInjector<wa> f3495b;

    private wb(MembersInjector<wa> membersInjector) {
        if (f3494a || membersInjector != null) {
            this.f3495b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<wa> m2567a(MembersInjector<wa> membersInjector) {
        return new wb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (wa) MembersInjectors.injectMembers(this.f3495b, new wa());
    }
}
