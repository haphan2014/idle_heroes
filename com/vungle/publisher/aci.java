package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1636b.C1634b;
import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.acg.C1659a;
import com.vungle.publisher.acg.C1659a.C1658a;
import com.vungle.publisher.adk.C1672a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aci implements MembersInjector<C1659a> {
    static final /* synthetic */ boolean f1014a = (!aci.class.desiredAssertionStatus());
    private final Provider<C1628a> f1015b;
    private final Provider<pj> f1016c;
    private final Provider<pr> f1017d;
    private final Provider<C1634b> f1018e;
    private final Provider<pq> f1019f;
    private final Provider<C1642a> f1020g;
    private final Provider<C1658a> f1021h;
    private final Provider<C1672a> f1022i;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1659a c1659a = (C1659a) obj;
        if (c1659a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1659a.f886a = (C1628a) this.f1015b.get();
        c1659a.f887b = (pj) this.f1016c.get();
        c1659a.f888c = (pr) this.f1017d.get();
        c1659a.f889d = (C1634b) this.f1018e.get();
        c1659a.f890e = (pq) this.f1019f.get();
        c1659a.f951f = (C1642a) this.f1020g.get();
        c1659a.f1010g = (C1658a) this.f1021h.get();
        c1659a.f1011h = (C1672a) this.f1022i.get();
    }

    private aci(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1658a> provider7, Provider<C1672a> provider8) {
        if (f1014a || provider != null) {
            this.f1015b = provider;
            if (f1014a || provider2 != null) {
                this.f1016c = provider2;
                if (f1014a || provider3 != null) {
                    this.f1017d = provider3;
                    if (f1014a || provider4 != null) {
                        this.f1018e = provider4;
                        if (f1014a || provider5 != null) {
                            this.f1019f = provider5;
                            if (f1014a || provider6 != null) {
                                this.f1020g = provider6;
                                if (f1014a || provider7 != null) {
                                    this.f1021h = provider7;
                                    if (f1014a || provider8 != null) {
                                        this.f1022i = provider8;
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

    public static MembersInjector<C1659a> m991a(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6, Provider<C1658a> provider7, Provider<C1672a> provider8) {
        return new aci(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
