package com.vungle.publisher;

import com.vungle.publisher.fp.C1769a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fr implements Factory<C1769a> {
    static final /* synthetic */ boolean f1918a = (!fr.class.desiredAssertionStatus());
    private final MembersInjector<C1769a> f1919b;

    private fr(MembersInjector<C1769a> membersInjector) {
        if (f1918a || membersInjector != null) {
            this.f1919b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1769a> m1791a(MembersInjector<C1769a> membersInjector) {
        return new fr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1769a) MembersInjectors.injectMembers(this.f1919b, new C1769a());
    }
}
