package com.vungle.publisher;

import com.vungle.publisher.wk.C1901a;
import com.vungle.publisher.wo.C1902a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class wv implements MembersInjector<wt> {
    static final /* synthetic */ boolean f3540a = (!wv.class.desiredAssertionStatus());
    private final Provider<vr> f3541b;
    private final Provider<C1901a> f3542c;
    private final Provider<C1902a> f3543d;

    public final /* synthetic */ void injectMembers(Object obj) {
        wt wtVar = (wt) obj;
        if (wtVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        wtVar.f817a = this.f3541b;
        wtVar.f3536b = (C1901a) this.f3542c.get();
        wtVar.f3537c = (C1902a) this.f3543d.get();
    }

    private wv(Provider<vr> provider, Provider<C1901a> provider2, Provider<C1902a> provider3) {
        if (f3540a || provider != null) {
            this.f3541b = provider;
            if (f3540a || provider2 != null) {
                this.f3542c = provider2;
                if (f3540a || provider3 != null) {
                    this.f3543d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<wt> m2591a(Provider<vr> provider, Provider<C1901a> provider2, Provider<C1902a> provider3) {
        return new wv(provider, provider2, provider3);
    }
}
