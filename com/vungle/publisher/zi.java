package com.vungle.publisher;

import com.vungle.publisher.adk.C1672a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.zg.C1924a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zi implements MembersInjector<C1924a> {
    static final /* synthetic */ boolean f3762a = (!zi.class.desiredAssertionStatus());
    private final Provider<pj> f3763b;
    private final Provider<sn> f3764c;
    private final Provider<pq> f3765d;
    private final Provider<String> f3766e;
    private final Provider<WrapperFramework> f3767f;
    private final Provider<String> f3768g;
    private final Provider<C1672a> f3769h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1924a c1924a = (C1924a) obj;
        if (c1924a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1924a, this.f3763b);
        c1924a.f780b = (sn) this.f3764c.get();
        c1924a.f781c = (pq) this.f3765d.get();
        c1924a.f782d = (String) this.f3766e.get();
        c1924a.f783e = (WrapperFramework) this.f3767f.get();
        c1924a.f784f = (String) this.f3768g.get();
        c1924a.f3759g = (C1672a) this.f3769h.get();
    }

    private zi(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1672a> provider7) {
        if (f3762a || provider != null) {
            this.f3763b = provider;
            if (f3762a || provider2 != null) {
                this.f3764c = provider2;
                if (f3762a || provider3 != null) {
                    this.f3765d = provider3;
                    if (f3762a || provider4 != null) {
                        this.f3766e = provider4;
                        if (f3762a || provider5 != null) {
                            this.f3767f = provider5;
                            if (f3762a || provider6 != null) {
                                this.f3768g = provider6;
                                if (f3762a || provider7 != null) {
                                    this.f3769h = provider7;
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

    public static MembersInjector<C1924a> m2694a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1672a> provider7) {
        return new zi(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
