package com.vungle.publisher;

import com.vungle.publisher.on.C1847a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class oo implements Factory<C1847a> {
    static final /* synthetic */ boolean f2770a = (!oo.class.desiredAssertionStatus());
    private final MembersInjector<C1847a> f2771b;

    private oo(MembersInjector<C1847a> membersInjector) {
        if (f2770a || membersInjector != null) {
            this.f2771b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1847a> m2273a(MembersInjector<C1847a> membersInjector) {
        return new oo(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1847a) MembersInjectors.injectMembers(this.f2771b, new C1847a());
    }
}
