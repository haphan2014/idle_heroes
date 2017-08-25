package com.vungle.publisher;

import com.vungle.publisher.aab.C1625a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aac implements Factory<C1625a> {
    static final /* synthetic */ boolean f791a = (!aac.class.desiredAssertionStatus());
    private final MembersInjector<C1625a> f792b;

    private aac(MembersInjector<C1625a> membersInjector) {
        if (f791a || membersInjector != null) {
            this.f792b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1625a> m830a(MembersInjector<C1625a> membersInjector) {
        return new aac(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1625a) MembersInjectors.injectMembers(this.f792b, new C1625a());
    }
}
