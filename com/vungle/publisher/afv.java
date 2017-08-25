package com.vungle.publisher;

import com.vungle.publisher.aft.C1704a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afv implements Factory<C1704a> {
    static final /* synthetic */ boolean f1391a = (!afv.class.desiredAssertionStatus());
    private final MembersInjector<C1704a> f1392b;

    private afv(MembersInjector<C1704a> membersInjector) {
        if (f1391a || membersInjector != null) {
            this.f1392b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1704a> m1202a(MembersInjector<C1704a> membersInjector) {
        return new afv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1704a) MembersInjectors.injectMembers(this.f1392b, new C1704a());
    }
}
