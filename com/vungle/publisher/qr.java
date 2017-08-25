package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class qr implements Factory<qq> {
    static final /* synthetic */ boolean f3022a = (!qr.class.desiredAssertionStatus());
    private final MembersInjector<qq> f3023b;

    private qr(MembersInjector<qq> membersInjector) {
        if (f3022a || membersInjector != null) {
            this.f3023b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<qq> m2367a(MembersInjector<qq> membersInjector) {
        return new qr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (qq) MembersInjectors.injectMembers(this.f3023b, new qq());
    }
}
