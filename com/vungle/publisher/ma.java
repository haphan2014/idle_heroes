package com.vungle.publisher;

import com.vungle.publisher.ly.C1813a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ma implements Factory<C1813a> {
    static final /* synthetic */ boolean f2550a = (!ma.class.desiredAssertionStatus());
    private final MembersInjector<C1813a> f2551b;

    private ma(MembersInjector<C1813a> membersInjector) {
        if (f2550a || membersInjector != null) {
            this.f2551b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1813a> m2159a(MembersInjector<C1813a> membersInjector) {
        return new ma(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1813a) MembersInjectors.injectMembers(this.f2551b, new C1813a());
    }
}
