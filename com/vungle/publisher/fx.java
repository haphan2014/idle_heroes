package com.vungle.publisher;

import com.vungle.publisher.fv.C1773a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fx implements Factory<C1773a> {
    static final /* synthetic */ boolean f1938a = (!fx.class.desiredAssertionStatus());
    private final MembersInjector<C1773a> f1939b;

    private fx(MembersInjector<C1773a> membersInjector) {
        if (f1938a || membersInjector != null) {
            this.f1939b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1773a> m1809a(MembersInjector<C1773a> membersInjector) {
        return new fx(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1773a) MembersInjectors.injectMembers(this.f1939b, new C1773a());
    }
}
