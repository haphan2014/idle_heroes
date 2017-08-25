package com.vungle.publisher;

import com.vungle.publisher.adq.C1675a.C1674a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adr implements Factory<C1674a> {
    static final /* synthetic */ boolean f1164a = (!adr.class.desiredAssertionStatus());
    private final MembersInjector<C1674a> f1165b;

    private adr(MembersInjector<C1674a> membersInjector) {
        if (f1164a || membersInjector != null) {
            this.f1165b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1674a> m1098a(MembersInjector<C1674a> membersInjector) {
        return new adr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1674a) MembersInjectors.injectMembers(this.f1165b, new C1674a());
    }
}
