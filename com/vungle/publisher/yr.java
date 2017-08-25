package com.vungle.publisher;

import com.vungle.publisher.yo.C1920a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class yr implements Factory<C1920a> {
    static final /* synthetic */ boolean f3704a = (!yr.class.desiredAssertionStatus());
    private final MembersInjector<C1920a> f3705b;

    private yr(MembersInjector<C1920a> membersInjector) {
        if (f3704a || membersInjector != null) {
            this.f3705b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1920a> m2664a(MembersInjector<C1920a> membersInjector) {
        return new yr(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1920a) MembersInjectors.injectMembers(this.f3705b, new C1920a());
    }
}
