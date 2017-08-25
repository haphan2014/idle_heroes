package com.vungle.publisher;

import com.vungle.publisher.afd.C1699a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afe implements Factory<C1699a> {
    static final /* synthetic */ boolean f1320a = (!afe.class.desiredAssertionStatus());
    private final MembersInjector<C1699a> f1321b;

    private afe(MembersInjector<C1699a> membersInjector) {
        if (f1320a || membersInjector != null) {
            this.f1321b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1699a> m1167a(MembersInjector<C1699a> membersInjector) {
        return new afe(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1699a) MembersInjectors.injectMembers(this.f1321b, new C1699a());
    }
}
