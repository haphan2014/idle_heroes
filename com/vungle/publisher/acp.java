package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1636b.C1634b;
import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.acn.C1660a;
import com.vungle.publisher.aej.C1682a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class acp implements MembersInjector<C1660a> {
    static final /* synthetic */ boolean f1033a = (!acp.class.desiredAssertionStatus());
    private final Provider<C1628a> f1034b;
    private final Provider<pj> f1035c;
    private final Provider<pr> f1036d;
    private final Provider<C1634b> f1037e;
    private final Provider<pq> f1038f;
    private final Provider<C1642a> f1039g;
    private final Provider<C1682a> f1040h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1660a c1660a = (C1660a) obj;
        if (c1660a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1660a.f886a = (C1628a) this.f1034b.get();
        c1660a.f887b = (pj) this.f1035c.get();
        c1660a.f888c = (pr) this.f1036d.get();
        c1660a.f889d = (C1634b) this.f1037e.get();
        c1660a.f890e = (pq) this.f1038f.get();
        c1660a.f951f = (C1642a) this.f1039g.get();
        c1660a.f1029g = (C1682a) this.f1040h.get();
    }

    private acp(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1682a> provider7) {
        if (f1033a || provider != null) {
            this.f1034b = provider;
            if (f1033a || provider2 != null) {
                this.f1035c = provider2;
                if (f1033a || provider3 != null) {
                    this.f1036d = provider3;
                    if (f1033a || provider4 != null) {
                        this.f1037e = provider4;
                        if (f1033a || provider5 != null) {
                            this.f1038f = provider5;
                            if (f1033a || provider6 != null) {
                                this.f1039g = provider6;
                                if (f1033a || provider7 != null) {
                                    this.f1040h = provider7;
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

    public static MembersInjector<C1660a> m1002a(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1682a> provider7) {
        return new acp(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
