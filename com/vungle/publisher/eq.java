package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class eq implements Factory<ep> {
    static final /* synthetic */ boolean f1792a = (!eq.class.desiredAssertionStatus());
    private final MembersInjector<ep> f1793b;

    private eq(MembersInjector<ep> membersInjector) {
        if (f1792a || membersInjector != null) {
            this.f1793b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<ep> m1649a(MembersInjector<ep> membersInjector) {
        return new eq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (ep) MembersInjectors.injectMembers(this.f1793b, new ep());
    }
}
