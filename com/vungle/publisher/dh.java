package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dh implements MembersInjector<dd> {
    static final /* synthetic */ boolean f1643a = (!dh.class.desiredAssertionStatus());
    private final Provider<cq> f1644b;
    private final Provider<C1733a> f1645c;

    public final /* synthetic */ void injectMembers(Object obj) {
        dd ddVar = (dd) obj;
        if (ddVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ddVar.f1551v = (cq) this.f1644b.get();
        ddVar.f1634d = (C1733a) this.f1645c.get();
    }

    private dh(Provider<cq> provider, Provider<C1733a> provider2) {
        if (f1643a || provider != null) {
            this.f1644b = provider;
            if (f1643a || provider2 != null) {
                this.f1645c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<dd> m1458a(Provider<cq> provider, Provider<C1733a> provider2) {
        return new dh(provider, provider2);
    }
}
