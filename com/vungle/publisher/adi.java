package com.vungle.publisher;

import com.vungle.publisher.adh.C1671a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adi implements Factory<C1671a> {
    static final /* synthetic */ boolean f1130a = (!adi.class.desiredAssertionStatus());
    private final MembersInjector<C1671a> f1131b;

    private adi(MembersInjector<C1671a> membersInjector) {
        if (f1130a || membersInjector != null) {
            this.f1131b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1671a> m1068a(MembersInjector<C1671a> membersInjector) {
        return new adi(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1671a) MembersInjectors.injectMembers(this.f1131b, new C1671a());
    }
}
