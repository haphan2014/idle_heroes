package com.vungle.publisher;

import com.vungle.publisher.dm.C1734a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dp implements MembersInjector<C1734a> {
    static final /* synthetic */ boolean f1670a = (!dp.class.desiredAssertionStatus());
    private final Provider<cq> f1671b;
    private final Provider<dm> f1672c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1734a c1734a = (C1734a) obj;
        if (c1734a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1734a.f1530d = (cq) this.f1671b.get();
        c1734a.f1661a = this.f1672c;
    }

    private dp(Provider<cq> provider, Provider<dm> provider2) {
        if (f1670a || provider != null) {
            this.f1671b = provider;
            if (f1670a || provider2 != null) {
                this.f1672c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1734a> m1480a(Provider<cq> provider, Provider<dm> provider2) {
        return new dp(provider, provider2);
    }
}
