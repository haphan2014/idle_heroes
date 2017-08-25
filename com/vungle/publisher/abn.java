package com.vungle.publisher;

import com.vungle.publisher.abk.C1646a.C1644a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abn implements Factory<C1644a> {
    static final /* synthetic */ boolean f942a = (!abn.class.desiredAssertionStatus());
    private final MembersInjector<C1644a> f943b;

    private abn(MembersInjector<C1644a> membersInjector) {
        if (f942a || membersInjector != null) {
            this.f943b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1644a> m946a(MembersInjector<C1644a> membersInjector) {
        return new abn(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1644a) MembersInjectors.injectMembers(this.f943b, new C1644a());
    }
}
