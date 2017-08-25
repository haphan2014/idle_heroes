package com.vungle.publisher;

import com.vungle.publisher.acw.C1664a;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yz implements MembersInjector<yx> {
    static final /* synthetic */ boolean f3731a = (!yz.class.desiredAssertionStatus());
    private final Provider<C1778a> f3732b;
    private final Provider<wa> f3733c;
    private final Provider<ce> f3734d;
    private final Provider<C1664a> f3735e;
    private final Provider<pr> f3736f;
    private final Provider<qh> f3737g;
    private final Provider<yo> f3738h;

    public final /* synthetic */ void injectMembers(Object obj) {
        yx yxVar = (yx) obj;
        if (yxVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vn.m2548a(yxVar, this.f3732b);
        vn.m2549b(yxVar, this.f3733c);
        wj.m2576a(yxVar, this.f3734d);
        yxVar.f3725g = (C1664a) this.f3735e.get();
        yxVar.f3726h = (pr) this.f3736f.get();
        yxVar.f3727i = (qh) this.f3737g.get();
        yxVar.f3728j = this.f3738h;
    }

    private yz(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<C1664a> provider4, Provider<pr> provider5, Provider<qh> provider6, Provider<yo> provider7) {
        if (f3731a || provider != null) {
            this.f3732b = provider;
            if (f3731a || provider2 != null) {
                this.f3733c = provider2;
                if (f3731a || provider3 != null) {
                    this.f3734d = provider3;
                    if (f3731a || provider4 != null) {
                        this.f3735e = provider4;
                        if (f3731a || provider5 != null) {
                            this.f3736f = provider5;
                            if (f3731a || provider6 != null) {
                                this.f3737g = provider6;
                                if (f3731a || provider7 != null) {
                                    this.f3738h = provider7;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<yx> m2677a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<C1664a> provider4, Provider<pr> provider5, Provider<qh> provider6, Provider<yo> provider7) {
        return new yz(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
