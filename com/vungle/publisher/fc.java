package com.vungle.publisher;

import com.vungle.publisher.fa.C1764a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class fc implements Factory<C1764a> {
    static final /* synthetic */ boolean f1875a = (!fc.class.desiredAssertionStatus());
    private final MembersInjector<C1764a> f1876b;

    private fc(MembersInjector<C1764a> membersInjector) {
        if (f1875a || membersInjector != null) {
            this.f1876b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1764a> m1771a(MembersInjector<C1764a> membersInjector) {
        return new fc(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1764a) MembersInjectors.injectMembers(this.f1876b, new C1764a());
    }
}
