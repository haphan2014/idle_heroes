package com.vungle.publisher;

import com.vungle.publisher.abx.C1655a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class aby implements Factory<C1655a> {
    static final /* synthetic */ boolean f981a = (!aby.class.desiredAssertionStatus());
    private final MembersInjector<C1655a> f982b;

    private aby(MembersInjector<C1655a> membersInjector) {
        if (f981a || membersInjector != null) {
            this.f982b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1655a> m976a(MembersInjector<C1655a> membersInjector) {
        return new aby(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1655a) MembersInjectors.injectMembers(this.f982b, new C1655a());
    }
}
