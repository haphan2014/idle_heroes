package com.vungle.publisher;

import com.vungle.publisher.kj.C1803a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class kl implements Factory<C1803a> {
    static final /* synthetic */ boolean f2378a = (!kl.class.desiredAssertionStatus());
    private final MembersInjector<C1803a> f2379b;

    private kl(MembersInjector<C1803a> membersInjector) {
        if (f2378a || membersInjector != null) {
            this.f2379b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1803a> m2070a(MembersInjector<C1803a> membersInjector) {
        return new kl(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1803a) MembersInjectors.injectMembers(this.f2379b, new C1803a());
    }
}
