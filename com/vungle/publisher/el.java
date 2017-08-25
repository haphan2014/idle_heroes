package com.vungle.publisher;

import com.vungle.publisher.ei.C1748c;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class el implements Factory<C1748c> {
    static final /* synthetic */ boolean f1759a = (!el.class.desiredAssertionStatus());
    private final MembersInjector<C1748c> f1760b;

    private el(MembersInjector<C1748c> membersInjector) {
        if (f1759a || membersInjector != null) {
            this.f1760b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1748c> m1586a(MembersInjector<C1748c> membersInjector) {
        return new el(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1748c) MembersInjectors.injectMembers(this.f1760b, new C1748c());
    }
}
