package com.vungle.publisher;

import com.vungle.publisher.ja.C1795a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jc implements Factory<C1795a> {
    static final /* synthetic */ boolean f2239a = (!jc.class.desiredAssertionStatus());
    private final MembersInjector<C1795a> f2240b;

    private jc(MembersInjector<C1795a> membersInjector) {
        if (f2239a || membersInjector != null) {
            this.f2240b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1795a> m1999a(MembersInjector<C1795a> membersInjector) {
        return new jc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1795a) MembersInjectors.injectMembers(this.f2240b, new C1795a());
    }
}
