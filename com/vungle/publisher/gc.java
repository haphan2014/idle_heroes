package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.dz.C1739a;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.fp.C1769a;
import com.vungle.publisher.fu.C1771a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gc implements MembersInjector<C1771a> {
    static final /* synthetic */ boolean f1952a = (!gc.class.desiredAssertionStatus());
    private final Provider<cq> f1953b;
    private final Provider<C1733a> f1954c;
    private final Provider<C1723a> f1955d;
    private final Provider<C1760a> f1956e;
    private final Provider<C1769a> f1957f;
    private final Provider<fu> f1958g;
    private final Provider<C1739a> f1959h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1771a c1771a = (C1771a) obj;
        if (c1771a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1771a.f1530d = (cq) this.f1953b.get();
        c1771a.f1588a = (C1733a) this.f1954c.get();
        c1771a.f1589b = (C1723a) this.f1955d.get();
        c1771a.f1927c = (C1760a) this.f1956e.get();
        c1771a.f1928e = (C1769a) this.f1957f.get();
        c1771a.f1929f = this.f1958g;
        c1771a.f1930g = (C1739a) this.f1959h.get();
    }

    private gc(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1760a> provider4, Provider<C1769a> provider5, Provider<fu> provider6, Provider<C1739a> provider7) {
        if (f1952a || provider != null) {
            this.f1953b = provider;
            if (f1952a || provider2 != null) {
                this.f1954c = provider2;
                if (f1952a || provider3 != null) {
                    this.f1955d = provider3;
                    if (f1952a || provider4 != null) {
                        this.f1956e = provider4;
                        if (f1952a || provider5 != null) {
                            this.f1957f = provider5;
                            if (f1952a || provider6 != null) {
                                this.f1958g = provider6;
                                if (f1952a || provider7 != null) {
                                    this.f1959h = provider7;
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

    public static MembersInjector<C1771a> m1815a(Provider<cq> provider, Provider<C1733a> provider2, Provider<C1723a> provider3, Provider<C1760a> provider4, Provider<C1769a> provider5, Provider<fu> provider6, Provider<C1739a> provider7) {
        return new gc(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
