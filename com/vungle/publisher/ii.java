package com.vungle.publisher;

import com.vungle.publisher.ig.C1790a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ii implements Factory<C1790a> {
    static final /* synthetic */ boolean f2163a = (!ii.class.desiredAssertionStatus());
    private final MembersInjector<C1790a> f2164b;

    private ii(MembersInjector<C1790a> membersInjector) {
        if (f2163a || membersInjector != null) {
            this.f2164b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1790a> m1967a(MembersInjector<C1790a> membersInjector) {
        return new ii(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1790a) MembersInjectors.injectMembers(this.f2164b, new C1790a());
    }
}
