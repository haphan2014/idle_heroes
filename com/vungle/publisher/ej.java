package com.vungle.publisher;

import com.vungle.publisher.ei.C1747b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ej implements Factory<C1747b> {
    static final /* synthetic */ boolean f1749a = (!ej.class.desiredAssertionStatus());
    private final MembersInjector<C1747b> f1750b;

    private ej(MembersInjector<C1747b> membersInjector) {
        if (f1749a || membersInjector != null) {
            this.f1750b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1747b> m1584a(MembersInjector<C1747b> membersInjector) {
        return new ej(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1747b) MembersInjectors.injectMembers(this.f1750b, new C1747b());
    }
}
