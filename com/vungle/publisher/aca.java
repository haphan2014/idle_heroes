package com.vungle.publisher;

import com.vungle.publisher.abx.C1655a.C1653a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aca implements Factory<C1653a> {
    static final /* synthetic */ boolean f992a = (!aca.class.desiredAssertionStatus());
    private final MembersInjector<C1653a> f993b;

    private aca(MembersInjector<C1653a> membersInjector) {
        if (f992a || membersInjector != null) {
            this.f993b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1653a> m978a(MembersInjector<C1653a> membersInjector) {
        return new aca(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1653a) MembersInjectors.injectMembers(this.f993b, new C1653a());
    }
}
