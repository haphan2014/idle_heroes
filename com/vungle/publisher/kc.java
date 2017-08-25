package com.vungle.publisher;

import com.vungle.publisher.dr.C1737a;
import com.vungle.publisher.ey.C1758a;
import com.vungle.publisher.fa.C1764a;
import com.vungle.publisher.ka.C1800b;
import com.vungle.publisher.ke.C1802a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class kc implements MembersInjector<C1800b> {
    static final /* synthetic */ boolean f2330a = (!kc.class.desiredAssertionStatus());
    private final Provider<cq> f2331b;
    private final Provider<C1737a> f2332c;
    private final Provider<C1802a> f2333d;
    private final Provider<C1764a> f2334e;
    private final Provider<C1758a> f2335f;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1800b c1800b = (C1800b) obj;
        if (c1800b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1800b.f2323a = (cq) this.f2331b.get();
        c1800b.f2324b = (C1737a) this.f2332c.get();
        c1800b.f2325c = (C1802a) this.f2333d.get();
        c1800b.f2326d = (C1764a) this.f2334e.get();
        c1800b.f2327e = (C1758a) this.f2335f.get();
    }

    private kc(Provider<cq> provider, Provider<C1737a> provider2, Provider<C1802a> provider3, Provider<C1764a> provider4, Provider<C1758a> provider5) {
        if (f2330a || provider != null) {
            this.f2331b = provider;
            if (f2330a || provider2 != null) {
                this.f2332c = provider2;
                if (f2330a || provider3 != null) {
                    this.f2333d = provider3;
                    if (f2330a || provider4 != null) {
                        this.f2334e = provider4;
                        if (f2330a || provider5 != null) {
                            this.f2335f = provider5;
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

    public static MembersInjector<C1800b> m2033a(Provider<cq> provider, Provider<C1737a> provider2, Provider<C1802a> provider3, Provider<C1764a> provider4, Provider<C1758a> provider5) {
        return new kc(provider, provider2, provider3, provider4, provider5);
    }
}
