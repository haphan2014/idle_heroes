package com.vungle.publisher;

import com.vungle.publisher.lr.C1811a;
import com.vungle.publisher.lv.C1812b;
import com.vungle.publisher.ly.C1813a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lx implements MembersInjector<C1812b> {
    static final /* synthetic */ boolean f2507a = (!lx.class.desiredAssertionStatus());
    private final Provider<C1811a> f2508b;
    private final Provider<C1813a> f2509c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1812b c1812b = (C1812b) obj;
        if (c1812b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1812b.f2503a = (C1811a) this.f2508b.get();
        c1812b.f2504b = (C1813a) this.f2509c.get();
    }

    private lx(Provider<C1811a> provider, Provider<C1813a> provider2) {
        if (f2507a || provider != null) {
            this.f2508b = provider;
            if (f2507a || provider2 != null) {
                this.f2509c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1812b> m2147a(Provider<C1811a> provider, Provider<C1813a> provider2) {
        return new lx(provider, provider2);
    }
}
