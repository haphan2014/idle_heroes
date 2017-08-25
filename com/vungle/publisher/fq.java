package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fq implements Factory<fp> {
    static final /* synthetic */ boolean f1916a = (!fq.class.desiredAssertionStatus());
    private final MembersInjector<fp> f1917b;

    private fq(MembersInjector<fp> membersInjector) {
        if (f1916a || membersInjector != null) {
            this.f1917b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<fp> m1790a(MembersInjector<fp> membersInjector) {
        return new fq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (fp) MembersInjectors.injectMembers(this.f1917b, new fp());
    }
}
