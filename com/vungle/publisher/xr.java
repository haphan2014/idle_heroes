package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xr implements MembersInjector<xp> {
    static final /* synthetic */ boolean f3610a = (!xr.class.desiredAssertionStatus());
    private final Provider<qh> f3611b;
    private final Provider<xz> f3612c;
    private final Provider<za> f3613d;
    private final Provider<zm> f3614e;
    private final Provider<zs> f3615f;
    private final Provider<zy> f3616g;
    private final Provider<aah> f3617h;
    private final Provider<aan> f3618i;
    private final Provider<C1778a> f3619j;
    private final Provider<ce> f3620k;

    public final /* synthetic */ void injectMembers(Object obj) {
        xp xpVar = (xp) obj;
        if (xpVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        xpVar.f3598a = (qh) this.f3611b.get();
        xpVar.f3599b = (xz) this.f3612c.get();
        xpVar.f3600c = (za) this.f3613d.get();
        xpVar.f3601d = (zm) this.f3614e.get();
        xpVar.f3602e = (zs) this.f3615f.get();
        xpVar.f3603f = (zy) this.f3616g.get();
        xpVar.f3604g = DoubleCheck.lazy(this.f3617h);
        xpVar.f3605h = (aan) this.f3618i.get();
        xpVar.f3606i = (C1778a) this.f3619j.get();
        xpVar.f3607j = (ce) this.f3620k.get();
    }

    private xr(Provider<qh> provider, Provider<xz> provider2, Provider<za> provider3, Provider<zm> provider4, Provider<zs> provider5, Provider<zy> provider6, Provider<aah> provider7, Provider<aan> provider8, Provider<C1778a> provider9, Provider<ce> provider10) {
        if (f3610a || provider != null) {
            this.f3611b = provider;
            if (f3610a || provider2 != null) {
                this.f3612c = provider2;
                if (f3610a || provider3 != null) {
                    this.f3613d = provider3;
                    if (f3610a || provider4 != null) {
                        this.f3614e = provider4;
                        if (f3610a || provider5 != null) {
                            this.f3615f = provider5;
                            if (f3610a || provider6 != null) {
                                this.f3616g = provider6;
                                if (f3610a || provider7 != null) {
                                    this.f3617h = provider7;
                                    if (f3610a || provider8 != null) {
                                        this.f3618i = provider8;
                                        if (f3610a || provider9 != null) {
                                            this.f3619j = provider9;
                                            if (f3610a || provider10 != null) {
                                                this.f3620k = provider10;
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

    public static MembersInjector<xp> m2621a(Provider<qh> provider, Provider<xz> provider2, Provider<za> provider3, Provider<zm> provider4, Provider<zs> provider5, Provider<zy> provider6, Provider<aah> provider7, Provider<aan> provider8, Provider<C1778a> provider9, Provider<ce> provider10) {
        return new xr(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }
}
