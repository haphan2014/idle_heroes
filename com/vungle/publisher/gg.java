package com.vungle.publisher;

import com.vungle.publisher.ge.C1776a;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;

/* compiled from: vungle */
public final class gg implements Factory<C1776a> {
    static final /* synthetic */ boolean f1973a = (!gg.class.desiredAssertionStatus());
    private final MembersInjector<C1776a> f1974b;

    private gg(MembersInjector<C1776a> membersInjector) {
        if (f1973a || membersInjector != null) {
            this.f1974b = membersInjector;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<C1776a> m1830a(MembersInjector<C1776a> membersInjector) {
        return new gg(membersInjector);
    }

    public final /* synthetic */ Object get() {
        return (C1776a) MembersInjectors.injectMembers(this.f1974b, new C1776a());
    }
}
