package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xy implements MembersInjector<xw> {
    static final /* synthetic */ boolean f3640a = (!xy.class.desiredAssertionStatus());
    private final Provider<C1778a> f3641b;
    private final Provider<wa> f3642c;
    private final Provider<ce> f3643d;
    private final Provider<afl> f3644e;

    public final /* synthetic */ void injectMembers(Object obj) {
        xw xwVar = (xw) obj;
        if (xwVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vn.m2548a(xwVar, this.f3641b);
        vn.m2549b(xwVar, this.f3642c);
        wj.m2576a(xwVar, this.f3643d);
        xwVar.f3637g = DoubleCheck.lazy(this.f3644e);
    }

    private xy(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<afl> provider4) {
        if (f3640a || provider != null) {
            this.f3641b = provider;
            if (f3640a || provider2 != null) {
                this.f3642c = provider2;
                if (f3640a || provider3 != null) {
                    this.f3643d = provider3;
                    if (f3640a || provider4 != null) {
                        this.f3644e = provider4;
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

    public static MembersInjector<xw> m2636a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<afl> provider4) {
        return new xy(provider, provider2, provider3, provider4);
    }
}
