package com.vungle.publisher;

import com.vungle.publisher.ade.C1670a;
import com.vungle.publisher.adh.C1671a;
import com.vungle.publisher.ads.C1676a;
import com.vungle.publisher.afg.C1702b;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afj implements MembersInjector<C1702b> {
    static final /* synthetic */ boolean f1336a = (!afj.class.desiredAssertionStatus());
    private final Provider<C1670a> f1337b;
    private final Provider<C1671a> f1338c;
    private final Provider<C1676a> f1339d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1702b c1702b = (C1702b) obj;
        if (c1702b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1702b.f1329a = (C1670a) this.f1337b.get();
        c1702b.f1330b = (C1671a) this.f1338c.get();
        c1702b.f1331c = (C1676a) this.f1339d.get();
    }

    private afj(Provider<C1670a> provider, Provider<C1671a> provider2, Provider<C1676a> provider3) {
        if (f1336a || provider != null) {
            this.f1337b = provider;
            if (f1336a || provider2 != null) {
                this.f1338c = provider2;
                if (f1336a || provider3 != null) {
                    this.f1339d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1702b> m1178a(Provider<C1670a> provider, Provider<C1671a> provider2, Provider<C1676a> provider3) {
        return new afj(provider, provider2, provider3);
    }
}
