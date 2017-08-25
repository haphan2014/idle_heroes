package com.vungle.publisher;

import com.vungle.publisher.aej.C1682a.C1681a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aem implements Factory<C1681a> {
    static final /* synthetic */ boolean f1229a = (!aem.class.desiredAssertionStatus());
    private final MembersInjector<C1681a> f1230b;

    private aem(MembersInjector<C1681a> membersInjector) {
        if (f1229a || membersInjector != null) {
            this.f1230b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1681a> m1146a(MembersInjector<C1681a> membersInjector) {
        return new aem(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1681a) MembersInjectors.injectMembers(this.f1230b, new C1681a());
    }
}
