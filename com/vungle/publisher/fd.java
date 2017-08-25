package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.fa.C1764a;
import com.vungle.publisher.gs.C1777a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fd implements MembersInjector<C1764a> {
    static final /* synthetic */ boolean f1877a = (!fd.class.desiredAssertionStatus());
    private final Provider<cq> f1878b;
    private final Provider<C1892a> f1879c;
    private final Provider<C1777a> f1880d;
    private final Provider<fa> f1881e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1764a c1764a = (C1764a) obj;
        if (c1764a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1764a.f1530d = (cq) this.f1878b.get();
        c1764a.f1676e = (C1892a) this.f1879c.get();
        c1764a.f1817a = (C1777a) this.f1880d.get();
        c1764a.f1869b = this.f1881e;
    }

    private fd(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1777a> provider3, Provider<fa> provider4) {
        if (f1877a || provider != null) {
            this.f1878b = provider;
            if (f1877a || provider2 != null) {
                this.f1879c = provider2;
                if (f1877a || provider3 != null) {
                    this.f1880d = provider3;
                    if (f1877a || provider4 != null) {
                        this.f1881e = provider4;
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

    public static MembersInjector<C1764a> m1772a(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1777a> provider3, Provider<fa> provider4) {
        return new fd(provider, provider2, provider3, provider4);
    }
}
