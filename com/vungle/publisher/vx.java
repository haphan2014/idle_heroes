package com.vungle.publisher;

import com.vungle.publisher.vg.C1896a;
import com.vungle.publisher.vl.C1897a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vx implements MembersInjector<vv> {
    static final /* synthetic */ boolean f3484a = (!vx.class.desiredAssertionStatus());
    private final Provider<vy> f3485b;
    private final Provider<C1897a> f3486c;
    private final Provider<C1896a> f3487d;

    public final /* synthetic */ void injectMembers(Object obj) {
        vv vvVar = (vv) obj;
        if (vvVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vvVar.f3479a = (vy) this.f3485b.get();
        vvVar.f3480b = (C1897a) this.f3486c.get();
        vvVar.f3481c = (C1896a) this.f3487d.get();
    }

    private vx(Provider<vy> provider, Provider<C1897a> provider2, Provider<C1896a> provider3) {
        if (f3484a || provider != null) {
            this.f3485b = provider;
            if (f3484a || provider2 != null) {
                this.f3486c = provider2;
                if (f3484a || provider3 != null) {
                    this.f3487d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<vv> m2563a(Provider<vy> provider, Provider<C1897a> provider2, Provider<C1896a> provider3) {
        return new vx(provider, provider2, provider3);
    }
}
