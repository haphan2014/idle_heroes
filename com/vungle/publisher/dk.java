package com.vungle.publisher;

import com.vungle.publisher.cu.C1721b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class dk implements Factory<C1721b> {
    static final /* synthetic */ boolean f1654a = (!dk.class.desiredAssertionStatus());
    private final MembersInjector<C1721b> f1655b;

    private dk(MembersInjector<C1721b> membersInjector) {
        if (f1654a || membersInjector != null) {
            this.f1655b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1721b> m1461a(MembersInjector<C1721b> membersInjector) {
        return new dk(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1721b) MembersInjectors.injectMembers(this.f1655b, new C1721b());
    }
}
