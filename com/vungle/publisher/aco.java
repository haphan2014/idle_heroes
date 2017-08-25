package com.vungle.publisher;

import com.vungle.publisher.acn.C1660a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aco implements Factory<C1660a> {
    static final /* synthetic */ boolean f1031a = (!aco.class.desiredAssertionStatus());
    private final MembersInjector<C1660a> f1032b;

    private aco(MembersInjector<C1660a> membersInjector) {
        if (f1031a || membersInjector != null) {
            this.f1032b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1660a> m1001a(MembersInjector<C1660a> membersInjector) {
        return new aco(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1660a) MembersInjectors.injectMembers(this.f1032b, new C1660a());
    }
}
