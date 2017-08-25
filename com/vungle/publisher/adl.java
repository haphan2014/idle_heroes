package com.vungle.publisher;

import com.vungle.publisher.adk.C1672a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class adl implements Factory<C1672a> {
    static final /* synthetic */ boolean f1140a = (!adl.class.desiredAssertionStatus());
    private final MembersInjector<C1672a> f1141b;

    private adl(MembersInjector<C1672a> membersInjector) {
        if (f1140a || membersInjector != null) {
            this.f1141b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1672a> m1075a(MembersInjector<C1672a> membersInjector) {
        return new adl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1672a) MembersInjectors.injectMembers(this.f1141b, new C1672a());
    }
}
