package com.vungle.publisher;

import com.vungle.publisher.kd.C1801a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lo implements Factory<C1801a> {
    static final /* synthetic */ boolean f2476a = (!lo.class.desiredAssertionStatus());
    private final MembersInjector<C1801a> f2477b;

    private lo(MembersInjector<C1801a> membersInjector) {
        if (f2476a || membersInjector != null) {
            this.f2477b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1801a> m2131a(MembersInjector<C1801a> membersInjector) {
        return new lo(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1801a) MembersInjectors.injectMembers(this.f2477b, new C1801a());
    }
}
