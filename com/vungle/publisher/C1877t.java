package com.vungle.publisher;

import com.vungle.publisher.C1821m.C1820c;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1877t implements Factory<C1820c> {
    static final /* synthetic */ boolean f3232a = (!C1877t.class.desiredAssertionStatus());
    private final MembersInjector<C1820c> f3233b;

    private C1877t(MembersInjector<C1820c> membersInjector) {
        if (f3232a || membersInjector != null) {
            this.f3233b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1820c> m2488a(MembersInjector<C1820c> membersInjector) {
        return new C1877t(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1820c) MembersInjectors.injectMembers(this.f3233b, new C1820c());
    }
}
