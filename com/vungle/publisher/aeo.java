package com.vungle.publisher;

import com.vungle.publisher.aen.C1683a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aeo implements Factory<C1683a> {
    static final /* synthetic */ boolean f1232a = (!aeo.class.desiredAssertionStatus());
    private final MembersInjector<C1683a> f1233b;

    private aeo(MembersInjector<C1683a> membersInjector) {
        if (f1232a || membersInjector != null) {
            this.f1233b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1683a> m1150a(MembersInjector<C1683a> membersInjector) {
        return new aeo(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1683a) MembersInjectors.injectMembers(this.f1233b, new C1683a());
    }
}
