package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jb implements Factory<ja> {
    static final /* synthetic */ boolean f2237a = (!jb.class.desiredAssertionStatus());
    private final MembersInjector<ja> f2238b;

    private jb(MembersInjector<ja> membersInjector) {
        if (f2237a || membersInjector != null) {
            this.f2238b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ja> m1998a(MembersInjector<ja> membersInjector) {
        return new jb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ja) MembersInjectors.injectMembers(this.f2238b, new ja());
    }
}
