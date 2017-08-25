package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.oh.C1845a;
import com.vungle.publisher.ok.C1846a;
import com.vungle.publisher.oq.C1853a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ou implements MembersInjector<oq> {
    static final /* synthetic */ boolean f2831a = (!ou.class.desiredAssertionStatus());
    private final Provider<C1778a> f2832b;
    private final Provider<nd> f2833c;
    private final Provider<nf> f2834d;
    private final Provider<qh> f2835e;
    private final Provider<C1853a> f2836f;
    private final Provider<C1845a> f2837g;
    private final Provider<C1846a> f2838h;
    private final Provider<pj> f2839i;
    private final Provider<agj> f2840j;
    private final Provider<cj> f2841k;
    private final Provider<mc> f2842l;

    public final /* synthetic */ void injectMembers(Object obj) {
        oq oqVar = (oq) obj;
        if (oqVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        oqVar.f2592c = (C1778a) this.f2832b.get();
        oqVar.f2593d = (nd) this.f2833c.get();
        oqVar.f2812n = (nf) this.f2834d.get();
        oqVar.f2813o = (qh) this.f2835e.get();
        oqVar.f2814p = (C1853a) this.f2836f.get();
        oqVar.f2815q = (C1845a) this.f2837g.get();
        oqVar.f2816r = (C1846a) this.f2838h.get();
        oqVar.f2817s = (pj) this.f2839i.get();
        oqVar.f2818t = (agj) this.f2840j.get();
        oqVar.f2819u = (cj) this.f2841k.get();
        oqVar.f2820v = (mc) this.f2842l.get();
    }

    private ou(Provider<C1778a> provider, Provider<nd> provider2, Provider<nf> provider3, Provider<qh> provider4, Provider<C1853a> provider5, Provider<C1845a> provider6, Provider<C1846a> provider7, Provider<pj> provider8, Provider<agj> provider9, Provider<cj> provider10, Provider<mc> provider11) {
        if (f2831a || provider != null) {
            this.f2832b = provider;
            if (f2831a || provider2 != null) {
                this.f2833c = provider2;
                if (f2831a || provider3 != null) {
                    this.f2834d = provider3;
                    if (f2831a || provider4 != null) {
                        this.f2835e = provider4;
                        if (f2831a || provider5 != null) {
                            this.f2836f = provider5;
                            if (f2831a || provider6 != null) {
                                this.f2837g = provider6;
                                if (f2831a || provider7 != null) {
                                    this.f2838h = provider7;
                                    if (f2831a || provider8 != null) {
                                        this.f2839i = provider8;
                                        if (f2831a || provider9 != null) {
                                            this.f2840j = provider9;
                                            if (f2831a || provider10 != null) {
                                                this.f2841k = provider10;
                                                if (f2831a || provider11 != null) {
                                                    this.f2842l = provider11;
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
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<oq> m2306a(Provider<C1778a> provider, Provider<nd> provider2, Provider<nf> provider3, Provider<qh> provider4, Provider<C1853a> provider5, Provider<C1845a> provider6, Provider<C1846a> provider7, Provider<pj> provider8, Provider<agj> provider9, Provider<cj> provider10, Provider<mc> provider11) {
        return new ou(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }
}
