package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ku implements Factory<kt> {
    static final /* synthetic */ boolean f2401a = (!ku.class.desiredAssertionStatus());
    private final MembersInjector<kt> f2402b;

    private ku(MembersInjector<kt> membersInjector) {
        if (f2401a || membersInjector != null) {
            this.f2402b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<kt> m2092a(MembersInjector<kt> membersInjector) {
        return new ku(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (kt) MembersInjectors.injectMembers(this.f2402b, new kt());
    }
}
