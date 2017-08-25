package com.vungle.publisher;

import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1636b.C1634b;
import com.vungle.publisher.ada.C1666a;
import com.vungle.publisher.ada.C1668b.C1667a;
import com.vungle.publisher.ep.C1750a;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adc implements MembersInjector<C1666a> {
    static final /* synthetic */ boolean f1094a = (!adc.class.desiredAssertionStatus());
    private final Provider<C1628a> f1095b;
    private final Provider<pj> f1096c;
    private final Provider<pr> f1097d;
    private final Provider<C1634b> f1098e;
    private final Provider<pq> f1099f;
    private final Provider<C1750a> f1100g;
    private final Provider<C1667a> f1101h;
    private final Provider<pu> f1102i;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1666a c1666a = (C1666a) obj;
        if (c1666a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1666a.f886a = (C1628a) this.f1095b.get();
        c1666a.f887b = (pj) this.f1096c.get();
        c1666a.f888c = (pr) this.f1097d.get();
        c1666a.f889d = (C1634b) this.f1098e.get();
        c1666a.f890e = (pq) this.f1099f.get();
        c1666a.f1080f = (C1750a) this.f1100g.get();
        c1666a.f1081g = (C1667a) this.f1101h.get();
        c1666a.f1082h = DoubleCheck.lazy(this.f1102i);
    }

    private adc(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1750a> provider6, Provider<C1667a> provider7, Provider<pu> provider8) {
        if (f1094a || provider != null) {
            this.f1095b = provider;
            if (f1094a || provider2 != null) {
                this.f1096c = provider2;
                if (f1094a || provider3 != null) {
                    this.f1097d = provider3;
                    if (f1094a || provider4 != null) {
                        this.f1098e = provider4;
                        if (f1094a || provider5 != null) {
                            this.f1099f = provider5;
                            if (f1094a || provider6 != null) {
                                this.f1100g = provider6;
                                if (f1094a || provider7 != null) {
                                    this.f1101h = provider7;
                                    if (f1094a || provider8 != null) {
                                        this.f1102i = provider8;
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

    public static MembersInjector<C1666a> m1039a(Provider<C1628a> provider, Provider<pj> provider2, Provider<pr> provider3, Provider<C1634b> provider4, Provider<pq> provider5, Provider<C1750a> provider6, Provider<C1667a> provider7, Provider<pu> provider8) {
        return new adc(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }
}
