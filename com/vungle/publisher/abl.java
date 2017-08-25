package com.vungle.publisher;

import com.vungle.publisher.abk.C1646a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abl implements Factory<C1646a> {
    static final /* synthetic */ boolean f938a = (!abl.class.desiredAssertionStatus());
    private final MembersInjector<C1646a> f939b;

    private abl(MembersInjector<C1646a> membersInjector) {
        if (f938a || membersInjector != null) {
            this.f939b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1646a> m944a(MembersInjector<C1646a> membersInjector) {
        return new abl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1646a) MembersInjectors.injectMembers(this.f939b, new C1646a());
    }
}
