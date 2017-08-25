package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yu implements Factory<yt> {
    static final /* synthetic */ boolean f3711a = (!yu.class.desiredAssertionStatus());
    private final MembersInjector<yt> f3712b;

    private yu(MembersInjector<yt> membersInjector) {
        if (f3711a || membersInjector != null) {
            this.f3712b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<yt> m2672a(MembersInjector<yt> membersInjector) {
        return new yu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (yt) MembersInjectors.injectMembers(this.f3712b, new yt());
    }
}
