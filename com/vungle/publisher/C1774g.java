package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1774g implements Factory<C1763f> {
    static final /* synthetic */ boolean f1946a = (!C1774g.class.desiredAssertionStatus());
    private final MembersInjector<C1763f> f1947b;

    private C1774g(MembersInjector<C1763f> membersInjector) {
        if (f1946a || membersInjector != null) {
            this.f1947b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1763f> m1812a(MembersInjector<C1763f> membersInjector) {
        return new C1774g(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1763f) MembersInjectors.injectMembers(this.f1947b, new C1763f());
    }
}
