package com.vungle.publisher;

import com.vungle.publisher.dm.C1734a;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.fa.C1764a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.lr.C1811a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fe implements MembersInjector<fa> {
    static final /* synthetic */ boolean f1882a = (!fe.class.desiredAssertionStatus());
    private final Provider<cq> f1883b;
    private final Provider<C1778a> f1884c;
    private final Provider<C1734a> f1885d;
    private final Provider<gs> f1886e;
    private final Provider<C1760a> f1887f;
    private final Provider<C1764a> f1888g;
    private final Provider<C1811a> f1889h;

    public final /* synthetic */ void injectMembers(Object obj) {
        fa faVar = (fa) obj;
        if (faVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        faVar.f1551v = (cq) this.f1883b.get();
        faVar.f1822e = (C1778a) this.f1884c.get();
        faVar.f1823f = (C1734a) this.f1885d.get();
        faVar.f1824g = (gs) this.f1886e.get();
        faVar.f1870h = (C1760a) this.f1887f.get();
        faVar.f1871i = (C1764a) this.f1888g.get();
        faVar.f1872j = (C1811a) this.f1889h.get();
    }

    private fe(Provider<cq> provider, Provider<C1778a> provider2, Provider<C1734a> provider3, Provider<gs> provider4, Provider<C1760a> provider5, Provider<C1764a> provider6, Provider<C1811a> provider7) {
        if (f1882a || provider != null) {
            this.f1883b = provider;
            if (f1882a || provider2 != null) {
                this.f1884c = provider2;
                if (f1882a || provider3 != null) {
                    this.f1885d = provider3;
                    if (f1882a || provider4 != null) {
                        this.f1886e = provider4;
                        if (f1882a || provider5 != null) {
                            this.f1887f = provider5;
                            if (f1882a || provider6 != null) {
                                this.f1888g = provider6;
                                if (f1882a || provider7 != null) {
                                    this.f1889h = provider7;
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

    public static MembersInjector<fa> m1773a(Provider<cq> provider, Provider<C1778a> provider2, Provider<C1734a> provider3, Provider<gs> provider4, Provider<C1760a> provider5, Provider<C1764a> provider6, Provider<C1811a> provider7) {
        return new fe(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
