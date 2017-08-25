package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class nm implements Factory<nl> {
    static final /* synthetic */ boolean f2674a = (!nm.class.desiredAssertionStatus());
    private final MembersInjector<nl> f2675b;

    private nm(MembersInjector<nl> membersInjector) {
        if (f2674a || membersInjector != null) {
            this.f2675b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<nl> m2232a(MembersInjector<nl> membersInjector) {
        return new nm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (nl) MembersInjectors.injectMembers(this.f2675b, new nl());
    }
}
