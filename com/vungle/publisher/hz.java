package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hz implements Factory<hd> {
    static final /* synthetic */ boolean f2117a = (!hz.class.desiredAssertionStatus());
    private final MembersInjector<hd> f2118b;

    private hz(MembersInjector<hd> membersInjector) {
        if (f2117a || membersInjector != null) {
            this.f2118b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<hd> m1930a(MembersInjector<hd> membersInjector) {
        return new hz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (hd) MembersInjectors.injectMembers(this.f2118b, new hd());
    }
}
