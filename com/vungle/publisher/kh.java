package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.gs.C1777a;
import com.vungle.publisher.ke.C1802a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class kh implements MembersInjector<C1802a> {
    static final /* synthetic */ boolean f2363a = (!kh.class.desiredAssertionStatus());
    private final Provider<cq> f2364b;
    private final Provider<C1892a> f2365c;
    private final Provider<C1777a> f2366d;
    private final Provider<ke> f2367e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1802a c1802a = (C1802a) obj;
        if (c1802a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1802a.f1530d = (cq) this.f2364b.get();
        c1802a.f1676e = (C1892a) this.f2365c.get();
        c1802a.f1817a = (C1777a) this.f2366d.get();
        c1802a.f2356b = this.f2367e;
    }

    private kh(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1777a> provider3, Provider<ke> provider4) {
        if (f2363a || provider != null) {
            this.f2364b = provider;
            if (f2363a || provider2 != null) {
                this.f2365c = provider2;
                if (f2363a || provider3 != null) {
                    this.f2366d = provider3;
                    if (f2363a || provider4 != null) {
                        this.f2367e = provider4;
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

    public static MembersInjector<C1802a> m2066a(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1777a> provider3, Provider<ke> provider4) {
        return new kh(provider, provider2, provider3, provider4);
    }
}
