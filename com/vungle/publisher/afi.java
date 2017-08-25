package com.vungle.publisher;

import com.vungle.publisher.afg.C1702b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class afi implements Factory<C1702b> {
    static final /* synthetic */ boolean f1334a = (!afi.class.desiredAssertionStatus());
    private final MembersInjector<C1702b> f1335b;

    private afi(MembersInjector<C1702b> membersInjector) {
        if (f1334a || membersInjector != null) {
            this.f1335b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1702b> m1177a(MembersInjector<C1702b> membersInjector) {
        return new afi(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1702b) MembersInjectors.injectMembers(this.f1335b, new C1702b());
    }
}
