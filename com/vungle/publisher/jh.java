package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.ie.C1787a;
import com.vungle.publisher.ja.C1795a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class jh implements MembersInjector<C1788a> {
    static final /* synthetic */ boolean f2250a = (!jh.class.desiredAssertionStatus());
    private final Provider<cq> f2251b;
    private final Provider<qh> f2252c;
    private final Provider<agg> f2253d;
    private final Provider<C1789if> f2254e;
    private final Provider<C1787a> f2255f;
    private final Provider<C1795a> f2256g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1788a c1788a = (C1788a) obj;
        if (c1788a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1788a.f1530d = (cq) this.f2251b.get();
        c1788a.f1531a = (qh) this.f2252c.get();
        c1788a.f1532b = (agg) this.f2253d.get();
        c1788a.f2155c = this.f2254e;
        c1788a.f2156e = (C1787a) this.f2255f.get();
        c1788a.f2157f = (C1795a) this.f2256g.get();
    }

    private jh(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<C1789if> provider4, Provider<C1787a> provider5, Provider<C1795a> provider6) {
        if (f2250a || provider != null) {
            this.f2251b = provider;
            if (f2250a || provider2 != null) {
                this.f2252c = provider2;
                if (f2250a || provider3 != null) {
                    this.f2253d = provider3;
                    if (f2250a || provider4 != null) {
                        this.f2254e = provider4;
                        if (f2250a || provider5 != null) {
                            this.f2255f = provider5;
                            if (f2250a || provider6 != null) {
                                this.f2256g = provider6;
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

    public static MembersInjector<C1788a> m2004a(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<C1789if> provider4, Provider<C1787a> provider5, Provider<C1795a> provider6) {
        return new jh(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
