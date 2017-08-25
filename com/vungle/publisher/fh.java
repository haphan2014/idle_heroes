package com.vungle.publisher;

import com.vungle.publisher.ff.C1765a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fh implements Factory<C1765a> {
    static final /* synthetic */ boolean f1893a = (!fh.class.desiredAssertionStatus());
    private final MembersInjector<C1765a> f1894b;

    private fh(MembersInjector<C1765a> membersInjector) {
        if (f1893a || membersInjector != null) {
            this.f1894b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1765a> m1776a(MembersInjector<C1765a> membersInjector) {
        return new fh(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1765a) MembersInjectors.injectMembers(this.f1894b, new C1765a());
    }
}
