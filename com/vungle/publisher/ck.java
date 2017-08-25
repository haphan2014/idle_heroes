package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ck implements Factory<cj> {
    static final /* synthetic */ boolean f1500a = (!ck.class.desiredAssertionStatus());
    private final MembersInjector<cj> f1501b;

    private ck(MembersInjector<cj> membersInjector) {
        if (f1500a || membersInjector != null) {
            this.f1501b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<cj> m1250a(MembersInjector<cj> membersInjector) {
        return new ck(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (cj) MembersInjectors.injectMembers(this.f1501b, new cj());
    }
}
