package com.vungle.publisher;

import com.vungle.publisher.dm.C1734a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1735do implements Factory<C1734a> {
    static final /* synthetic */ boolean f1668a = (!C1735do.class.desiredAssertionStatus());
    private final MembersInjector<C1734a> f1669b;

    private C1735do(MembersInjector<C1734a> membersInjector) {
        if (f1668a || membersInjector != null) {
            this.f1669b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1734a> m1479a(MembersInjector<C1734a> membersInjector) {
        return new C1735do(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1734a) MembersInjectors.injectMembers(this.f1669b, new C1734a());
    }
}
