package com.vungle.publisher;

import com.vungle.publisher.adn.C1673a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ado implements Factory<C1673a> {
    static final /* synthetic */ boolean f1152a = (!ado.class.desiredAssertionStatus());
    private final MembersInjector<C1673a> f1153b;

    private ado(MembersInjector<C1673a> membersInjector) {
        if (f1152a || membersInjector != null) {
            this.f1153b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1673a> m1085a(MembersInjector<C1673a> membersInjector) {
        return new ado(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1673a) MembersInjectors.injectMembers(this.f1153b, new C1673a());
    }
}
