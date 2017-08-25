package com.vungle.publisher;

import com.vungle.publisher.afo.C1703a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.nl.C1835a;
import com.vungle.publisher.nu.C1842a.C1841a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nw implements MembersInjector<nu> {
    static final /* synthetic */ boolean f2710a = (!nw.class.desiredAssertionStatus());
    private final Provider<qh> f2711b;
    private final Provider<C1778a> f2712c;
    private final Provider<agc> f2713d;
    private final Provider<pj> f2714e;
    private final Provider<C1703a> f2715f;
    private final Provider<C1841a> f2716g;
    private final Provider<C1835a> f2717h;

    public final /* synthetic */ void injectMembers(Object obj) {
        nu nuVar = (nu) obj;
        if (nuVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        nuVar.f2643g = (qh) this.f2711b.get();
        nuVar.f2644h = (C1778a) this.f2712c.get();
        nuVar.f2645i = (agc) this.f2713d.get();
        nuVar.f2646j = (pj) this.f2714e.get();
        nuVar.f2704k = (C1703a) this.f2715f.get();
        nuVar.f2705l = (C1841a) this.f2716g.get();
        nuVar.f2706m = (C1835a) this.f2717h.get();
    }

    private nw(Provider<qh> provider, Provider<C1778a> provider2, Provider<agc> provider3, Provider<pj> provider4, Provider<C1703a> provider5, Provider<C1841a> provider6, Provider<C1835a> provider7) {
        if (f2710a || provider != null) {
            this.f2711b = provider;
            if (f2710a || provider2 != null) {
                this.f2712c = provider2;
                if (f2710a || provider3 != null) {
                    this.f2713d = provider3;
                    if (f2710a || provider4 != null) {
                        this.f2714e = provider4;
                        if (f2710a || provider5 != null) {
                            this.f2715f = provider5;
                            if (f2710a || provider6 != null) {
                                this.f2716g = provider6;
                                if (f2710a || provider7 != null) {
                                    this.f2717h = provider7;
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

    public static MembersInjector<nu> m2246a(Provider<qh> provider, Provider<C1778a> provider2, Provider<agc> provider3, Provider<pj> provider4, Provider<C1703a> provider5, Provider<C1841a> provider6, Provider<C1835a> provider7) {
        return new nw(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
