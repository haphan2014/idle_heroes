package com.vungle.publisher;

import com.vungle.publisher.st.C1873a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class sz implements Factory<C1873a> {
    static final /* synthetic */ boolean f3230a = (!sz.class.desiredAssertionStatus());
    private final MembersInjector<C1873a> f3231b;

    private sz(MembersInjector<C1873a> membersInjector) {
        if (f3230a || membersInjector != null) {
            this.f3231b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1873a> m2487a(MembersInjector<C1873a> membersInjector) {
        return new sz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1873a) MembersInjectors.injectMembers(this.f3231b, new C1873a());
    }
}
