package com.vungle.publisher;

import com.vungle.publisher.ada.C1666a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adb implements Factory<C1666a> {
    static final /* synthetic */ boolean f1092a = (!adb.class.desiredAssertionStatus());
    private final MembersInjector<C1666a> f1093b;

    private adb(MembersInjector<C1666a> membersInjector) {
        if (f1092a || membersInjector != null) {
            this.f1093b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1666a> m1038a(MembersInjector<C1666a> membersInjector) {
        return new adb(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1666a) MembersInjectors.injectMembers(this.f1093b, new C1666a());
    }
}
