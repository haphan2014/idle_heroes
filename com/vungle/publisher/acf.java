package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1636b.C1634b;
import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.abk.C1646a;
import com.vungle.publisher.acd.C1656a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class acf implements MembersInjector<C1656a> {
    static final /* synthetic */ boolean f1001a = (!acf.class.desiredAssertionStatus());
    private final Provider<C1628a> f1002b;
    private final Provider<pj> f1003c;
    private final Provider<pr> f1004d;
    private final Provider<C1634b> f1005e;
    private final Provider<pq> f1006f;
    private final Provider<C1642a> f1007g;
    private final Provider<C1646a> f1008h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1656a c1656a = (C1656a) obj;
        if (c1656a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1656a.f886a = (C1628a) this.f1002b.get();
        c1656a.f887b = (pj) this.f1003c.get();
        c1656a.f888c = (pr) this.f1004d.get();
        c1656a.f889d = (C1634b) this.f1005e.get();
        c1656a.f890e = (pq) this.f1006f.get();
        c1656a.f951f = (C1642a) this.f1007g.get();
        c1656a.f998g = (C1646a) this.f1008h.get();
    }

    private acf(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1646a> provider7) {
        if (f1001a || provider != null) {
            this.f1002b = provider;
            if (f1001a || provider2 != null) {
                this.f1003c = provider2;
                if (f1001a || provider3 != null) {
                    this.f1004d = provider3;
                    if (f1001a || provider4 != null) {
                        this.f1005e = provider4;
                        if (f1001a || provider5 != null) {
                            this.f1006f = provider5;
                            if (f1001a || provider6 != null) {
                                this.f1007g = provider6;
                                if (f1001a || provider7 != null) {
                                    this.f1008h = provider7;
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

    public static MembersInjector<C1656a> m985a(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1646a> provider7) {
        return new acf(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
