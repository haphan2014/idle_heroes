package com.vungle.publisher;

import com.vungle.publisher.fu.C1771a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gb implements Factory<C1771a> {
    static final /* synthetic */ boolean f1950a = (!gb.class.desiredAssertionStatus());
    private final MembersInjector<C1771a> f1951b;

    private gb(MembersInjector<C1771a> membersInjector) {
        if (f1950a || membersInjector != null) {
            this.f1951b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1771a> m1814a(MembersInjector<C1771a> membersInjector) {
        return new gb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1771a) MembersInjectors.injectMembers(this.f1951b, new C1771a());
    }
}
