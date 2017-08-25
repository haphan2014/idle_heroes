package com.vungle.publisher;

import com.vungle.publisher.aak.C1627a;
import com.vungle.publisher.env.WrapperFramework;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aam implements MembersInjector<C1627a> {
    static final /* synthetic */ boolean f829a = (!aam.class.desiredAssertionStatus());
    private final Provider<pj> f830b;
    private final Provider<sn> f831c;
    private final Provider<pq> f832d;
    private final Provider<String> f833e;
    private final Provider<WrapperFramework> f834f;
    private final Provider<String> f835g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1627a c1627a = (C1627a) obj;
        if (c1627a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1627a, this.f830b);
        c1627a.f780b = (sn) this.f831c.get();
        c1627a.f781c = (pq) this.f832d.get();
        c1627a.f782d = (String) this.f833e.get();
        c1627a.f783e = (WrapperFramework) this.f834f.get();
        c1627a.f784f = (String) this.f835g.get();
        c1627a.f826g = (pj) this.f830b.get();
    }

    private aam(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6) {
        if (f829a || provider != null) {
            this.f830b = provider;
            if (f829a || provider2 != null) {
                this.f831c = provider2;
                if (f829a || provider3 != null) {
                    this.f832d = provider3;
                    if (f829a || provider4 != null) {
                        this.f833e = provider4;
                        if (f829a || provider5 != null) {
                            this.f834f = provider5;
                            if (f829a || provider6 != null) {
                                this.f835g = provider6;
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

    public static MembersInjector<C1627a> m851a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6) {
        return new aam(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
