package com.vungle.publisher;

import com.vungle.publisher.ey.C1758a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class go implements Factory<C1758a> {
    static final /* synthetic */ boolean f2001a = (!go.class.desiredAssertionStatus());
    private final MembersInjector<C1758a> f2002b;

    private go(MembersInjector<C1758a> membersInjector) {
        if (f2001a || membersInjector != null) {
            this.f2002b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1758a> m1838a(MembersInjector<C1758a> membersInjector) {
        return new go(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1758a) MembersInjectors.injectMembers(this.f2002b, new C1758a());
    }
}
