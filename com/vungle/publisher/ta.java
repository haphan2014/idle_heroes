package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.st.C1873a;
import com.vungle.publisher.su.C1876a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ta implements MembersInjector<C1873a> {
    static final /* synthetic */ boolean f3234a = (!ta.class.desiredAssertionStatus());
    private final Provider<Context> f3235b;
    private final Provider<qh> f3236c;
    private final Provider<C1876a> f3237d;
    private final Provider<sr> f3238e;
    private final Provider<te> f3239f;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1873a c1873a = (C1873a) obj;
        if (c1873a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        nc.m2188a(c1873a, this.f3235b);
        nc.m2189b(c1873a, this.f3236c);
        c1873a.f3194c = (C1876a) this.f3237d.get();
        c1873a.f3195d = this.f3238e;
        c1873a.f3196e = (te) this.f3239f.get();
    }

    private ta(Provider<Context> provider, Provider<qh> provider2, Provider<C1876a> provider3, Provider<sr> provider4, Provider<te> provider5) {
        if (f3234a || provider != null) {
            this.f3235b = provider;
            if (f3234a || provider2 != null) {
                this.f3236c = provider2;
                if (f3234a || provider3 != null) {
                    this.f3237d = provider3;
                    if (f3234a || provider4 != null) {
                        this.f3238e = provider4;
                        if (f3234a || provider5 != null) {
                            this.f3239f = provider5;
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

    public static MembersInjector<C1873a> m2489a(Provider<Context> provider, Provider<qh> provider2, Provider<C1876a> provider3, Provider<sr> provider4, Provider<te> provider5) {
        return new ta(provider, provider2, provider3, provider4, provider5);
    }
}
