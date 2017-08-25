package com.vungle.publisher;

import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ni.C1832a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class C1740e implements MembersInjector<C1618d> {
    static final /* synthetic */ boolean f1707a = (!C1740e.class.desiredAssertionStatus());
    private final Provider<qh> f1708b;
    private final Provider<ch> f1709c;
    private final Provider<pu> f1710d;
    private final Provider<C1721b> f1711e;
    private final Provider<mc> f1712f;
    private final Provider<C1778a> f1713g;
    private final Provider<C1832a> f1714h;
    private final Provider<ac> f1715i;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1618d c1618d = (C1618d) obj;
        if (c1618d == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1618d.f747b = (qh) this.f1708b.get();
        c1618d.f748c = (ch) this.f1709c.get();
        c1618d.f749d = (pu) this.f1710d.get();
        c1618d.f750e = (C1721b) this.f1711e.get();
        c1618d.f751f = (mc) this.f1712f.get();
        c1618d.f752g = (C1778a) this.f1713g.get();
        c1618d.f753h = (C1832a) this.f1714h.get();
        c1618d.f754i = (ac) this.f1715i.get();
    }

    private C1740e(Provider<qh> provider, Provider<ch> provider2, Provider<pu> provider3, Provider<C1721b> provider4, Provider<mc> provider5, Provider<C1778a> provider6, Provider<C1832a> provider7, Provider<ac> provider8) {
        if (f1707a || provider != null) {
            this.f1708b = provider;
            if (f1707a || provider2 != null) {
                this.f1709c = provider2;
                if (f1707a || provider3 != null) {
                    this.f1710d = provider3;
                    if (f1707a || provider4 != null) {
                        this.f1711e = provider4;
                        if (f1707a || provider5 != null) {
                            this.f1712f = provider5;
                            if (f1707a || provider6 != null) {
                                this.f1713g = provider6;
                                if (f1707a || provider7 != null) {
                                    this.f1714h = provider7;
                                    if (f1707a || provider8 != null) {
                                        this.f1715i = provider8;
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

    public static MembersInjector<C1618d> m1556a(Provider<qh> provider, Provider<ch> provider2, Provider<pu> provider3, Provider<C1721b> provider4, Provider<mc> provider5, Provider<C1778a> provider6, Provider<C1832a> provider7, Provider<ac> provider8) {
        return new C1740e(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
