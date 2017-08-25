package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.ey.C1758a;
import com.vungle.publisher.gs.C1777a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class gp implements MembersInjector<C1758a> {
    static final /* synthetic */ boolean f2003a = (!gp.class.desiredAssertionStatus());
    private final Provider<cq> f2004b;
    private final Provider<C1892a> f2005c;
    private final Provider<ey> f2006d;
    private final Provider<C1777a> f2007e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1758a c1758a = (C1758a) obj;
        if (c1758a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1758a.f1530d = (cq) this.f2004b.get();
        c1758a.f1676e = (C1892a) this.f2005c.get();
        c1758a.f1826a = this.f2006d;
        c1758a.f1827b = (C1777a) this.f2007e.get();
    }

    private gp(Provider<cq> provider, Provider<C1892a> provider2, Provider<ey> provider3, Provider<C1777a> provider4) {
        if (f2003a || provider != null) {
            this.f2004b = provider;
            if (f2003a || provider2 != null) {
                this.f2005c = provider2;
                if (f2003a || provider3 != null) {
                    this.f2006d = provider3;
                    if (f2003a || provider4 != null) {
                        this.f2007e = provider4;
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

    public static MembersInjector<C1758a> m1839a(Provider<cq> provider, Provider<C1892a> provider2, Provider<ey> provider3, Provider<C1777a> provider4) {
        return new gp(provider, provider2, provider3, provider4);
    }
}
