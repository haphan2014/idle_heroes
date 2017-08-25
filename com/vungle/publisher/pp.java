package com.vungle.publisher;

import android.content.SharedPreferences;
import com.vungle.publisher.pl.C1861a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pp implements MembersInjector<pl> {
    static final /* synthetic */ boolean f2911a = (!pp.class.desiredAssertionStatus());
    private final Provider<qh> f2912b;
    private final Provider<ce> f2913c;
    private final Provider<C1861a> f2914d;
    private final Provider<SharedPreferences> f2915e;

    public final /* synthetic */ void injectMembers(Object obj) {
        pl plVar = (pl) obj;
        if (plVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        plVar.f1341v = (qh) this.f2912b.get();
        plVar.f2900a = (ce) this.f2913c.get();
        plVar.f2901b = (C1861a) this.f2914d.get();
        plVar.f2902c = (SharedPreferences) this.f2915e.get();
    }

    private pp(Provider<qh> provider, Provider<ce> provider2, Provider<C1861a> provider3, Provider<SharedPreferences> provider4) {
        if (f2911a || provider != null) {
            this.f2912b = provider;
            if (f2911a || provider2 != null) {
                this.f2913c = provider2;
                if (f2911a || provider3 != null) {
                    this.f2914d = provider3;
                    if (f2911a || provider4 != null) {
                        this.f2915e = provider4;
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

    public static MembersInjector<pl> m2340a(Provider<qh> provider, Provider<ce> provider2, Provider<C1861a> provider3, Provider<SharedPreferences> provider4) {
        return new pp(provider, provider2, provider3, provider4);
    }
}
