package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afm implements Factory<afl> {
    static final /* synthetic */ boolean f1358a = (!afm.class.desiredAssertionStatus());
    private final MembersInjector<afl> f1359b;

    private afm(MembersInjector<afl> membersInjector) {
        if (f1358a || membersInjector != null) {
            this.f1359b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<afl> m1192a(MembersInjector<afl> membersInjector) {
        return new afm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (afl) MembersInjectors.injectMembers(this.f1359b, new afl());
    }
}
