package com.vungle.publisher;

import com.vungle.publisher.ig.C1790a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ij implements MembersInjector<C1790a> {
    static final /* synthetic */ boolean f2165a = (!ij.class.desiredAssertionStatus());
    private final Provider<cq> f2166b;
    private final Provider<ig> f2167c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1790a c1790a = (C1790a) obj;
        if (c1790a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1790a.f1530d = (cq) this.f2166b.get();
        c1790a.f2159a = this.f2167c;
    }

    private ij(Provider<cq> provider, Provider<ig> provider2) {
        if (f2165a || provider != null) {
            this.f2166b = provider;
            if (f2165a || provider2 != null) {
                this.f2167c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1790a> m1968a(Provider<cq> provider, Provider<ig> provider2) {
        return new ij(provider, provider2);
    }
}
