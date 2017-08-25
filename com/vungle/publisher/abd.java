package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abd implements Factory<abc> {
    static final /* synthetic */ boolean f925a = (!abd.class.desiredAssertionStatus());
    private final MembersInjector<abc> f926b;

    private abd(MembersInjector<abc> membersInjector) {
        if (f925a || membersInjector != null) {
            this.f926b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<abc> m925a(MembersInjector<abc> membersInjector) {
        return new abd(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (abc) MembersInjectors.injectMembers(this.f926b, new abc());
    }
}
