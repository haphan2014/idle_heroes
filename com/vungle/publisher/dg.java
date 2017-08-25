package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.eu.C1751a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dg implements MembersInjector<C1733a> {
    static final /* synthetic */ boolean f1639a = (!dg.class.desiredAssertionStatus());
    private final Provider<cq> f1640b;
    private final Provider<dd> f1641c;
    private final Provider<C1751a> f1642d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1733a c1733a = (C1733a) obj;
        if (c1733a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1733a.f1530d = (cq) this.f1640b.get();
        c1733a.f1629a = this.f1641c;
        c1733a.f1630b = (C1751a) this.f1642d.get();
    }

    private dg(Provider<cq> provider, Provider<dd> provider2, Provider<C1751a> provider3) {
        if (f1639a || provider != null) {
            this.f1640b = provider;
            if (f1639a || provider2 != null) {
                this.f1641c = provider2;
                if (f1639a || provider3 != null) {
                    this.f1642d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1733a> m1457a(Provider<cq> provider, Provider<dd> provider2, Provider<C1751a> provider3) {
        return new dg(provider, provider2, provider3);
    }
}
