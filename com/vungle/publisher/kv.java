package com.vungle.publisher;

import com.vungle.publisher.kt.C1805a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kv implements Factory<C1805a> {
    static final /* synthetic */ boolean f2403a = (!kv.class.desiredAssertionStatus());
    private final MembersInjector<C1805a> f2404b;

    private kv(MembersInjector<C1805a> membersInjector) {
        if (f2403a || membersInjector != null) {
            this.f2404b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1805a> m2093a(MembersInjector<C1805a> membersInjector) {
        return new kv(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1805a) MembersInjectors.injectMembers(this.f2404b, new C1805a());
    }
}
