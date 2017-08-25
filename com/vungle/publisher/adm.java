package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1636b.C1634b;
import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.adk.C1672a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adm implements MembersInjector<C1672a> {
    static final /* synthetic */ boolean f1142a = (!adm.class.desiredAssertionStatus());
    private final Provider<C1628a> f1143b;
    private final Provider<pj> f1144c;
    private final Provider<pr> f1145d;
    private final Provider<C1634b> f1146e;
    private final Provider<pq> f1147f;
    private final Provider<C1642a> f1148g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1672a c1672a = (C1672a) obj;
        if (c1672a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1672a.f886a = (C1628a) this.f1143b.get();
        c1672a.f887b = (pj) this.f1144c.get();
        c1672a.f888c = (pr) this.f1145d.get();
        c1672a.f889d = (C1634b) this.f1146e.get();
        c1672a.f890e = (pq) this.f1147f.get();
        c1672a.f1136f = (C1642a) this.f1148g.get();
    }

    private adm(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6) {
        if (f1142a || provider != null) {
            this.f1143b = provider;
            if (f1142a || provider2 != null) {
                this.f1144c = provider2;
                if (f1142a || provider3 != null) {
                    this.f1145d = provider3;
                    if (f1142a || provider4 != null) {
                        this.f1146e = provider4;
                        if (f1142a || provider5 != null) {
                            this.f1147f = provider5;
                            if (f1142a || provider6 != null) {
                                this.f1148g = provider6;
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

    public static MembersInjector<C1672a> m1076a(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1642a> provider6) {
        return new adm(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
