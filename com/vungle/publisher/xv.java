package com.vungle.publisher;

import com.vungle.publisher.xt.C1915b;
import com.vungle.publisher.yc.C1916a;
import com.vungle.publisher.yf.C1917a;
import com.vungle.publisher.yi.C1918a;
import com.vungle.publisher.yl.C1919a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xv implements MembersInjector<C1915b> {
    static final /* synthetic */ boolean f3632a = (!xv.class.desiredAssertionStatus());
    private final Provider<C1916a> f3633b;
    private final Provider<C1918a> f3634c;
    private final Provider<C1919a> f3635d;
    private final Provider<C1917a> f3636e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1915b c1915b = (C1915b) obj;
        if (c1915b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1915b.f3623a = (C1916a) this.f3633b.get();
        c1915b.f3624b = (C1918a) this.f3634c.get();
        c1915b.f3625c = (C1919a) this.f3635d.get();
        c1915b.f3626d = (C1917a) this.f3636e.get();
    }

    private xv(Provider<C1916a> provider, Provider<C1918a> provider2, Provider<C1919a> provider3, Provider<C1917a> provider4) {
        if (f3632a || provider != null) {
            this.f3633b = provider;
            if (f3632a || provider2 != null) {
                this.f3634c = provider2;
                if (f3632a || provider3 != null) {
                    this.f3635d = provider3;
                    if (f3632a || provider4 != null) {
                        this.f3636e = provider4;
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

    public static MembersInjector<C1915b> m2633a(Provider<C1916a> provider, Provider<C1918a> provider2, Provider<C1919a> provider3, Provider<C1917a> provider4) {
        return new xv(provider, provider2, provider3, provider4);
    }
}
