package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ow implements Factory<ov> {
    static final /* synthetic */ boolean f2851a = (!ow.class.desiredAssertionStatus());
    private final MembersInjector<ov> f2852b;

    private ow(MembersInjector<ov> membersInjector) {
        if (f2851a || membersInjector != null) {
            this.f2852b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ov> m2312a(MembersInjector<ov> membersInjector) {
        return new ow(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ov) MembersInjectors.injectMembers(this.f2852b, new ov());
    }
}
