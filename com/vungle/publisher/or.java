package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class or implements Factory<oq> {
    static final /* synthetic */ boolean f2825a = (!or.class.desiredAssertionStatus());
    private final MembersInjector<oq> f2826b;

    private or(MembersInjector<oq> membersInjector) {
        if (f2825a || membersInjector != null) {
            this.f2826b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<oq> m2303a(MembersInjector<oq> membersInjector) {
        return new or(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (oq) MembersInjectors.injectMembers(this.f2826b, new oq());
    }
}
