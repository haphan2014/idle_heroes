package com.vungle.publisher;

import com.vungle.publisher.aeh.C1680a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aei implements Factory<C1680a> {
    static final /* synthetic */ boolean f1222a = (!aei.class.desiredAssertionStatus());
    private final MembersInjector<C1680a> f1223b;

    private aei(MembersInjector<C1680a> membersInjector) {
        if (f1222a || membersInjector != null) {
            this.f1223b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1680a> m1141a(MembersInjector<C1680a> membersInjector) {
        return new aei(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1680a) MembersInjectors.injectMembers(this.f1223b, new C1680a());
    }
}
