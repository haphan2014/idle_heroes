package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class od implements Factory<oc> {
    static final /* synthetic */ boolean f2732a = (!od.class.desiredAssertionStatus());
    private final MembersInjector<oc> f2733b;

    private od(MembersInjector<oc> membersInjector) {
        if (f2732a || membersInjector != null) {
            this.f2733b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<oc> m2257a(MembersInjector<oc> membersInjector) {
        return new od(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (oc) MembersInjectors.injectMembers(this.f2733b, new oc());
    }
}
