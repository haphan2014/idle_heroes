package com.vungle.publisher;

import com.vungle.publisher.fk.C1767a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fm implements Factory<C1767a> {
    static final /* synthetic */ boolean f1905a = (!fm.class.desiredAssertionStatus());
    private final MembersInjector<C1767a> f1906b;

    private fm(MembersInjector<C1767a> membersInjector) {
        if (f1905a || membersInjector != null) {
            this.f1906b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1767a> m1785a(MembersInjector<C1767a> membersInjector) {
        return new fm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1767a) MembersInjectors.injectMembers(this.f1906b, new C1767a());
    }
}
