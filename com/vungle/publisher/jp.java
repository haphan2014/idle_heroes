package com.vungle.publisher;

import com.vungle.publisher.jn.C1796a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jp implements Factory<C1796a> {
    static final /* synthetic */ boolean f2282a = (!jp.class.desiredAssertionStatus());
    private final MembersInjector<C1796a> f2283b;

    private jp(MembersInjector<C1796a> membersInjector) {
        if (f2282a || membersInjector != null) {
            this.f2283b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1796a> m2027a(MembersInjector<C1796a> membersInjector) {
        return new jp(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1796a) MembersInjectors.injectMembers(this.f2283b, new C1796a());
    }
}
