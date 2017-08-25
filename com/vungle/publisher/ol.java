package com.vungle.publisher;

import com.vungle.publisher.ok.C1846a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ol implements Factory<C1846a> {
    static final /* synthetic */ boolean f2763a = (!ol.class.desiredAssertionStatus());
    private final MembersInjector<C1846a> f2764b;

    private ol(MembersInjector<C1846a> membersInjector) {
        if (f2763a || membersInjector != null) {
            this.f2764b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1846a> m2268a(MembersInjector<C1846a> membersInjector) {
        return new ol(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1846a) MembersInjectors.injectMembers(this.f2764b, new C1846a());
    }
}
