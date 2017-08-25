package com.vungle.publisher;

import com.vungle.publisher.pl.C1861a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class pm implements Factory<C1861a> {
    static final /* synthetic */ boolean f2905a = (!pm.class.desiredAssertionStatus());
    private final MembersInjector<C1861a> f2906b;

    private pm(MembersInjector<C1861a> membersInjector) {
        if (f2905a || membersInjector != null) {
            this.f2906b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1861a> m2337a(MembersInjector<C1861a> membersInjector) {
        return new pm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1861a) MembersInjectors.injectMembers(this.f2906b, new C1861a());
    }
}
