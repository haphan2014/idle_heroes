package com.vungle.publisher;

import com.vungle.publisher.acs.C1663a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class act implements Factory<C1663a> {
    static final /* synthetic */ boolean f1056a = (!act.class.desiredAssertionStatus());
    private final MembersInjector<C1663a> f1057b;

    private act(MembersInjector<C1663a> membersInjector) {
        if (f1056a || membersInjector != null) {
            this.f1057b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1663a> m1016a(MembersInjector<C1663a> membersInjector) {
        return new act(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1663a) MembersInjectors.injectMembers(this.f1057b, new C1663a());
    }
}
