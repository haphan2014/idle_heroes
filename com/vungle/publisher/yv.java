package com.vungle.publisher;

import com.vungle.publisher.yt.C1921a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yv implements Factory<C1921a> {
    static final /* synthetic */ boolean f3713a = (!yv.class.desiredAssertionStatus());
    private final MembersInjector<C1921a> f3714b;

    private yv(MembersInjector<C1921a> membersInjector) {
        if (f3713a || membersInjector != null) {
            this.f3714b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1921a> m2673a(MembersInjector<C1921a> membersInjector) {
        return new yv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1921a) MembersInjectors.injectMembers(this.f3714b, new C1921a());
    }
}
