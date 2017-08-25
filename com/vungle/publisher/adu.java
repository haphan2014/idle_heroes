package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.abc.C1641a;
import com.vungle.publisher.ads.C1676a;
import com.vungle.publisher.aeh.C1680a;
import com.vungle.publisher.aen.C1683a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adu implements MembersInjector<C1676a> {
    static final /* synthetic */ boolean f1176a = (!adu.class.desiredAssertionStatus());
    private final Provider<C1892a> f1177b;
    private final Provider<agg> f1178c;
    private final Provider<C1683a> f1179d;
    private final Provider<C1680a> f1180e;
    private final Provider<C1641a> f1181f;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1676a c1676a = (C1676a) obj;
        if (c1676a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1676a.f1041a = (C1892a) this.f1177b.get();
        c1676a.f1166b = (agg) this.f1178c.get();
        c1676a.f1167c = (C1683a) this.f1179d.get();
        c1676a.f1168d = (C1680a) this.f1180e.get();
        c1676a.f1169e = (C1641a) this.f1181f.get();
    }

    private adu(Provider<C1892a> provider, Provider<agg> provider2, Provider<C1683a> provider3, Provider<C1680a> provider4, Provider<C1641a> provider5) {
        if (f1176a || provider != null) {
            this.f1177b = provider;
            if (f1176a || provider2 != null) {
                this.f1178c = provider2;
                if (f1176a || provider3 != null) {
                    this.f1179d = provider3;
                    if (f1176a || provider4 != null) {
                        this.f1180e = provider4;
                        if (f1176a || provider5 != null) {
                            this.f1181f = provider5;
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

    public static MembersInjector<C1676a> m1105a(Provider<C1892a> provider, Provider<agg> provider2, Provider<C1683a> provider3, Provider<C1680a> provider4, Provider<C1641a> provider5) {
        return new adu(provider, provider2, provider3, provider4, provider5);
    }
}
