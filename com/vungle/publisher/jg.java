package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class jg implements Factory<C1788a> {
    static final /* synthetic */ boolean f2248a = (!jg.class.desiredAssertionStatus());
    private final MembersInjector<C1788a> f2249b;

    private jg(MembersInjector<C1788a> membersInjector) {
        if (f2248a || membersInjector != null) {
            this.f2249b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1788a> m2003a(MembersInjector<C1788a> membersInjector) {
        return new jg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1788a) MembersInjectors.injectMembers(this.f2249b, new C1788a());
    }
}
