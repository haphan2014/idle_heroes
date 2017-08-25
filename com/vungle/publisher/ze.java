package com.vungle.publisher;

import com.vungle.publisher.zd.C1923a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ze implements Factory<C1923a> {
    static final /* synthetic */ boolean f3749a = (!ze.class.desiredAssertionStatus());
    private final MembersInjector<C1923a> f3750b;

    private ze(MembersInjector<C1923a> membersInjector) {
        if (f3749a || membersInjector != null) {
            this.f3750b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1923a> m2687a(MembersInjector<C1923a> membersInjector) {
        return new ze(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1923a) MembersInjectors.injectMembers(this.f3750b, new C1923a());
    }
}
