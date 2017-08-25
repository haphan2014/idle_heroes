package com.vungle.publisher;

import com.vungle.publisher.acn.C1660a;
import com.vungle.publisher.env.WrapperFramework;
import com.vungle.publisher.yl.C1919a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yn implements MembersInjector<C1919a> {
    static final /* synthetic */ boolean f3689a = (!yn.class.desiredAssertionStatus());
    private final Provider<pj> f3690b;
    private final Provider<sn> f3691c;
    private final Provider<pq> f3692d;
    private final Provider<String> f3693e;
    private final Provider<WrapperFramework> f3694f;
    private final Provider<String> f3695g;
    private final Provider<C1660a> f3696h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1919a c1919a = (C1919a) obj;
        if (c1919a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vk.m2547a(c1919a, this.f3690b);
        c1919a.f780b = (sn) this.f3691c.get();
        c1919a.f781c = (pq) this.f3692d.get();
        c1919a.f782d = (String) this.f3693e.get();
        c1919a.f783e = (WrapperFramework) this.f3694f.get();
        c1919a.f784f = (String) this.f3695g.get();
        c1919a.f3686g = (C1660a) this.f3696h.get();
    }

    private yn(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1660a> provider7) {
        if (f3689a || provider != null) {
            this.f3690b = provider;
            if (f3689a || provider2 != null) {
                this.f3691c = provider2;
                if (f3689a || provider3 != null) {
                    this.f3692d = provider3;
                    if (f3689a || provider4 != null) {
                        this.f3693e = provider4;
                        if (f3689a || provider5 != null) {
                            this.f3694f = provider5;
                            if (f3689a || provider6 != null) {
                                this.f3695g = provider6;
                                if (f3689a || provider7 != null) {
                                    this.f3696h = provider7;
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

    public static MembersInjector<C1919a> m2659a(Provider<pj> provider, Provider<sn> provider2, Provider<pq> provider3, Provider<String> provider4, Provider<WrapperFramework> provider5, Provider<String> provider6, Provider<C1660a> provider7) {
        return new yn(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
