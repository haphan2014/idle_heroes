package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class agk implements Factory<agj> {
    static final /* synthetic */ boolean f1408a = (!agk.class.desiredAssertionStatus());
    private final MembersInjector<agj> f1409b;

    private agk(MembersInjector<agj> membersInjector) {
        if (f1408a || membersInjector != null) {
            this.f1409b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<agj> m1230a(MembersInjector<agj> membersInjector) {
        return new agk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (agj) MembersInjectors.injectMembers(this.f1409b, new agj());
    }
}
