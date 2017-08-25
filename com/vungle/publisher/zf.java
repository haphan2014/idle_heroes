package com.vungle.publisher;

import com.vungle.publisher.ada.C1666a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.zd.C1923a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zf implements MembersInjector<C1923a> {
    static final /* synthetic */ boolean f3751a = (!zf.class.desiredAssertionStatus());
    private final Provider<pj> f3752b;
    private final Provider<sn> f3753c;
    private final Provider<pq> f3754d;
    private final Provider<String> f3755e;
    private final Provider<WrapperFramework> f3756f;
    private final Provider<String> f3757g;
    private final Provider<C1666a> f3758h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1923a c1923a = (C1923a) obj;
        if (c1923a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1923a, this.f3752b);
        c1923a.f780b = (sn) this.f3753c.get();
        c1923a.f781c = (pq) this.f3754d.get();
        c1923a.f782d = (String) this.f3755e.get();
        c1923a.f783e = (WrapperFramework) this.f3756f.get();
        c1923a.f784f = (String) this.f3757g.get();
        c1923a.f3747g = (C1666a) this.f3758h.get();
    }

    private zf(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1666a> provider7) {
        if (f3751a || provider != null) {
            this.f3752b = provider;
            if (f3751a || provider2 != null) {
                this.f3753c = provider2;
                if (f3751a || provider3 != null) {
                    this.f3754d = provider3;
                    if (f3751a || provider4 != null) {
                        this.f3755e = provider4;
                        if (f3751a || provider5 != null) {
                            this.f3756f = provider5;
                            if (f3751a || provider6 != null) {
                                this.f3757g = provider6;
                                if (f3751a || provider7 != null) {
                                    this.f3758h = provider7;
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

    public static MembersInjector<C1923a> m2688a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1666a> provider7) {
        return new zf(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
