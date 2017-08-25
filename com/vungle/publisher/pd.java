package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class pd implements Factory<pc> {
    static final /* synthetic */ boolean f2877a = (!pd.class.desiredAssertionStatus());
    private final MembersInjector<pc> f2878b;

    private pd(MembersInjector<pc> membersInjector) {
        if (f2877a || membersInjector != null) {
            this.f2878b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<pc> m2325a(MembersInjector<pc> membersInjector) {
        return new pd(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (pc) MembersInjectors.injectMembers(this.f2878b, new pc());
    }
}
