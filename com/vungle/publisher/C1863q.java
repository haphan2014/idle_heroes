package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.C1821m.C1818a;
import com.vungle.publisher.C1821m.C1819b;
import com.vungle.publisher.C1821m.C1820c;
import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ka.C1800b;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1863q implements MembersInjector<C1821m> {
    static final /* synthetic */ boolean f2962a = (!C1863q.class.desiredAssertionStatus());
    private final Provider<qh> f2963b;
    private final Provider<pu> f2964c;
    private final Provider<Context> f2965d;
    private final Provider<pj> f2966e;
    private final Provider<Class> f2967f;
    private final Provider<Class> f2968g;
    private final Provider<ce> f2969h;
    private final Provider<un> f2970i;
    private final Provider<C1819b> f2971j;
    private final Provider<C1818a> f2972k;
    private final Provider<C1820c> f2973l;
    private final Provider<xp> f2974m;
    private final Provider<pr> f2975n;
    private final Provider<C1788a> f2976o;
    private final Provider<C1800b> f2977p;
    private final Provider<ac> f2978q;
    private final Provider<pl> f2979r;
    private final Provider<C1778a> f2980s;
    private final Provider<C1721b> f2981t;
    private final Provider<C1747b> f2982u;
    private final Provider<aes> f2983v;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1821m c1821m = (C1821m) obj;
        if (c1821m == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1821m.f1341v = (qh) this.f2963b.get();
        c1821m.f2529a = (pu) this.f2964c.get();
        c1821m.f2530b = (Context) this.f2965d.get();
        c1821m.f2531c = (pj) this.f2966e.get();
        c1821m.f2532d = (qh) this.f2963b.get();
        c1821m.f2533e = (Class) this.f2967f.get();
        c1821m.f2534f = (Class) this.f2968g.get();
        c1821m.f2535g = (ce) this.f2969h.get();
        c1821m.f2536h = (un) this.f2970i.get();
        c1821m.f2537i = DoubleCheck.lazy(this.f2971j);
        c1821m.f2538j = DoubleCheck.lazy(this.f2972k);
        c1821m.f2539k = this.f2973l;
        c1821m.f2540l = (xp) this.f2974m.get();
        c1821m.f2541m = (pr) this.f2975n.get();
        c1821m.f2542n = (C1788a) this.f2976o.get();
        c1821m.f2543o = (C1800b) this.f2977p.get();
        c1821m.f2544p = (ac) this.f2978q.get();
        c1821m.f2545q = (pl) this.f2979r.get();
        c1821m.f2546r = (C1778a) this.f2980s.get();
        c1821m.f2547s = (C1721b) this.f2981t.get();
        c1821m.f2548t = (C1747b) this.f2982u.get();
        c1821m.f2549u = (aes) this.f2983v.get();
    }

    private C1863q(Provider<qh> provider, Provider<pu> provider2, Provider<Context> provider3, Provider<pj> provider4, Provider<Class> provider5, Provider<Class> provider6, Provider<ce> provider7, Provider<un> provider8, Provider<C1819b> provider9, Provider<C1818a> provider10, Provider<C1820c> provider11, Provider<xp> provider12, Provider<pr> provider13, Provider<C1788a> provider14, Provider<C1800b> provider15, Provider<ac> provider16, Provider<pl> provider17, Provider<C1778a> provider18, Provider<C1721b> provider19, Provider<C1747b> provider20, Provider<aes> provider21) {
        if (f2962a || provider != null) {
            this.f2963b = provider;
            if (f2962a || provider2 != null) {
                this.f2964c = provider2;
                if (f2962a || provider3 != null) {
                    this.f2965d = provider3;
                    if (f2962a || provider4 != null) {
                        this.f2966e = provider4;
                        if (f2962a || provider5 != null) {
                            this.f2967f = provider5;
                            if (f2962a || provider6 != null) {
                                this.f2968g = provider6;
                                if (f2962a || provider7 != null) {
                                    this.f2969h = provider7;
                                    if (f2962a || provider8 != null) {
                                        this.f2970i = provider8;
                                        if (f2962a || provider9 != null) {
                                            this.f2971j = provider9;
                                            if (f2962a || provider10 != null) {
                                                this.f2972k = provider10;
                                                if (f2962a || provider11 != null) {
                                                    this.f2973l = provider11;
                                                    if (f2962a || provider12 != null) {
                                                        this.f2974m = provider12;
                                                        if (f2962a || provider13 != null) {
                                                            this.f2975n = provider13;
                                                            if (f2962a || provider14 != null) {
                                                                this.f2976o = provider14;
                                                                if (f2962a || provider15 != null) {
                                                                    this.f2977p = provider15;
                                                                    if (f2962a || provider16 != null) {
                                                                        this.f2978q = provider16;
                                                                        if (f2962a || provider17 != null) {
                                                                            this.f2979r = provider17;
                                                                            if (f2962a || provider18 != null) {
                                                                                this.f2980s = provider18;
                                                                                if (f2962a || provider19 != null) {
                                                                                    this.f2981t = provider19;
                                                                                    if (f2962a || provider20 != null) {
                                                                                        this.f2982u = provider20;
                                                                                        if (f2962a || provider21 != null) {
                                                                                            this.f2983v = provider21;
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

    public static MembersInjector<C1821m> m2353a(Provider<qh> provider, Provider<pu> provider2, Provider<Context> provider3, Provider<pj> provider4, Provider<Class> provider5, Provider<Class> provider6, Provider<ce> provider7, Provider<un> provider8, Provider<C1819b> provider9, Provider<C1818a> provider10, Provider<C1820c> provider11, Provider<xp> provider12, Provider<pr> provider13, Provider<C1788a> provider14, Provider<C1800b> provider15, Provider<ac> provider16, Provider<pl> provider17, Provider<C1778a> provider18, Provider<C1721b> provider19, Provider<C1747b> provider20, Provider<aes> provider21) {
        return new C1863q(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21);
    }
}
