package com.vungle.publisher;

import com.vungle.publisher.iq.C1792a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ix implements Factory<C1792a> {
    static final /* synthetic */ boolean f2211a = (!ix.class.desiredAssertionStatus());
    private final MembersInjector<C1792a> f2212b;

    private ix(MembersInjector<C1792a> membersInjector) {
        if (f2211a || membersInjector != null) {
            this.f2212b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1792a> m1991a(MembersInjector<C1792a> membersInjector) {
        return new ix(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1792a) MembersInjectors.injectMembers(this.f2212b, new C1792a());
    }
}
