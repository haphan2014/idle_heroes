package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ti.C1887a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class sy implements MembersInjector<su> {
    static final /* synthetic */ boolean f3223a = (!sy.class.desiredAssertionStatus());
    private final Provider<C1778a> f3224b;
    private final Provider<qh> f3225c;
    private final Provider<te> f3226d;
    private final Provider<C1887a> f3227e;
    private final Provider<ch> f3228f;
    private final Provider<pj> f3229g;

    public final /* synthetic */ void injectMembers(Object obj) {
        su suVar = (su) obj;
        if (suVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        suVar.f3208d = (C1778a) this.f3224b.get();
        suVar.f3209e = (qh) this.f3225c.get();
        suVar.f3210f = (te) this.f3226d.get();
        suVar.f3211g = (C1887a) this.f3227e.get();
        suVar.f3212h = (ch) this.f3228f.get();
        suVar.f3213i = (pj) this.f3229g.get();
    }

    private sy(Provider<C1778a> provider, Provider<qh> provider2, Provider<te> provider3, Provider<C1887a> provider4, Provider<ch> provider5, Provider<pj> provider6) {
        if (f3223a || provider != null) {
            this.f3224b = provider;
            if (f3223a || provider2 != null) {
                this.f3225c = provider2;
                if (f3223a || provider3 != null) {
                    this.f3226d = provider3;
                    if (f3223a || provider4 != null) {
                        this.f3227e = provider4;
                        if (f3223a || provider5 != null) {
                            this.f3228f = provider5;
                            if (f3223a || provider6 != null) {
                                this.f3229g = provider6;
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

    public static MembersInjector<su> m2486a(Provider<C1778a> provider, Provider<qh> provider2, Provider<te> provider3, Provider<C1887a> provider4, Provider<ch> provider5, Provider<pj> provider6) {
        return new sy(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
