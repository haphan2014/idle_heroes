package com.vungle.publisher;

import com.vungle.publisher.abx.C1655a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.yc.C1916a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ye implements MembersInjector<C1916a> {
    static final /* synthetic */ boolean f3656a = (!ye.class.desiredAssertionStatus());
    private final Provider<pj> f3657b;
    private final Provider<sn> f3658c;
    private final Provider<pq> f3659d;
    private final Provider<String> f3660e;
    private final Provider<WrapperFramework> f3661f;
    private final Provider<String> f3662g;
    private final Provider<C1655a> f3663h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1916a c1916a = (C1916a) obj;
        if (c1916a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1916a, this.f3657b);
        c1916a.f780b = (sn) this.f3658c.get();
        c1916a.f781c = (pq) this.f3659d.get();
        c1916a.f782d = (String) this.f3660e.get();
        c1916a.f783e = (WrapperFramework) this.f3661f.get();
        c1916a.f784f = (String) this.f3662g.get();
        c1916a.f3653g = (C1655a) this.f3663h.get();
    }

    private ye(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1655a> provider7) {
        if (f3656a || provider != null) {
            this.f3657b = provider;
            if (f3656a || provider2 != null) {
                this.f3658c = provider2;
                if (f3656a || provider3 != null) {
                    this.f3659d = provider3;
                    if (f3656a || provider4 != null) {
                        this.f3660e = provider4;
                        if (f3656a || provider5 != null) {
                            this.f3661f = provider5;
                            if (f3656a || provider6 != null) {
                                this.f3662g = provider6;
                                if (f3656a || provider7 != null) {
                                    this.f3663h = provider7;
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

    public static MembersInjector<C1916a> m2644a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1655a> provider7) {
        return new ye(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
