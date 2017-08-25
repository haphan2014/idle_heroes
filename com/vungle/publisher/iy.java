package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.cv.C1723a;
import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.il.C1791a;
import com.vungle.publisher.iq.C1792a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class iy implements MembersInjector<C1792a> {
    static final /* synthetic */ boolean f2213a = (!iy.class.desiredAssertionStatus());
    private final Provider<cq> f2214b;
    private final Provider<C1733a> f2215c;
    private final Provider<C1723a> f2216d;
    private final Provider<C1791a> f2217e;
    private final Provider<C1788a> f2218f;
    private final Provider<iq> f2219g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1792a c1792a = (C1792a) obj;
        if (c1792a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1792a.f1530d = (cq) this.f2214b.get();
        c1792a.f1588a = (C1733a) this.f2215c.get();
        c1792a.f1589b = (C1723a) this.f2216d.get();
        c1792a.f2192c = (C1791a) this.f2217e.get();
        c1792a.f2193e = (C1788a) this.f2218f.get();
        c1792a.f2194f = this.f2219g;
    }

    private iy(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1791a> provider4, Provider<C1788a> provider5, Provider<iq> provider6) {
        if (f2213a || provider != null) {
            this.f2214b = provider;
            if (f2213a || provider2 != null) {
                this.f2215c = provider2;
                if (f2213a || provider3 != null) {
                    this.f2216d = provider3;
                    if (f2213a || provider4 != null) {
                        this.f2217e = provider4;
                        if (f2213a || provider5 != null) {
                            this.f2218f = provider5;
                            if (f2213a || provider6 != null) {
                                this.f2219g = provider6;
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

    public static MembersInjector<C1792a> m1992a(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1791a> provider4, Provider<C1788a> provider5, Provider<iq> provider6) {
        return new iy(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
