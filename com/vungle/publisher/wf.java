package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wf implements Factory<we> {
    static final /* synthetic */ boolean f3502a = (!wf.class.desiredAssertionStatus());
    private final MembersInjector<we> f3503b;

    private wf(MembersInjector<we> membersInjector) {
        if (f3502a || membersInjector != null) {
            this.f3503b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<we> m2570a(MembersInjector<we> membersInjector) {
        return new wf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (we) MembersInjectors.injectMembers(this.f3503b, new we());
    }
}
