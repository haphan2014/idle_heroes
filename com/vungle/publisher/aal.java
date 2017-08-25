package com.vungle.publisher;

import com.vungle.publisher.aak.C1627a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aal implements Factory<C1627a> {
    static final /* synthetic */ boolean f827a = (!aal.class.desiredAssertionStatus());
    private final MembersInjector<C1627a> f828b;

    private aal(MembersInjector<C1627a> membersInjector) {
        if (f827a || membersInjector != null) {
            this.f828b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1627a> m850a(MembersInjector<C1627a> membersInjector) {
        return new aal(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1627a) MembersInjectors.injectMembers(this.f828b, new C1627a());
    }
}
