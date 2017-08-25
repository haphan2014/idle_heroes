package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class vc implements Factory<vb> {
    static final /* synthetic */ boolean f3418a = (!vc.class.desiredAssertionStatus());
    private final MembersInjector<vb> f3419b;

    private vc(MembersInjector<vb> membersInjector) {
        if (f3418a || membersInjector != null) {
            this.f3419b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<vb> m2542a(MembersInjector<vb> membersInjector) {
        return new vc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (vb) MembersInjectors.injectMembers(this.f3419b, new vb());
    }
}
