package com.vungle.publisher;

import com.vungle.publisher.abs.C1650a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class abu implements Factory<C1650a> {
    static final /* synthetic */ boolean f970a = (!abu.class.desiredAssertionStatus());
    private final MembersInjector<C1650a> f971b;

    private abu(MembersInjector<C1650a> membersInjector) {
        if (f970a || membersInjector != null) {
            this.f971b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1650a> m963a(MembersInjector<C1650a> membersInjector) {
        return new abu(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1650a) MembersInjectors.injectMembers(this.f971b, new C1650a());
    }
}
