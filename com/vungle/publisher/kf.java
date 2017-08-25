package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kf implements Factory<ke> {
    static final /* synthetic */ boolean f2359a = (!kf.class.desiredAssertionStatus());
    private final MembersInjector<ke> f2360b;

    private kf(MembersInjector<ke> membersInjector) {
        if (f2359a || membersInjector != null) {
            this.f2360b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ke> m2064a(MembersInjector<ke> membersInjector) {
        return new kf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ke) MembersInjectors.injectMembers(this.f2360b, new ke());
    }
}
