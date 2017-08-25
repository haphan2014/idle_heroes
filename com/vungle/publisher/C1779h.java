package com.vungle.publisher;

import com.vungle.publisher.C1763f.C1762a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1779h implements Factory<C1762a> {
    static final /* synthetic */ boolean f2044a = (!C1779h.class.desiredAssertionStatus());
    private final MembersInjector<C1762a> f2045b;

    private C1779h(MembersInjector<C1762a> membersInjector) {
        if (f2044a || membersInjector != null) {
            this.f2045b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1762a> m1876a(MembersInjector<C1762a> membersInjector) {
        return new C1779h(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1762a) MembersInjectors.injectMembers(this.f2045b, new C1762a());
    }
}
