package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class uz implements Factory<uy> {
    static final /* synthetic */ boolean f3407a = (!uz.class.desiredAssertionStatus());
    private final MembersInjector<uy> f3408b;

    private uz(MembersInjector<uy> membersInjector) {
        if (f3407a || membersInjector != null) {
            this.f3408b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<uy> m2538a(MembersInjector<uy> membersInjector) {
        return new uz(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (uy) MembersInjectors.injectMembers(this.f3408b, new uy());
    }
}
