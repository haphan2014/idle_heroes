package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.lv.C1812b;
import com.vungle.publisher.nl.C1837b.C1836a;
import com.vungle.publisher.oh.C1845a;
import com.vungle.publisher.st.C1873a;
import com.vungle.publisher.tb.C1879a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class np implements MembersInjector<nl> {
    static final /* synthetic */ boolean f2680a = (!np.class.desiredAssertionStatus());
    private final Provider<C1778a> f2681b;
    private final Provider<nd> f2682c;
    private final Provider<pj> f2683d;
    private final Provider<qh> f2684e;
    private final Provider<C1812b> f2685f;
    private final Provider<Context> f2686g;
    private final Provider<C1873a> f2687h;
    private final Provider<C1836a> f2688i;
    private final Provider<te> f2689j;
    private final Provider<nf> f2690k;
    private final Provider<C1879a> f2691l;
    private final Provider<C1845a> f2692m;

    public final /* synthetic */ void injectMembers(Object obj) {
        nl nlVar = (nl) obj;
        if (nlVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        nlVar.f2592c = (C1778a) this.f2681b.get();
        nlVar.f2593d = (nd) this.f2682c.get();
        nlVar.f2606i = (pj) this.f2683d.get();
        nlVar.f2607j = (qh) this.f2684e.get();
        nlVar.f2608k = (C1812b) this.f2685f.get();
        nlVar.f2609l = (Context) this.f2686g.get();
        nlVar.f2668r = (C1873a) this.f2687h.get();
        nlVar.f2669s = (C1836a) this.f2688i.get();
        nlVar.f2670t = (te) this.f2689j.get();
        nlVar.f2671u = (nf) this.f2690k.get();
        nlVar.f2672v = (C1879a) this.f2691l.get();
        nlVar.f2673w = (C1845a) this.f2692m.get();
    }

    private np(Provider<C1778a> provider, Provider<nd> provider2, Provider<pj> provider3, Provider<qh> provider4, Provider<C1812b> provider5, Provider<Context> provider6, Provider<C1873a> provider7, Provider<C1836a> provider8, Provider<te> provider9, Provider<nf> provider10, Provider<C1879a> provider11, Provider<C1845a> provider12) {
        if (f2680a || provider != null) {
            this.f2681b = provider;
            if (f2680a || provider2 != null) {
                this.f2682c = provider2;
                if (f2680a || provider3 != null) {
                    this.f2683d = provider3;
                    if (f2680a || provider4 != null) {
                        this.f2684e = provider4;
                        if (f2680a || provider5 != null) {
                            this.f2685f = provider5;
                            if (f2680a || provider6 != null) {
                                this.f2686g = provider6;
                                if (f2680a || provider7 != null) {
                                    this.f2687h = provider7;
                                    if (f2680a || provider8 != null) {
                                        this.f2688i = provider8;
                                        if (f2680a || provider9 != null) {
                                            this.f2689j = provider9;
                                            if (f2680a || provider10 != null) {
                                                this.f2690k = provider10;
                                                if (f2680a || provider11 != null) {
                                                    this.f2691l = provider11;
                                                    if (f2680a || provider12 != null) {
                                                        this.f2692m = provider12;
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

    public static MembersInjector<nl> m2235a(Provider<C1778a> provider, Provider<nd> provider2, Provider<pj> provider3, Provider<qh> provider4, Provider<C1812b> provider5, Provider<Context> provider6, Provider<C1873a> provider7, Provider<C1836a> provider8, Provider<te> provider9, Provider<nf> provider10, Provider<C1879a> provider11, Provider<C1845a> provider12) {
        return new np(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }
}
