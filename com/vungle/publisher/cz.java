package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cz implements MembersInjector<cv> {
    static final /* synthetic */ boolean f1578a = (!cz.class.desiredAssertionStatus());
    private final Provider<cq> f1579b;
    private final Provider<C1723a> f1580c;

    public final /* synthetic */ void injectMembers(Object obj) {
        cv cvVar = (cv) obj;
        if (cvVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        cvVar.f1551v = (cq) this.f1579b.get();
        cvVar.f1570c = (C1723a) this.f1580c.get();
    }

    private cz(Provider<cq> provider, Provider<C1723a> provider2) {
        if (f1578a || provider != null) {
            this.f1579b = provider;
            if (f1578a || provider2 != null) {
                this.f1580c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<cv> m1357a(Provider<cq> provider, Provider<C1723a> provider2) {
        return new cz(provider, provider2);
    }
}
