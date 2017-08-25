package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.lv.C1812b;
import com.vungle.publisher.on.C1847a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class og implements MembersInjector<oc> {
    static final /* synthetic */ boolean f2738a = (!og.class.desiredAssertionStatus());
    private final Provider<C1778a> f2739b;
    private final Provider<nd> f2740c;
    private final Provider<pj> f2741d;
    private final Provider<qh> f2742e;
    private final Provider<C1812b> f2743f;
    private final Provider<Context> f2744g;
    private final Provider<C1847a> f2745h;

    public final /* synthetic */ void injectMembers(Object obj) {
        oc ocVar = (oc) obj;
        if (ocVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ocVar.f2592c = (C1778a) this.f2739b.get();
        ocVar.f2593d = (nd) this.f2740c.get();
        ocVar.f2606i = (pj) this.f2741d.get();
        ocVar.f2607j = (qh) this.f2742e.get();
        ocVar.f2608k = (C1812b) this.f2743f.get();
        ocVar.f2609l = (Context) this.f2744g.get();
        ocVar.f2731m = (C1847a) this.f2745h.get();
    }

    private og(Provider<C1778a> provider, Provider<nd> provider2, Provider<pj> provider3, Provider<qh> provider4, Provider<C1812b> provider5, Provider<Context> provider6, Provider<C1847a> provider7) {
        if (f2738a || provider != null) {
            this.f2739b = provider;
            if (f2738a || provider2 != null) {
                this.f2740c = provider2;
                if (f2738a || provider3 != null) {
                    this.f2741d = provider3;
                    if (f2738a || provider4 != null) {
                        this.f2742e = provider4;
                        if (f2738a || provider5 != null) {
                            this.f2743f = provider5;
                            if (f2738a || provider6 != null) {
                                this.f2744g = provider6;
                                if (f2738a || provider7 != null) {
                                    this.f2745h = provider7;
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

    public static MembersInjector<oc> m2260a(Provider<C1778a> provider, Provider<nd> provider2, Provider<pj> provider3, Provider<qh> provider4, Provider<C1812b> provider5, Provider<Context> provider6, Provider<C1847a> provider7) {
        return new og(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
