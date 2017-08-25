package com.vungle.publisher;

import com.vungle.publisher.yc.C1916a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yd implements Factory<C1916a> {
    static final /* synthetic */ boolean f3654a = (!yd.class.desiredAssertionStatus());
    private final MembersInjector<C1916a> f3655b;

    private yd(MembersInjector<C1916a> membersInjector) {
        if (f3654a || membersInjector != null) {
            this.f3655b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1916a> m2643a(MembersInjector<C1916a> membersInjector) {
        return new yd(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1916a) MembersInjectors.injectMembers(this.f3655b, new C1916a());
    }
}
