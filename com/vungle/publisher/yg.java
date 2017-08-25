package com.vungle.publisher;

import com.vungle.publisher.yf.C1917a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yg implements Factory<C1917a> {
    static final /* synthetic */ boolean f3665a = (!yg.class.desiredAssertionStatus());
    private final MembersInjector<C1917a> f3666b;

    private yg(MembersInjector<C1917a> membersInjector) {
        if (f3665a || membersInjector != null) {
            this.f3666b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1917a> m2648a(MembersInjector<C1917a> membersInjector) {
        return new yg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1917a) MembersInjectors.injectMembers(this.f3666b, new C1917a());
    }
}
