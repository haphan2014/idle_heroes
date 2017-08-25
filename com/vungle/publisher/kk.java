package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kk implements Factory<kj> {
    static final /* synthetic */ boolean f2376a = (!kk.class.desiredAssertionStatus());
    private final MembersInjector<kj> f2377b;

    private kk(MembersInjector<kj> membersInjector) {
        if (f2376a || membersInjector != null) {
            this.f2377b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<kj> m2069a(MembersInjector<kj> membersInjector) {
        return new kk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (kj) MembersInjectors.injectMembers(this.f2377b, new kj());
    }
}
