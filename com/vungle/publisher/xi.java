package com.vungle.publisher;

import com.vungle.publisher.acs.C1663a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xi implements MembersInjector<xg> {
    static final /* synthetic */ boolean f3572a = (!xi.class.desiredAssertionStatus());
    private final Provider<C1663a> f3573b;

    public final /* synthetic */ void injectMembers(Object obj) {
        xg xgVar = (xg) obj;
        if (xgVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        xgVar.f3569a = (C1663a) this.f3573b.get();
    }

    private xi(Provider<C1663a> provider) {
        if (f3572a || provider != null) {
            this.f3573b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<xg> m2606a(Provider<C1663a> provider) {
        return new xi(provider);
    }
}
