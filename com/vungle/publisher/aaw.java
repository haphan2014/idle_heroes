package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1630b.C1629a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aaw implements Factory<C1629a> {
    static final /* synthetic */ boolean f903a = (!aaw.class.desiredAssertionStatus());
    private final MembersInjector<C1629a> f904b;

    private aaw(MembersInjector<C1629a> membersInjector) {
        if (f903a || membersInjector != null) {
            this.f904b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1629a> m889a(MembersInjector<C1629a> membersInjector) {
        return new aaw(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1629a) MembersInjectors.injectMembers(this.f904b, new C1629a());
    }
}
