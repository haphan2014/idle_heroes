package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class tf implements Factory<te> {
    static final /* synthetic */ boolean f3259a = (!tf.class.desiredAssertionStatus());
    private final MembersInjector<te> f3260b;

    private tf(MembersInjector<te> membersInjector) {
        if (f3259a || membersInjector != null) {
            this.f3260b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<te> m2496a(MembersInjector<te> membersInjector) {
        return new tf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (te) MembersInjectors.injectMembers(this.f3260b, new te());
    }
}
