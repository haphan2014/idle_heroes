package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ya implements Factory<xz> {
    static final /* synthetic */ boolean f3647a = (!ya.class.desiredAssertionStatus());
    private final MembersInjector<xz> f3648b;

    private ya(MembersInjector<xz> membersInjector) {
        if (f3647a || membersInjector != null) {
            this.f3648b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<xz> m2638a(MembersInjector<xz> membersInjector) {
        return new ya(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (xz) MembersInjectors.injectMembers(this.f3648b, new xz());
    }
}
