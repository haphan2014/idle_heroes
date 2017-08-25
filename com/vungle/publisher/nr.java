package com.vungle.publisher;

import com.vungle.publisher.nl.C1837b.C1836a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nr implements Factory<C1836a> {
    static final /* synthetic */ boolean f2695a = (!nr.class.desiredAssertionStatus());
    private final MembersInjector<C1836a> f2696b;

    private nr(MembersInjector<C1836a> membersInjector) {
        if (f2695a || membersInjector != null) {
            this.f2696b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1836a> m2237a(MembersInjector<C1836a> membersInjector) {
        return new nr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1836a) MembersInjectors.injectMembers(this.f2696b, new C1836a());
    }
}
