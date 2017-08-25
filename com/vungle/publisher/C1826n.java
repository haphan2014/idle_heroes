package com.vungle.publisher;

import com.vungle.publisher.C1821m.C1818a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1826n implements Factory<C1818a> {
    static final /* synthetic */ boolean f2610a = (!C1826n.class.desiredAssertionStatus());
    private final MembersInjector<C1818a> f2611b;

    private C1826n(MembersInjector<C1818a> membersInjector) {
        if (f2610a || membersInjector != null) {
            this.f2611b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1818a> m2185a(MembersInjector<C1818a> membersInjector) {
        return new C1826n(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1818a) MembersInjectors.injectMembers(this.f2611b, new C1818a());
    }
}
