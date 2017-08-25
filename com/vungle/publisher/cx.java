package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class cx implements Factory<C1723a> {
    static final /* synthetic */ boolean f1573a = (!cx.class.desiredAssertionStatus());
    private final MembersInjector<C1723a> f1574b;

    private cx(MembersInjector<C1723a> membersInjector) {
        if (f1573a || membersInjector != null) {
            this.f1574b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1723a> m1355a(MembersInjector<C1723a> membersInjector) {
        return new cx(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1723a) MembersInjectors.injectMembers(this.f1574b, new C1723a());
    }
}
