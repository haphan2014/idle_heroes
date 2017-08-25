package com.vungle.publisher;

import com.vungle.publisher.wo.C1902a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class wq implements Factory<C1902a> {
    static final /* synthetic */ boolean f3528a = (!wq.class.desiredAssertionStatus());
    private final MembersInjector<C1902a> f3529b;

    private wq(MembersInjector<C1902a> membersInjector) {
        if (f3528a || membersInjector != null) {
            this.f3529b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1902a> m2586a(MembersInjector<C1902a> membersInjector) {
        return new wq(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1902a) MembersInjectors.injectMembers(this.f3529b, new C1902a());
    }
}
