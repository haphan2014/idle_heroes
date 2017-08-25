package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class wg implements MembersInjector<we> {
    static final /* synthetic */ boolean f3504a = (!wg.class.desiredAssertionStatus());
    private final Provider<wt> f3505b;
    private final Provider<ce> f3506c;

    public final /* synthetic */ void injectMembers(Object obj) {
        we weVar = (we) obj;
        if (weVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        weVar.f3500a = (wt) this.f3505b.get();
        weVar.f3501b = (ce) this.f3506c.get();
    }

    private wg(Provider<wt> provider, Provider<ce> provider2) {
        if (f3504a || provider != null) {
            this.f3505b = provider;
            if (f3504a || provider2 != null) {
                this.f3506c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<we> m2571a(Provider<wt> provider, Provider<ce> provider2) {
        return new wg(provider, provider2);
    }
}
