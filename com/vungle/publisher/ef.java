package com.vungle.publisher;

import com.vungle.publisher.ed.C1741a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ef implements Factory<C1741a> {
    static final /* synthetic */ boolean f1726a = (!ef.class.desiredAssertionStatus());
    private final MembersInjector<C1741a> f1727b;

    private ef(MembersInjector<C1741a> membersInjector) {
        if (f1726a || membersInjector != null) {
            this.f1727b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1741a> m1563a(MembersInjector<C1741a> membersInjector) {
        return new ef(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1741a) MembersInjectors.injectMembers(this.f1727b, new C1741a());
    }
}
