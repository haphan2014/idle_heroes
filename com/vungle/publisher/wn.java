package com.vungle.publisher;

import com.vungle.publisher.abs.C1650a;
import com.vungle.publisher.wk.C1901a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class wn implements MembersInjector<C1901a> {
    static final /* synthetic */ boolean f3518a = (!wn.class.desiredAssertionStatus());
    private final Provider<pj> f3519b;
    private final Provider<String> f3520c;
    private final Provider<C1650a> f3521d;
    private final Provider<wk> f3522e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1901a c1901a = (C1901a) obj;
        if (c1901a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1901a.f779a = (pj) this.f3519b.get();
        c1901a.f3507b = (String) this.f3520c.get();
        c1901a.f3512c = (C1650a) this.f3521d.get();
        c1901a.f3513d = this.f3522e;
    }

    private wn(Provider<pj> provider, Provider<String> provider2, Provider<C1650a> provider3, Provider<wk> provider4) {
        if (f3518a || provider != null) {
            this.f3519b = provider;
            if (f3518a || provider2 != null) {
                this.f3520c = provider2;
                if (f3518a || provider3 != null) {
                    this.f3521d = provider3;
                    if (f3518a || provider4 != null) {
                        this.f3522e = provider4;
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

    public static MembersInjector<C1901a> m2583a(Provider<pj> provider, Provider<String> provider2, Provider<C1650a> provider3, Provider<wk> provider4) {
        return new wn(provider, provider2, provider3, provider4);
    }
}
