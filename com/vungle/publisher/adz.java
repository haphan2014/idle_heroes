package com.vungle.publisher;

import com.vungle.publisher.ady.C1678a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adz implements Factory<C1678a> {
    static final /* synthetic */ boolean f1195a = (!adz.class.desiredAssertionStatus());
    private final MembersInjector<C1678a> f1196b;

    private adz(MembersInjector<C1678a> membersInjector) {
        if (f1195a || membersInjector != null) {
            this.f1196b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1678a> m1113a(MembersInjector<C1678a> membersInjector) {
        return new adz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1678a) MembersInjectors.injectMembers(this.f1196b, new C1678a());
    }
}
