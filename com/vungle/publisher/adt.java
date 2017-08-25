package com.vungle.publisher;

import com.vungle.publisher.ads.C1676a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adt implements Factory<C1676a> {
    static final /* synthetic */ boolean f1174a = (!adt.class.desiredAssertionStatus());
    private final MembersInjector<C1676a> f1175b;

    private adt(MembersInjector<C1676a> membersInjector) {
        if (f1174a || membersInjector != null) {
            this.f1175b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1676a> m1104a(MembersInjector<C1676a> membersInjector) {
        return new adt(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1676a) MembersInjectors.injectMembers(this.f1175b, new C1676a());
    }
}
