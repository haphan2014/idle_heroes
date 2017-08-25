package com.vungle.publisher;

import com.vungle.publisher.ov.C1858a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class oy implements Factory<C1858a> {
    static final /* synthetic */ boolean f2862a = (!oy.class.desiredAssertionStatus());
    private final MembersInjector<C1858a> f2863b;

    private oy(MembersInjector<C1858a> membersInjector) {
        if (f2862a || membersInjector != null) {
            this.f2863b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1858a> m2314a(MembersInjector<C1858a> membersInjector) {
        return new oy(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1858a) MembersInjectors.injectMembers(this.f2863b, new C1858a());
    }
}
