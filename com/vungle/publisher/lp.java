package com.vungle.publisher;

import com.vungle.publisher.dr.C1737a;
import com.vungle.publisher.ed.C1741a;
import com.vungle.publisher.jn.C1796a;
import com.vungle.publisher.kd.C1801a;
import com.vungle.publisher.ke.C1802a;
import com.vungle.publisher.kj.C1803a;
import com.vungle.publisher.ko.C1804a;
import com.vungle.publisher.li.C1809a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class lp implements MembersInjector<C1801a> {
    static final /* synthetic */ boolean f2478a = (!lp.class.desiredAssertionStatus());
    private final Provider<cq> f2479b;
    private final Provider<qh> f2480c;
    private final Provider<agg> f2481d;
    private final Provider<kd> f2482e;
    private final Provider<C1737a> f2483f;
    private final Provider<String> f2484g;
    private final Provider<C1803a> f2485h;
    private final Provider<C1802a> f2486i;
    private final Provider<C1804a> f2487j;
    private final Provider<C1809a> f2488k;
    private final Provider<C1796a> f2489l;
    private final Provider<C1741a> f2490m;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1801a c1801a = (C1801a) obj;
        if (c1801a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1801a.f1530d = (cq) this.f2479b.get();
        c1801a.f1531a = (qh) this.f2480c.get();
        c1801a.f1532b = (agg) this.f2481d.get();
        c1801a.f2336c = this.f2482e;
        c1801a.f2337e = (agg) this.f2481d.get();
        c1801a.f2338f = (C1737a) this.f2483f.get();
        c1801a.f2339g = this.f2484g;
        c1801a.f2340h = (C1803a) this.f2485h.get();
        c1801a.f2341i = (C1802a) this.f2486i.get();
        c1801a.f2342j = (C1804a) this.f2487j.get();
        c1801a.f2343k = (C1809a) this.f2488k.get();
        c1801a.f2344l = (C1796a) this.f2489l.get();
        c1801a.f2345m = (C1741a) this.f2490m.get();
    }

    private lp(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<kd> provider4, Provider<C1737a> provider5, Provider<String> provider6, Provider<C1803a> provider7, Provider<C1802a> provider8, Provider<C1804a> provider9, Provider<C1809a> provider10, Provider<C1796a> provider11, Provider<C1741a> provider12) {
        if (f2478a || provider != null) {
            this.f2479b = provider;
            if (f2478a || provider2 != null) {
                this.f2480c = provider2;
                if (f2478a || provider3 != null) {
                    this.f2481d = provider3;
                    if (f2478a || provider4 != null) {
                        this.f2482e = provider4;
                        if (f2478a || provider5 != null) {
                            this.f2483f = provider5;
                            if (f2478a || provider6 != null) {
                                this.f2484g = provider6;
                                if (f2478a || provider7 != null) {
                                    this.f2485h = provider7;
                                    if (f2478a || provider8 != null) {
                                        this.f2486i = provider8;
                                        if (f2478a || provider9 != null) {
                                            this.f2487j = provider9;
                                            if (f2478a || provider10 != null) {
                                                this.f2488k = provider10;
                                                if (f2478a || provider11 != null) {
                                                    this.f2489l = provider11;
                                                    if (f2478a || provider12 != null) {
                                                        this.f2490m = provider12;
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

    public static MembersInjector<C1801a> m2132a(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<kd> provider4, Provider<C1737a> provider5, Provider<String> provider6, Provider<C1803a> provider7, Provider<C1802a> provider8, Provider<C1804a> provider9, Provider<C1809a> provider10, Provider<C1796a> provider11, Provider<C1741a> provider12) {
        return new lp(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }
}
