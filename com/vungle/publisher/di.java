package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class di implements Factory<C1730b> {
    static final /* synthetic */ boolean f1646a = (!di.class.desiredAssertionStatus());
    private final MembersInjector<C1730b> f1647b;

    private di(MembersInjector<C1730b> membersInjector) {
        if (f1646a || membersInjector != null) {
            this.f1647b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1730b> m1459a(MembersInjector<C1730b> membersInjector) {
        return new di(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1730b) MembersInjectors.injectMembers(this.f1647b, new C1730b());
    }
}
