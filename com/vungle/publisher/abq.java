package com.vungle.publisher;

import com.vungle.publisher.abp.C1648a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abq implements Factory<C1648a> {
    static final /* synthetic */ boolean f949a = (!abq.class.desiredAssertionStatus());
    private final MembersInjector<C1648a> f950b;

    private abq(MembersInjector<C1648a> membersInjector) {
        if (f949a || membersInjector != null) {
            this.f950b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1648a> m954a(MembersInjector<C1648a> membersInjector) {
        return new abq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1648a) MembersInjectors.injectMembers(this.f950b, new C1648a());
    }
}
