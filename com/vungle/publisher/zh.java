package com.vungle.publisher;

import com.vungle.publisher.zg.C1924a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class zh implements Factory<C1924a> {
    static final /* synthetic */ boolean f3760a = (!zh.class.desiredAssertionStatus());
    private final MembersInjector<C1924a> f3761b;

    private zh(MembersInjector<C1924a> membersInjector) {
        if (f3760a || membersInjector != null) {
            this.f3761b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1924a> m2693a(MembersInjector<C1924a> membersInjector) {
        return new zh(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1924a) MembersInjectors.injectMembers(this.f3761b, new C1924a());
    }
}
