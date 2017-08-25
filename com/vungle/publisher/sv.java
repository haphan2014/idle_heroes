package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class sv implements Factory<su> {
    static final /* synthetic */ boolean f3216a = (!sv.class.desiredAssertionStatus());
    private final MembersInjector<su> f3217b;

    private sv(MembersInjector<su> membersInjector) {
        if (f3216a || membersInjector != null) {
            this.f3217b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<su> m2483a(MembersInjector<su> membersInjector) {
        return new sv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (su) MembersInjectors.injectMembers(this.f3217b, new su());
    }
}
