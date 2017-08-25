package com.vungle.publisher;

import com.vungle.publisher.aat.C1636b.C1633a.C1632a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aay implements Factory<C1632a> {
    static final /* synthetic */ boolean f907a = (!aay.class.desiredAssertionStatus());
    private final MembersInjector<C1632a> f908b;

    private aay(MembersInjector<C1632a> membersInjector) {
        if (f907a || membersInjector != null) {
            this.f908b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1632a> m891a(MembersInjector<C1632a> membersInjector) {
        return new aay(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1632a) MembersInjectors.injectMembers(this.f908b, new C1632a());
    }
}
