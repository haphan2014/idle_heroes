package com.vungle.publisher;

import com.vungle.publisher.ep.C1750a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class er implements Factory<C1750a> {
    static final /* synthetic */ boolean f1794a = (!er.class.desiredAssertionStatus());
    private final MembersInjector<C1750a> f1795b;

    private er(MembersInjector<C1750a> membersInjector) {
        if (f1794a || membersInjector != null) {
            this.f1795b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1750a> m1650a(MembersInjector<C1750a> membersInjector) {
        return new er(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1750a) MembersInjectors.injectMembers(this.f1795b, new C1750a());
    }
}
