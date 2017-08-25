package com.vungle.publisher;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class ui implements Factory<uh> {
    static final /* synthetic */ boolean f3340a = (!ui.class.desiredAssertionStatus());
    private final MembersInjector<uh> f3341b;

    private ui(MembersInjector<uh> membersInjector) {
        if (f3340a || membersInjector != null) {
            this.f3341b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<uh> m2525a(MembersInjector<uh> membersInjector) {
        return new ui(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (uh) MembersInjectors.injectMembers(this.f3341b, new uh());
    }
}
