package com.vungle.publisher;

import com.vungle.publisher.hd.C1780a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ia implements Factory<C1780a> {
    static final /* synthetic */ boolean f2122a = (!ia.class.desiredAssertionStatus());
    private final MembersInjector<C1780a> f2123b;

    private ia(MembersInjector<C1780a> membersInjector) {
        if (f2122a || membersInjector != null) {
            this.f2123b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1780a> m1932a(MembersInjector<C1780a> membersInjector) {
        return new ia(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1780a) MembersInjectors.injectMembers(this.f2123b, new C1780a());
    }
}
