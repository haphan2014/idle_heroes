package com.vungle.publisher;

import com.vungle.publisher.ed.C1741a;
import com.vungle.publisher.ey.C1758a;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.fa.C1764a;
import com.vungle.publisher.ff.C1765a;
import com.vungle.publisher.ge.C1776a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gl implements MembersInjector<C1760a> {
    static final /* synthetic */ boolean f1984a = (!gl.class.desiredAssertionStatus());
    private final Provider<cq> f1985b;
    private final Provider<qh> f1986c;
    private final Provider<agg> f1987d;
    private final Provider<String> f1988e;
    private final Provider<C1764a> f1989f;
    private final Provider<ez> f1990g;
    private final Provider<C1758a> f1991h;
    private final Provider<C1765a> f1992i;
    private final Provider<C1741a> f1993j;
    private final Provider<C1776a> f1994k;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1760a c1760a = (C1760a) obj;
        if (c1760a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1760a.f1530d = (cq) this.f1985b.get();
        c1760a.f1531a = (qh) this.f1986c.get();
        c1760a.f1532b = (agg) this.f1987d.get();
        c1760a.f1842c = this.f1988e;
        c1760a.f1843e = (C1764a) this.f1989f.get();
        c1760a.f1844f = this.f1990g;
        c1760a.f1845g = (C1758a) this.f1991h.get();
        c1760a.f1846h = (C1765a) this.f1992i.get();
        c1760a.f1847i = (C1741a) this.f1993j.get();
        c1760a.f1848j = (C1776a) this.f1994k.get();
    }

    private gl(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<String> provider4, Provider<C1764a> provider5, Provider<ez> provider6, Provider<C1758a> provider7, Provider<C1765a> provider8, Provider<C1741a> provider9, Provider<C1776a> provider10) {
        if (f1984a || provider != null) {
            this.f1985b = provider;
            if (f1984a || provider2 != null) {
                this.f1986c = provider2;
                if (f1984a || provider3 != null) {
                    this.f1987d = provider3;
                    if (f1984a || provider4 != null) {
                        this.f1988e = provider4;
                        if (f1984a || provider5 != null) {
                            this.f1989f = provider5;
                            if (f1984a || provider6 != null) {
                                this.f1990g = provider6;
                                if (f1984a || provider7 != null) {
                                    this.f1991h = provider7;
                                    if (f1984a || provider8 != null) {
                                        this.f1992i = provider8;
                                        if (f1984a || provider9 != null) {
                                            this.f1993j = provider9;
                                            if (f1984a || provider10 != null) {
                                                this.f1994k = provider10;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1760a> m1835a(Provider<cq> provider, Provider<qh> provider2, Provider<agg> provider3, Provider<String> provider4, Provider<C1764a> provider5, Provider<ez> provider6, Provider<C1758a> provider7, Provider<C1765a> provider8, Provider<C1741a> provider9, Provider<C1776a> provider10) {
        return new gl(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }
}
