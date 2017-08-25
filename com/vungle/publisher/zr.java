package com.vungle.publisher;

import com.vungle.publisher.adv.C1677a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.zp.C1926a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zr implements MembersInjector<C1926a> {
    static final /* synthetic */ boolean f3800a = (!zr.class.desiredAssertionStatus());
    private final Provider<pj> f3801b;
    private final Provider<sn> f3802c;
    private final Provider<pq> f3803d;
    private final Provider<String> f3804e;
    private final Provider<WrapperFramework> f3805f;
    private final Provider<String> f3806g;
    private final Provider<C1677a> f3807h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1926a c1926a = (C1926a) obj;
        if (c1926a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1926a, this.f3801b);
        c1926a.f780b = (sn) this.f3802c.get();
        c1926a.f781c = (pq) this.f3803d.get();
        c1926a.f782d = (String) this.f3804e.get();
        c1926a.f783e = (WrapperFramework) this.f3805f.get();
        c1926a.f784f = (String) this.f3806g.get();
        c1926a.f3797g = (C1677a) this.f3807h.get();
    }

    private zr(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1677a> provider7) {
        if (f3800a || provider != null) {
            this.f3801b = provider;
            if (f3800a || provider2 != null) {
                this.f3802c = provider2;
                if (f3800a || provider3 != null) {
                    this.f3803d = provider3;
                    if (f3800a || provider4 != null) {
                        this.f3804e = provider4;
                        if (f3800a || provider5 != null) {
                            this.f3805f = provider5;
                            if (f3800a || provider6 != null) {
                                this.f3806g = provider6;
                                if (f3800a || provider7 != null) {
                                    this.f3807h = provider7;
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

    public static MembersInjector<C1926a> m2717a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1677a> provider7) {
        return new zr(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
