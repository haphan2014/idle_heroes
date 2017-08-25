package com.vungle.publisher;

import com.vungle.publisher.acg.C1659a.C1658a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class acj implements Factory<C1658a> {
    static final /* synthetic */ boolean f1023a = (!acj.class.desiredAssertionStatus());
    private final MembersInjector<C1658a> f1024b;

    private acj(MembersInjector<C1658a> membersInjector) {
        if (f1023a || membersInjector != null) {
            this.f1024b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1658a> m992a(MembersInjector<C1658a> membersInjector) {
        return new acj(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1658a) MembersInjectors.injectMembers(this.f1024b, new C1658a());
    }
}
