package com.vungle.publisher;

import com.vungle.publisher.oq.C1853a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class os implements Factory<C1853a> {
    static final /* synthetic */ boolean f2827a = (!os.class.desiredAssertionStatus());
    private final MembersInjector<C1853a> f2828b;

    private os(MembersInjector<C1853a> membersInjector) {
        if (f2827a || membersInjector != null) {
            this.f2828b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1853a> m2304a(MembersInjector<C1853a> membersInjector) {
        return new os(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1853a) MembersInjectors.injectMembers(this.f2828b, new C1853a());
    }
}
