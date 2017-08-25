package com.vungle.publisher;

import com.vungle.publisher.ie.C1787a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jk implements Factory<C1787a> {
    static final /* synthetic */ boolean f2263a = (!jk.class.desiredAssertionStatus());
    private final MembersInjector<C1787a> f2264b;

    private jk(MembersInjector<C1787a> membersInjector) {
        if (f2263a || membersInjector != null) {
            this.f2264b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1787a> m2007a(MembersInjector<C1787a> membersInjector) {
        return new jk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1787a) MembersInjectors.injectMembers(this.f2264b, new C1787a());
    }
}
