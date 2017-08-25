package com.vungle.publisher;

import com.vungle.publisher.acg.C1659a.C1658a.C1657a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class acl implements Factory<C1657a> {
    static final /* synthetic */ boolean f1027a = (!acl.class.desiredAssertionStatus());
    private final MembersInjector<C1657a> f1028b;

    private acl(MembersInjector<C1657a> membersInjector) {
        if (f1027a || membersInjector != null) {
            this.f1028b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1657a> m994a(MembersInjector<C1657a> membersInjector) {
        return new acl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1657a) MembersInjectors.injectMembers(this.f1028b, new C1657a());
    }
}
