package com.vungle.publisher;

import com.vungle.publisher.nu.C1842a.C1841a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ny implements Factory<C1841a> {
    static final /* synthetic */ boolean f2720a = (!ny.class.desiredAssertionStatus());
    private final MembersInjector<C1841a> f2721b;

    private ny(MembersInjector<C1841a> membersInjector) {
        if (f2720a || membersInjector != null) {
            this.f2721b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1841a> m2248a(MembersInjector<C1841a> membersInjector) {
        return new ny(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1841a) MembersInjectors.injectMembers(this.f2721b, new C1841a());
    }
}
