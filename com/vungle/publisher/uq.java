package com.vungle.publisher;

import android.content.Context;
import android.net.ConnectivityManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class uq implements MembersInjector<uo> {
    static final /* synthetic */ boolean f3385a = (!uq.class.desiredAssertionStatus());
    private final Provider<Context> f3386b;
    private final Provider<un> f3387c;
    private final Provider<qh> f3388d;
    private final Provider<ConnectivityManager> f3389e;

    public final /* synthetic */ void injectMembers(Object obj) {
        uo uoVar = (uo) obj;
        if (uoVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        uoVar.f3378b = (Context) this.f3386b.get();
        uoVar.f3379c = (un) this.f3387c.get();
        uoVar.f3380d = (qh) this.f3388d.get();
        uoVar.f3381e = (ConnectivityManager) this.f3389e.get();
    }

    private uq(Provider<Context> provider, Provider<un> provider2, Provider<qh> provider3, Provider<ConnectivityManager> provider4) {
        if (f3385a || provider != null) {
            this.f3386b = provider;
            if (f3385a || provider2 != null) {
                this.f3387c = provider2;
                if (f3385a || provider3 != null) {
                    this.f3388d = provider3;
                    if (f3385a || provider4 != null) {
                        this.f3389e = provider4;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<uo> m2528a(Provider<Context> provider, Provider<un> provider2, Provider<qh> provider3, Provider<ConnectivityManager> provider4) {
        return new uq(provider, provider2, provider3, provider4);
    }
}
