package com.vungle.publisher;

import com.vungle.publisher.acs.C1663a;
import com.vungle.publisher.adh.C1671a;
import com.vungle.publisher.adn.C1673a;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zl implements MembersInjector<zj> {
    static final /* synthetic */ boolean f3781a = (!zl.class.desiredAssertionStatus());
    private final Provider<C1778a> f3782b;
    private final Provider<wa> f3783c;
    private final Provider<ce> f3784d;
    private final Provider<qh> f3785e;
    private final Provider<C1673a> f3786f;
    private final Provider<C1671a> f3787g;
    private final Provider<C1663a> f3788h;

    public final /* synthetic */ void injectMembers(Object obj) {
        zj zjVar = (zj) obj;
        if (zjVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vn.m2548a(zjVar, this.f3782b);
        vn.m2549b(zjVar, this.f3783c);
        wj.m2576a(zjVar, this.f3784d);
        zjVar.f3775g = (qh) this.f3785e.get();
        zjVar.f3776h = (C1673a) this.f3786f.get();
        zjVar.f3777i = (C1671a) this.f3787g.get();
        zjVar.f3778j = (C1663a) this.f3788h.get();
    }

    private zl(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<qh> provider4, Provider<C1673a> provider5, Provider<C1671a> provider6, Provider<C1663a> provider7) {
        if (f3781a || provider != null) {
            this.f3782b = provider;
            if (f3781a || provider2 != null) {
                this.f3783c = provider2;
                if (f3781a || provider3 != null) {
                    this.f3784d = provider3;
                    if (f3781a || provider4 != null) {
                        this.f3785e = provider4;
                        if (f3781a || provider5 != null) {
                            this.f3786f = provider5;
                            if (f3781a || provider6 != null) {
                                this.f3787g = provider6;
                                if (f3781a || provider7 != null) {
                                    this.f3788h = provider7;
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

    public static MembersInjector<zj> m2708a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<qh> provider4, Provider<C1673a> provider5, Provider<C1671a> provider6, Provider<C1663a> provider7) {
        return new zl(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
