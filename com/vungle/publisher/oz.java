package com.vungle.publisher;

import com.vungle.publisher.ov.C1858a.C1857a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class oz implements Factory<C1857a> {
    static final /* synthetic */ boolean f2864a = (!oz.class.desiredAssertionStatus());
    private final MembersInjector<C1857a> f2865b;

    private oz(MembersInjector<C1857a> membersInjector) {
        if (f2864a || membersInjector != null) {
            this.f2865b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1857a> m2315a(MembersInjector<C1857a> membersInjector) {
        return new oz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1857a) MembersInjectors.injectMembers(this.f2865b, new C1857a());
    }
}
