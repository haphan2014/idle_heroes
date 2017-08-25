package com.vungle.publisher;

import com.vungle.publisher.zv.C1927a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zw implements Factory<C1927a> {
    static final /* synthetic */ boolean f3817a = (!zw.class.desiredAssertionStatus());
    private final MembersInjector<C1927a> f3818b;

    private zw(MembersInjector<C1927a> membersInjector) {
        if (f3817a || membersInjector != null) {
            this.f3818b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1927a> m2725a(MembersInjector<C1927a> membersInjector) {
        return new zw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1927a) MembersInjectors.injectMembers(this.f3818b, new C1927a());
    }
}
