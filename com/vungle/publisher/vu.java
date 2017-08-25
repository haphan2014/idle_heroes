package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vu implements MembersInjector<vr> {
    static final /* synthetic */ boolean f3477a = (!vu.class.desiredAssertionStatus());
    private final Provider<vv> f3478b;

    public final /* synthetic */ void injectMembers(Object obj) {
        vr vrVar = (vr) obj;
        if (vrVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vrVar.f3472e = (vv) this.f3478b.get();
    }

    private vu(Provider<vv> provider) {
        if (f3477a || provider != null) {
            this.f3478b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<vr> m2556a(Provider<vv> provider) {
        return new vu(provider);
    }
}
