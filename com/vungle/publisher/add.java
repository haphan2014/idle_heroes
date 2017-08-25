package com.vungle.publisher;

import com.vungle.publisher.ada.C1668b.C1667a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class add implements Factory<C1667a> {
    static final /* synthetic */ boolean f1103a = (!add.class.desiredAssertionStatus());
    private final MembersInjector<C1667a> f1104b;

    private add(MembersInjector<C1667a> membersInjector) {
        if (f1103a || membersInjector != null) {
            this.f1104b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1667a> m1040a(MembersInjector<C1667a> membersInjector) {
        return new add(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1667a) MembersInjectors.injectMembers(this.f1104b, new C1667a());
    }
}
