package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class hf implements Factory<he> {
    static final /* synthetic */ boolean f2060a = (!hf.class.desiredAssertionStatus());
    private final MembersInjector<he> f2061b;

    private hf(MembersInjector<he> membersInjector) {
        if (f2060a || membersInjector != null) {
            this.f2061b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<he> m1894a(MembersInjector<he> membersInjector) {
        return new hf(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (he) MembersInjectors.injectMembers(this.f2061b, new he());
    }
}
