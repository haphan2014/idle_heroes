package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.ie.C1787a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class jm implements MembersInjector<ie> {
    static final /* synthetic */ boolean f2269a = (!jm.class.desiredAssertionStatus());
    private final Provider<cq> f2270b;
    private final Provider<C1788a> f2271c;
    private final Provider<C1787a> f2272d;

    public final /* synthetic */ void injectMembers(Object obj) {
        ie ieVar = (ie) obj;
        if (ieVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ieVar.f1551v = (cq) this.f2270b.get();
        ieVar.f2152a = (C1788a) this.f2271c.get();
        ieVar.f2153b = (C1787a) this.f2272d.get();
    }

    private jm(Provider<cq> provider, Provider<C1788a> provider2, Provider<C1787a> provider3) {
        if (f2269a || provider != null) {
            this.f2270b = provider;
            if (f2269a || provider2 != null) {
                this.f2271c = provider2;
                if (f2269a || provider3 != null) {
                    this.f2272d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<ie> m2009a(Provider<cq> provider, Provider<C1788a> provider2, Provider<C1787a> provider3) {
        return new jm(provider, provider2, provider3);
    }
}
