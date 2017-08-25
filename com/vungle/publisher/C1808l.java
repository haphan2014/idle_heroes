package com.vungle.publisher;

import com.vungle.publisher.mx.C1823a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1808l implements MembersInjector<C1620k> {
    static final /* synthetic */ boolean f2421a = (!C1808l.class.desiredAssertionStatus());
    private final Provider<C1821m> f2422b;
    private final Provider<C1763f> f2423c;
    private final Provider<qq> f2424d;
    private final Provider<cq> f2425e;
    private final Provider<C1707b> f2426f;
    private final Provider<pj> f2427g;
    private final Provider<qh> f2428h;
    private final Provider<AdConfig> f2429i;
    private final Provider<ac> f2430j;
    private final Provider<pr> f2431k;
    private final Provider<pu> f2432l;
    private final Provider<pl> f2433m;
    private final Provider<C1823a> f2434n;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1620k c1620k = (C1620k) obj;
        if (c1620k == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1620k.f757a = (C1821m) this.f2422b.get();
        c1620k.f758b = (C1763f) this.f2423c.get();
        c1620k.f759c = (qq) this.f2424d.get();
        c1620k.f760d = (cq) this.f2425e.get();
        c1620k.f761e = (C1707b) this.f2426f.get();
        c1620k.f762f = (pj) this.f2427g.get();
        c1620k.f763g = (qh) this.f2428h.get();
        c1620k.f764h = (AdConfig) this.f2429i.get();
        c1620k.f765i = (ac) this.f2430j.get();
        c1620k.f766j = (pr) this.f2431k.get();
        c1620k.f767k = (pu) this.f2432l.get();
        c1620k.f768l = (pl) this.f2433m.get();
        c1620k.f769m = (C1823a) this.f2434n.get();
    }

    private C1808l(Provider<C1821m> provider, Provider<C1763f> provider2, Provider<qq> provider3, Provider<cq> provider4, Provider<C1707b> provider5, Provider<pj> provider6, Provider<qh> provider7, Provider<AdConfig> provider8, Provider<ac> provider9, Provider<pr> provider10, Provider<pu> provider11, Provider<pl> provider12, Provider<C1823a> provider13) {
        if (f2421a || provider != null) {
            this.f2422b = provider;
            if (f2421a || provider2 != null) {
                this.f2423c = provider2;
                if (f2421a || provider3 != null) {
                    this.f2424d = provider3;
                    if (f2421a || provider4 != null) {
                        this.f2425e = provider4;
                        if (f2421a || provider5 != null) {
                            this.f2426f = provider5;
                            if (f2421a || provider6 != null) {
                                this.f2427g = provider6;
                                if (f2421a || provider7 != null) {
                                    this.f2428h = provider7;
                                    if (f2421a || provider8 != null) {
                                        this.f2429i = provider8;
                                        if (f2421a || provider9 != null) {
                                            this.f2430j = provider9;
                                            if (f2421a || provider10 != null) {
                                                this.f2431k = provider10;
                                                if (f2421a || provider11 != null) {
                                                    this.f2432l = provider11;
                                                    if (f2421a || provider12 != null) {
                                                        this.f2433m = provider12;
                                                        if (f2421a || provider13 != null) {
                                                            this.f2434n = provider13;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1620k> m2114a(Provider<C1821m> provider, Provider<C1763f> provider2, Provider<qq> provider3, Provider<cq> provider4, Provider<C1707b> provider5, Provider<pj> provider6, Provider<qh> provider7, Provider<AdConfig> provider8, Provider<ac> provider9, Provider<pr> provider10, Provider<pu> provider11, Provider<pl> provider12, Provider<C1823a> provider13) {
        return new C1808l(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }
}
