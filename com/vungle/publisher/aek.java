package com.vungle.publisher;

import com.vungle.publisher.aej.C1682a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aek implements Factory<C1682a> {
    static final /* synthetic */ boolean f1225a = (!aek.class.desiredAssertionStatus());
    private final MembersInjector<C1682a> f1226b;

    private aek(MembersInjector<C1682a> membersInjector) {
        if (f1225a || membersInjector != null) {
            this.f1226b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1682a> m1144a(MembersInjector<C1682a> membersInjector) {
        return new aek(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1682a) MembersInjectors.injectMembers(this.f1226b, new C1682a());
    }
}
