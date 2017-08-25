package com.vungle.publisher;

import com.vungle.publisher.aat.C1636b.C1634b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aba implements Factory<C1634b> {
    static final /* synthetic */ boolean f914a = (!aba.class.desiredAssertionStatus());
    private final MembersInjector<C1634b> f915b;

    private aba(MembersInjector<C1634b> membersInjector) {
        if (f914a || membersInjector != null) {
            this.f915b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1634b> m909a(MembersInjector<C1634b> membersInjector) {
        return new aba(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1634b) MembersInjectors.injectMembers(this.f915b, new C1634b());
    }
}
