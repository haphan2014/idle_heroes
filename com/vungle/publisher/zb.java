package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zb implements Factory<za> {
    static final /* synthetic */ boolean f3741a = (!zb.class.desiredAssertionStatus());
    private final MembersInjector<za> f3742b;

    private zb(MembersInjector<za> membersInjector) {
        if (f3741a || membersInjector != null) {
            this.f3742b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<za> m2679a(MembersInjector<za> membersInjector) {
        return new zb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (za) MembersInjectors.injectMembers(this.f3742b, new za());
    }
}
