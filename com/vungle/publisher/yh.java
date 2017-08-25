package com.vungle.publisher;

import com.vungle.publisher.acd.C1656a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.yf.C1917a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yh implements MembersInjector<C1917a> {
    static final /* synthetic */ boolean f3667a = (!yh.class.desiredAssertionStatus());
    private final Provider<pj> f3668b;
    private final Provider<sn> f3669c;
    private final Provider<pq> f3670d;
    private final Provider<String> f3671e;
    private final Provider<WrapperFramework> f3672f;
    private final Provider<String> f3673g;
    private final Provider<C1656a> f3674h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1917a c1917a = (C1917a) obj;
        if (c1917a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1917a, this.f3668b);
        c1917a.f780b = (sn) this.f3669c.get();
        c1917a.f781c = (pq) this.f3670d.get();
        c1917a.f782d = (String) this.f3671e.get();
        c1917a.f783e = (WrapperFramework) this.f3672f.get();
        c1917a.f784f = (String) this.f3673g.get();
        c1917a.f3664g = (C1656a) this.f3674h.get();
    }

    private yh(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1656a> provider7) {
        if (f3667a || provider != null) {
            this.f3668b = provider;
            if (f3667a || provider2 != null) {
                this.f3669c = provider2;
                if (f3667a || provider3 != null) {
                    this.f3670d = provider3;
                    if (f3667a || provider4 != null) {
                        this.f3671e = provider4;
                        if (f3667a || provider5 != null) {
                            this.f3672f = provider5;
                            if (f3667a || provider6 != null) {
                                this.f3673g = provider6;
                                if (f3667a || provider7 != null) {
                                    this.f3674h = provider7;
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

    public static MembersInjector<C1917a> m2649a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1656a> provider7) {
        return new yh(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
