package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zz implements Factory<zy> {
    static final /* synthetic */ boolean f3829a = (!zz.class.desiredAssertionStatus());
    private final MembersInjector<zy> f3830b;

    private zz(MembersInjector<zy> membersInjector) {
        if (f3829a || membersInjector != null) {
            this.f3830b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<zy> m2728a(MembersInjector<zy> membersInjector) {
        return new zz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (zy) MembersInjectors.injectMembers(this.f3830b, new zy());
    }
}
