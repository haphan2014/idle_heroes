package com.vungle.publisher;

import com.vungle.publisher.env.AndroidDevice;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class pg implements Factory<AndroidDevice> {
    static final /* synthetic */ boolean f2886a = (!pg.class.desiredAssertionStatus());
    private final MembersInjector<AndroidDevice> f2887b;

    private pg(MembersInjector<AndroidDevice> membersInjector) {
        if (f2886a || membersInjector != null) {
            this.f2887b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<AndroidDevice> m2327a(MembersInjector<AndroidDevice> membersInjector) {
        return new pg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (AndroidDevice) MembersInjectors.injectMembers(this.f2887b, new AndroidDevice());
    }
}
