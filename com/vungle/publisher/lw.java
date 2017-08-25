package com.vungle.publisher;

import com.vungle.publisher.lv.C1812b;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class lw implements Factory<C1812b> {
    static final /* synthetic */ boolean f2505a = (!lw.class.desiredAssertionStatus());
    private final MembersInjector<C1812b> f2506b;

    private lw(MembersInjector<C1812b> membersInjector) {
        if (f2505a || membersInjector != null) {
            this.f2506b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1812b> m2146a(MembersInjector<C1812b> membersInjector) {
        return new lw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1812b) MembersInjectors.injectMembers(this.f2506b, new C1812b());
    }
}
