package com.vungle.publisher;

import com.vungle.publisher.dd.C1733a;
import com.vungle.publisher.ho.C1783a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class hx implements MembersInjector<ho> {
    static final /* synthetic */ boolean f2111a = (!hx.class.desiredAssertionStatus());
    private final Provider<cq> f2112b;
    private final Provider<C1733a> f2113c;
    private final Provider<agg> f2114d;
    private final Provider<C1783a> f2115e;

    public final /* synthetic */ void injectMembers(Object obj) {
        ho hoVar = (ho) obj;
        if (hoVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        hoVar.f1551v = (cq) this.f2112b.get();
        hoVar.f1622r = (C1733a) this.f2113c.get();
        hoVar.f1623s = (agg) this.f2114d.get();
        hoVar.f2087w = (C1783a) this.f2115e.get();
    }

    private hx(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1783a> provider4) {
        if (f2111a || provider != null) {
            this.f2112b = provider;
            if (f2111a || provider2 != null) {
                this.f2113c = provider2;
                if (f2111a || provider3 != null) {
                    this.f2114d = provider3;
                    if (f2111a || provider4 != null) {
                        this.f2115e = provider4;
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

    public static MembersInjector<ho> m1927a(Provider<cq> provider, Provider<C1733a> provider2, Provider<agg> provider3, Provider<C1783a> provider4) {
        return new hx(provider, provider2, provider3, provider4);
    }
}
