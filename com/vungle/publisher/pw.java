package com.vungle.publisher;

import android.content.Context;
import android.content.SharedPreferences;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pw implements MembersInjector<pu> {
    static final /* synthetic */ boolean f2949a = (!pw.class.desiredAssertionStatus());
    private final Provider<Context> f2950b;
    private final Provider<agg> f2951c;
    private final Provider<cn> f2952d;
    private final Provider<pj> f2953e;
    private final Provider<qh> f2954f;
    private final Provider<mg> f2955g;
    private final Provider<uo> f2956h;
    private final Provider<ce> f2957i;
    private final Provider<pl> f2958j;
    private final Provider<xp> f2959k;
    private final Provider<C1778a> f2960l;
    private final Provider<SharedPreferences> f2961m;

    public final /* synthetic */ void injectMembers(Object obj) {
        pu puVar = (pu) obj;
        if (puVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        puVar.f2932a = (Context) this.f2950b.get();
        puVar.f2933b = (agg) this.f2951c.get();
        puVar.f2934c = (cn) this.f2952d.get();
        puVar.f2935d = (pj) this.f2953e.get();
        puVar.f2936e = (qh) this.f2954f.get();
        puVar.f2937f = (mg) this.f2955g.get();
        puVar.f2938g = (uo) this.f2956h.get();
        puVar.f2939h = (ce) this.f2957i.get();
        puVar.f2940i = (pl) this.f2958j.get();
        puVar.f2941j = (xp) this.f2959k.get();
        puVar.f2942k = (C1778a) this.f2960l.get();
        puVar.f2943l = (SharedPreferences) this.f2961m.get();
    }

    private pw(Provider<Context> provider, Provider<agg> provider2, Provider<cn> provider3, Provider<pj> provider4, Provider<qh> provider5, Provider<mg> provider6, Provider<uo> provider7, Provider<ce> provider8, Provider<pl> provider9, Provider<xp> provider10, Provider<C1778a> provider11, Provider<SharedPreferences> provider12) {
        if (f2949a || provider != null) {
            this.f2950b = provider;
            if (f2949a || provider2 != null) {
                this.f2951c = provider2;
                if (f2949a || provider3 != null) {
                    this.f2952d = provider3;
                    if (f2949a || provider4 != null) {
                        this.f2953e = provider4;
                        if (f2949a || provider5 != null) {
                            this.f2954f = provider5;
                            if (f2949a || provider6 != null) {
                                this.f2955g = provider6;
                                if (f2949a || provider7 != null) {
                                    this.f2956h = provider7;
                                    if (f2949a || provider8 != null) {
                                        this.f2957i = provider8;
                                        if (f2949a || provider9 != null) {
                                            this.f2958j = provider9;
                                            if (f2949a || provider10 != null) {
                                                this.f2959k = provider10;
                                                if (f2949a || provider11 != null) {
                                                    this.f2960l = provider11;
                                                    if (f2949a || provider12 != null) {
                                                        this.f2961m = provider12;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<pu> m2352a(Provider<Context> provider, Provider<agg> provider2, Provider<cn> provider3, Provider<pj> provider4, Provider<qh> provider5, Provider<mg> provider6, Provider<uo> provider7, Provider<ce> provider8, Provider<pl> provider9, Provider<xp> provider10, Provider<C1778a> provider11, Provider<SharedPreferences> provider12) {
        return new pw(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }
}
