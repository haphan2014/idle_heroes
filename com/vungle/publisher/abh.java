package com.vungle.publisher;

import com.vungle.publisher.abg.C1642a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abh implements Factory<C1642a> {
    static final /* synthetic */ boolean f932a = (!abh.class.desiredAssertionStatus());
    private final MembersInjector<C1642a> f933b;

    private abh(MembersInjector<C1642a> membersInjector) {
        if (f932a || membersInjector != null) {
            this.f933b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1642a> m934a(MembersInjector<C1642a> membersInjector) {
        return new abh(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1642a) MembersInjectors.injectMembers(this.f933b, new C1642a());
    }
}
