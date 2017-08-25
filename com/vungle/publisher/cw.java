package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class cw implements Factory<cv> {
    static final /* synthetic */ boolean f1571a = (!cw.class.desiredAssertionStatus());
    private final MembersInjector<cv> f1572b;

    private cw(MembersInjector<cv> membersInjector) {
        if (f1571a || membersInjector != null) {
            this.f1572b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<cv> m1354a(MembersInjector<cv> membersInjector) {
        return new cw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (cv) MembersInjectors.injectMembers(this.f1572b, new cv());
    }
}
