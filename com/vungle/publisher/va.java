package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class va implements MembersInjector<uy> {
    static final /* synthetic */ boolean f3415a = (!va.class.desiredAssertionStatus());
    private final Provider<xb> f3416b;
    private final Provider<ce> f3417c;

    public final /* synthetic */ void injectMembers(Object obj) {
        uy uyVar = (uy) obj;
        if (uyVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        uyVar.f3405a = (xb) this.f3416b.get();
        uyVar.f3406b = (ce) this.f3417c.get();
    }

    private va(Provider<xb> provider, Provider<ce> provider2) {
        if (f3415a || provider != null) {
            this.f3416b = provider;
            if (f3415a || provider2 != null) {
                this.f3417c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<uy> m2541a(Provider<xb> provider, Provider<ce> provider2) {
        return new va(provider, provider2);
    }
}
