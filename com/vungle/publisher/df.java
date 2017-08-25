package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class df implements Factory<C1733a> {
    static final /* synthetic */ boolean f1637a = (!df.class.desiredAssertionStatus());
    private final MembersInjector<C1733a> f1638b;

    private df(MembersInjector<C1733a> membersInjector) {
        if (f1637a || membersInjector != null) {
            this.f1638b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1733a> m1456a(MembersInjector<C1733a> membersInjector) {
        return new df(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1733a) MembersInjectors.injectMembers(this.f1638b, new C1733a());
    }
}
