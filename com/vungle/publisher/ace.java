package com.vungle.publisher;

import com.vungle.publisher.acd.C1656a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ace implements Factory<C1656a> {
    static final /* synthetic */ boolean f999a = (!ace.class.desiredAssertionStatus());
    private final MembersInjector<C1656a> f1000b;

    private ace(MembersInjector<C1656a> membersInjector) {
        if (f999a || membersInjector != null) {
            this.f1000b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1656a> m984a(MembersInjector<C1656a> membersInjector) {
        return new ace(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1656a) MembersInjectors.injectMembers(this.f1000b, new C1656a());
    }
}
