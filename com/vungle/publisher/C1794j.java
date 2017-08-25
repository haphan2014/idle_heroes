package com.vungle.publisher;

import com.vungle.publisher.C1763f.C1762a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1794j implements MembersInjector<C1763f> {
    static final /* synthetic */ boolean f2226a = (!C1794j.class.desiredAssertionStatus());
    private final Provider<qh> f2227b;
    private final Provider<C1821m> f2228c;
    private final Provider<ce> f2229d;
    private final Provider<xp> f2230e;
    private final Provider<afl> f2231f;
    private final Provider<C1762a> f2232g;
    private final Provider<pu> f2233h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1763f c1763f = (C1763f) obj;
        if (c1763f == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1763f.f1341v = (qh) this.f2227b.get();
        c1763f.f1861a = (C1821m) this.f2228c.get();
        c1763f.f1862b = (ce) this.f2229d.get();
        c1763f.f1863c = (xp) this.f2230e.get();
        c1763f.f1864d = (afl) this.f2231f.get();
        c1763f.f1865e = (C1762a) this.f2232g.get();
        c1763f.f1866f = (pu) this.f2233h.get();
    }

    private C1794j(Provider<qh> provider, Provider<C1821m> provider2, Provider<ce> provider3, Provider<xp> provider4, Provider<afl> provider5, Provider<C1762a> provider6, Provider<pu> provider7) {
        if (f2226a || provider != null) {
            this.f2227b = provider;
            if (f2226a || provider2 != null) {
                this.f2228c = provider2;
                if (f2226a || provider3 != null) {
                    this.f2229d = provider3;
                    if (f2226a || provider4 != null) {
                        this.f2230e = provider4;
                        if (f2226a || provider5 != null) {
                            this.f2231f = provider5;
                            if (f2226a || provider6 != null) {
                                this.f2232g = provider6;
                                if (f2226a || provider7 != null) {
                                    this.f2233h = provider7;
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

    public static MembersInjector<C1763f> m1994a(Provider<qh> provider, Provider<C1821m> provider2, Provider<ce> provider3, Provider<xp> provider4, Provider<afl> provider5, Provider<C1762a> provider6, Provider<pu> provider7) {
        return new C1794j(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
