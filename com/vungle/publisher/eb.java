package com.vungle.publisher;

import com.vungle.publisher.dz.C1739a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class eb implements Factory<C1739a> {
    static final /* synthetic */ boolean f1718a = (!eb.class.desiredAssertionStatus());
    private final MembersInjector<C1739a> f1719b;

    private eb(MembersInjector<C1739a> membersInjector) {
        if (f1718a || membersInjector != null) {
            this.f1719b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1739a> m1558a(MembersInjector<C1739a> membersInjector) {
        return new eb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1739a) MembersInjectors.injectMembers(this.f1719b, new C1739a());
    }
}
