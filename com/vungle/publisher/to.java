package com.vungle.publisher;

import com.vungle.publisher.tm.C1888a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class to implements Factory<C1888a> {
    static final /* synthetic */ boolean f3317a = (!to.class.desiredAssertionStatus());
    private final MembersInjector<C1888a> f3318b;

    private to(MembersInjector<C1888a> membersInjector) {
        if (f3317a || membersInjector != null) {
            this.f3318b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1888a> m2511a(MembersInjector<C1888a> membersInjector) {
        return new to(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1888a) MembersInjectors.injectMembers(this.f3318b, new C1888a());
    }
}
