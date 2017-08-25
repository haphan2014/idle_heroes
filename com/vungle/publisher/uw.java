package com.vungle.publisher;

import com.vungle.publisher.uv.C1890a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class uw implements Factory<C1890a> {
    static final /* synthetic */ boolean f3396a = (!uw.class.desiredAssertionStatus());
    private final MembersInjector<C1890a> f3397b;

    private uw(MembersInjector<C1890a> membersInjector) {
        if (f3396a || membersInjector != null) {
            this.f3397b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1890a> m2534a(MembersInjector<C1890a> membersInjector) {
        return new uw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1890a) MembersInjectors.injectMembers(this.f3397b, new C1890a());
    }
}
