package com.vungle.publisher;

import com.vungle.publisher.bl.C1708a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class bm implements Factory<C1708a> {
    static final /* synthetic */ boolean f1434a = (!bm.class.desiredAssertionStatus());
    private final MembersInjector<C1708a> f1435b;

    private bm(MembersInjector<C1708a> membersInjector) {
        if (f1434a || membersInjector != null) {
            this.f1435b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1708a> m1234a(MembersInjector<C1708a> membersInjector) {
        return new bm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1708a) MembersInjectors.injectMembers(this.f1435b, new C1708a());
    }
}
