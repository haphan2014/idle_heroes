package com.vungle.publisher;

import com.vungle.publisher.ade.C1670a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adf implements Factory<C1670a> {
    static final /* synthetic */ boolean f1120a = (!adf.class.desiredAssertionStatus());
    private final MembersInjector<C1670a> f1121b;

    private adf(MembersInjector<C1670a> membersInjector) {
        if (f1120a || membersInjector != null) {
            this.f1121b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1670a> m1061a(MembersInjector<C1670a> membersInjector) {
        return new adf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1670a) MembersInjectors.injectMembers(this.f1121b, new C1670a());
    }
}
