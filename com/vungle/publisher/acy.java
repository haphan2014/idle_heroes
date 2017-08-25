package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class acy implements Factory<acv> {
    static final /* synthetic */ boolean f1073a = (!acy.class.desiredAssertionStatus());
    private final MembersInjector<acv> f1074b;

    private acy(MembersInjector<acv> membersInjector) {
        if (f1073a || membersInjector != null) {
            this.f1074b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<acv> m1024a(MembersInjector<acv> membersInjector) {
        return new acy(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (acv) MembersInjectors.injectMembers(this.f1074b, new acv());
    }
}
