package com.vungle.publisher;

import com.vungle.publisher.acw.C1664a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class acx implements Factory<C1664a> {
    static final /* synthetic */ boolean f1071a = (!acx.class.desiredAssertionStatus());
    private final MembersInjector<C1664a> f1072b;

    private acx(MembersInjector<C1664a> membersInjector) {
        if (f1071a || membersInjector != null) {
            this.f1072b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1664a> m1023a(MembersInjector<C1664a> membersInjector) {
        return new acx(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1664a) MembersInjectors.injectMembers(this.f1072b, new C1664a());
    }
}
