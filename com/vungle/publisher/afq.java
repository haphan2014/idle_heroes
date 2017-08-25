package com.vungle.publisher;

import com.vungle.publisher.afo.C1703a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afq implements Factory<C1703a> {
    static final /* synthetic */ boolean f1374a = (!afq.class.desiredAssertionStatus());
    private final MembersInjector<C1703a> f1375b;

    private afq(MembersInjector<C1703a> membersInjector) {
        if (f1374a || membersInjector != null) {
            this.f1375b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1703a> m1196a(MembersInjector<C1703a> membersInjector) {
        return new afq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1703a) MembersInjectors.injectMembers(this.f1375b, new C1703a());
    }
}
