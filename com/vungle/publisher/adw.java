package com.vungle.publisher;

import com.vungle.publisher.adv.C1677a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adw implements Factory<C1677a> {
    static final /* synthetic */ boolean f1185a = (!adw.class.desiredAssertionStatus());
    private final MembersInjector<C1677a> f1186b;

    private adw(MembersInjector<C1677a> membersInjector) {
        if (f1185a || membersInjector != null) {
            this.f1186b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1677a> m1108a(MembersInjector<C1677a> membersInjector) {
        return new adw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1677a) MembersInjectors.injectMembers(this.f1186b, new C1677a());
    }
}
