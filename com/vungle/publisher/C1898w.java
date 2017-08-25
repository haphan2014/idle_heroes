package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class C1898w implements Factory<C1892a> {
    static final /* synthetic */ boolean f3490a = (!C1898w.class.desiredAssertionStatus());
    private final MembersInjector<C1892a> f3491b;

    private C1898w(MembersInjector<C1892a> membersInjector) {
        if (f3490a || membersInjector != null) {
            this.f3491b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1892a> m2565a(MembersInjector<C1892a> membersInjector) {
        return new C1898w(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1892a) MembersInjectors.injectMembers(this.f3491b, new C1892a());
    }
}
