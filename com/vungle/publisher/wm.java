package com.vungle.publisher;

import com.vungle.publisher.wk.C1901a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wm implements Factory<C1901a> {
    static final /* synthetic */ boolean f3516a = (!wm.class.desiredAssertionStatus());
    private final MembersInjector<C1901a> f3517b;

    private wm(MembersInjector<C1901a> membersInjector) {
        if (f3516a || membersInjector != null) {
            this.f3517b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1901a> m2582a(MembersInjector<C1901a> membersInjector) {
        return new wm(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1901a) MembersInjectors.injectMembers(this.f3517b, new C1901a());
    }
}
