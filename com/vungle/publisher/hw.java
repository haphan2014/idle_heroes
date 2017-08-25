package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.hd.C1780a;
import com.vungle.publisher.hj.C1782a;
import com.vungle.publisher.ho.C1783a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hw implements MembersInjector<C1783a> {
    static final /* synthetic */ boolean f2104a = (!hw.class.desiredAssertionStatus());
    private final Provider<cq> f2105b;
    private final Provider<C1733a> f2106c;
    private final Provider<C1723a> f2107d;
    private final Provider<C1780a> f2108e;
    private final Provider<C1782a> f2109f;
    private final Provider<ho> f2110g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1783a c1783a = (C1783a) obj;
        if (c1783a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1783a.f1530d = (cq) this.f2105b.get();
        c1783a.f1588a = (C1733a) this.f2106c.get();
        c1783a.f1589b = (C1723a) this.f2107d.get();
        c1783a.f2084c = (C1780a) this.f2108e.get();
        c1783a.f2085e = (C1782a) this.f2109f.get();
        c1783a.f2086f = this.f2110g;
    }

    private hw(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1780a> provider4, Provider<C1782a> provider5, Provider<ho> provider6) {
        if (f2104a || provider != null) {
            this.f2105b = provider;
            if (f2104a || provider2 != null) {
                this.f2106c = provider2;
                if (f2104a || provider3 != null) {
                    this.f2107d = provider3;
                    if (f2104a || provider4 != null) {
                        this.f2108e = provider4;
                        if (f2104a || provider5 != null) {
                            this.f2109f = provider5;
                            if (f2104a || provider6 != null) {
                                this.f2110g = provider6;
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

    public static MembersInjector<C1783a> m1926a(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1780a> provider4, Provider<C1782a> provider5, Provider<ho> provider6) {
        return new hw(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
