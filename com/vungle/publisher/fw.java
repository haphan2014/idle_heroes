package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fw implements Factory<fv> {
    static final /* synthetic */ boolean f1936a = (!fw.class.desiredAssertionStatus());
    private final MembersInjector<fv> f1937b;

    private fw(MembersInjector<fv> membersInjector) {
        if (f1936a || membersInjector != null) {
            this.f1937b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<fv> m1808a(MembersInjector<fv> membersInjector) {
        return new fw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (fv) MembersInjectors.injectMembers(this.f1937b, new fv());
    }
}
