package com.vungle.publisher;

import com.vungle.publisher.ady.C1678a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.zv.C1927a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zx implements MembersInjector<C1927a> {
    static final /* synthetic */ boolean f3819a = (!zx.class.desiredAssertionStatus());
    private final Provider<pj> f3820b;
    private final Provider<sn> f3821c;
    private final Provider<pq> f3822d;
    private final Provider<String> f3823e;
    private final Provider<WrapperFramework> f3824f;
    private final Provider<String> f3825g;
    private final Provider<C1678a> f3826h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1927a c1927a = (C1927a) obj;
        if (c1927a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1927a, this.f3820b);
        c1927a.f780b = (sn) this.f3821c.get();
        c1927a.f781c = (pq) this.f3822d.get();
        c1927a.f782d = (String) this.f3823e.get();
        c1927a.f783e = (WrapperFramework) this.f3824f.get();
        c1927a.f784f = (String) this.f3825g.get();
        c1927a.f3816g = (C1678a) this.f3826h.get();
    }

    private zx(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1678a> provider7) {
        if (f3819a || provider != null) {
            this.f3820b = provider;
            if (f3819a || provider2 != null) {
                this.f3821c = provider2;
                if (f3819a || provider3 != null) {
                    this.f3822d = provider3;
                    if (f3819a || provider4 != null) {
                        this.f3823e = provider4;
                        if (f3819a || provider5 != null) {
                            this.f3824f = provider5;
                            if (f3819a || provider6 != null) {
                                this.f3825g = provider6;
                                if (f3819a || provider7 != null) {
                                    this.f3826h = provider7;
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

    public static MembersInjector<C1927a> m2726a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1678a> provider7) {
        return new zx(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
