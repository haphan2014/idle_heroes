package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aai implements Factory<aah> {
    static final /* synthetic */ boolean f820a = (!aai.class.desiredAssertionStatus());
    private final MembersInjector<aah> f821b;

    private aai(MembersInjector<aah> membersInjector) {
        if (f820a || membersInjector != null) {
            this.f821b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aah> m844a(MembersInjector<aah> membersInjector) {
        return new aai(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aah) MembersInjectors.injectMembers(this.f821b, new aah());
    }
}
