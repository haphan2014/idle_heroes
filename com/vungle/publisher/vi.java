package com.vungle.publisher;

import com.vungle.publisher.vg.C1896a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class vi implements Factory<C1896a> {
    static final /* synthetic */ boolean f3448a = (!vi.class.desiredAssertionStatus());
    private final MembersInjector<C1896a> f3449b;

    private vi(MembersInjector<C1896a> membersInjector) {
        if (f3448a || membersInjector != null) {
            this.f3449b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1896a> m2545a(MembersInjector<C1896a> membersInjector) {
        return new vi(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1896a) MembersInjectors.injectMembers(this.f3449b, new C1896a());
    }
}
