package com.vungle.publisher;

import com.vungle.publisher.aec.C1679a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aed implements Factory<C1679a> {
    static final /* synthetic */ boolean f1213a = (!aed.class.desiredAssertionStatus());
    private final MembersInjector<C1679a> f1214b;

    private aed(MembersInjector<C1679a> membersInjector) {
        if (f1213a || membersInjector != null) {
            this.f1214b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1679a> m1133a(MembersInjector<C1679a> membersInjector) {
        return new aed(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1679a) MembersInjectors.injectMembers(this.f1214b, new C1679a());
    }
}
