package com.vungle.publisher;

import com.vungle.publisher.ka.C1800b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kb implements Factory<C1800b> {
    static final /* synthetic */ boolean f2328a = (!kb.class.desiredAssertionStatus());
    private final MembersInjector<C1800b> f2329b;

    private kb(MembersInjector<C1800b> membersInjector) {
        if (f2328a || membersInjector != null) {
            this.f2329b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1800b> m2032a(MembersInjector<C1800b> membersInjector) {
        return new kb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1800b) MembersInjectors.injectMembers(this.f2329b, new C1800b());
    }
}
