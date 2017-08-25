package com.vungle.publisher;

import com.vungle.publisher.ko.C1804a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kq implements Factory<C1804a> {
    static final /* synthetic */ boolean f2390a = (!kq.class.desiredAssertionStatus());
    private final MembersInjector<C1804a> f2391b;

    private kq(MembersInjector<C1804a> membersInjector) {
        if (f2390a || membersInjector != null) {
            this.f2391b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1804a> m2083a(MembersInjector<C1804a> membersInjector) {
        return new kq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1804a) MembersInjectors.injectMembers(this.f2391b, new C1804a());
    }
}
