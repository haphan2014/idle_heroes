package com.vungle.publisher;

import com.vungle.publisher.acg.C1659a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ach implements Factory<C1659a> {
    static final /* synthetic */ boolean f1012a = (!ach.class.desiredAssertionStatus());
    private final MembersInjector<C1659a> f1013b;

    private ach(MembersInjector<C1659a> membersInjector) {
        if (f1012a || membersInjector != null) {
            this.f1013b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1659a> m990a(MembersInjector<C1659a> membersInjector) {
        return new ach(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1659a) MembersInjectors.injectMembers(this.f1013b, new C1659a());
    }
}
