package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aao implements Factory<aan> {
    static final /* synthetic */ boolean f838a = (!aao.class.desiredAssertionStatus());
    private final MembersInjector<aan> f839b;

    private aao(MembersInjector<aan> membersInjector) {
        if (f838a || membersInjector != null) {
            this.f839b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aan> m853a(MembersInjector<aan> membersInjector) {
        return new aao(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aan) MembersInjectors.injectMembers(this.f839b, new aan());
    }
}
