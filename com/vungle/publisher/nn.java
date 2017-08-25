package com.vungle.publisher;

import com.vungle.publisher.nl.C1835a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nn implements Factory<C1835a> {
    static final /* synthetic */ boolean f2676a = (!nn.class.desiredAssertionStatus());
    private final MembersInjector<C1835a> f2677b;

    private nn(MembersInjector<C1835a> membersInjector) {
        if (f2676a || membersInjector != null) {
            this.f2677b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1835a> m2233a(MembersInjector<C1835a> membersInjector) {
        return new nn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1835a) MembersInjectors.injectMembers(this.f2677b, new C1835a());
    }
}
