package com.vungle.publisher;

import com.vungle.publisher.oh.C1845a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class oi implements Factory<C1845a> {
    static final /* synthetic */ boolean f2751a = (!oi.class.desiredAssertionStatus());
    private final MembersInjector<C1845a> f2752b;

    private oi(MembersInjector<C1845a> membersInjector) {
        if (f2751a || membersInjector != null) {
            this.f2752b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1845a> m2264a(MembersInjector<C1845a> membersInjector) {
        return new oi(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1845a) MembersInjectors.injectMembers(this.f2752b, new C1845a());
    }
}
