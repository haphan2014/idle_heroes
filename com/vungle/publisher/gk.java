package com.vungle.publisher;

import com.vungle.publisher.ez.C1760a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gk implements Factory<C1760a> {
    static final /* synthetic */ boolean f1982a = (!gk.class.desiredAssertionStatus());
    private final MembersInjector<C1760a> f1983b;

    private gk(MembersInjector<C1760a> membersInjector) {
        if (f1982a || membersInjector != null) {
            this.f1983b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1760a> m1834a(MembersInjector<C1760a> membersInjector) {
        return new gk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1760a) MembersInjectors.injectMembers(this.f1983b, new C1760a());
    }
}
