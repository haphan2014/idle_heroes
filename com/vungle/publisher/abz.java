package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1636b.C1634b;
import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.abx.C1655a;
import com.vungle.publisher.abx.C1655a.C1653a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class abz implements MembersInjector<C1655a> {
    static final /* synthetic */ boolean f983a = (!abz.class.desiredAssertionStatus());
    private final Provider<C1628a> f984b;
    private final Provider<pj> f985c;
    private final Provider<pr> f986d;
    private final Provider<C1634b> f987e;
    private final Provider<pq> f988f;
    private final Provider<C1642a> f989g;
    private final Provider<C1653a> f990h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1655a c1655a = (C1655a) obj;
        if (c1655a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1655a.f886a = (C1628a) this.f984b.get();
        c1655a.f887b = (pj) this.f985c.get();
        c1655a.f888c = (pr) this.f986d.get();
        c1655a.f889d = (C1634b) this.f987e.get();
        c1655a.f890e = (pq) this.f988f.get();
        c1655a.f951f = (C1642a) this.f989g.get();
        c1655a.f978g = (C1653a) this.f990h.get();
        c1655a.f979h = (C1642a) this.f989g.get();
    }

    private abz(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1653a> provider7) {
        if (f983a || provider != null) {
            this.f984b = provider;
            if (f983a || provider2 != null) {
                this.f985c = provider2;
                if (f983a || provider3 != null) {
                    this.f986d = provider3;
                    if (f983a || provider4 != null) {
                        this.f987e = provider4;
                        if (f983a || provider5 != null) {
                            this.f988f = provider5;
                            if (f983a || provider6 != null) {
                                this.f989g = provider6;
                                if (f983a || provider7 != null) {
                                    this.f990h = provider7;
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

    public static MembersInjector<C1655a> m977a(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1653a> provider7) {
        return new abz(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
