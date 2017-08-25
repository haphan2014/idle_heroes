package com.vungle.publisher;

import com.vungle.publisher.abc.C1641a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abe implements Factory<C1641a> {
    static final /* synthetic */ boolean f927a = (!abe.class.desiredAssertionStatus());
    private final MembersInjector<C1641a> f928b;

    private abe(MembersInjector<C1641a> membersInjector) {
        if (f927a || membersInjector != null) {
            this.f928b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1641a> m926a(MembersInjector<C1641a> membersInjector) {
        return new abe(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1641a) MembersInjectors.injectMembers(this.f928b, new C1641a());
    }
}
