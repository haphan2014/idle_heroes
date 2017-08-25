package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aet implements Factory<aes> {
    static final /* synthetic */ boolean f1257a = (!aet.class.desiredAssertionStatus());
    private final MembersInjector<aes> f1258b;

    private aet(MembersInjector<aes> membersInjector) {
        if (f1257a || membersInjector != null) {
            this.f1258b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<aes> m1154a(MembersInjector<aes> membersInjector) {
        return new aet(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (aes) MembersInjectors.injectMembers(this.f1258b, new aes());
    }
}
