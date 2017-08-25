package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fb implements Factory<fa> {
    static final /* synthetic */ boolean f1873a = (!fb.class.desiredAssertionStatus());
    private final MembersInjector<fa> f1874b;

    private fb(MembersInjector<fa> membersInjector) {
        if (f1873a || membersInjector != null) {
            this.f1874b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<fa> m1770a(MembersInjector<fa> membersInjector) {
        return new fb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (fa) MembersInjectors.injectMembers(this.f1874b, new fa());
    }
}
