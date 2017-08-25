package com.vungle.publisher;

import com.vungle.publisher.wy.C1903a;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* compiled from: vungle */
public final class xd implements MembersInjector<xb> {
    static final /* synthetic */ boolean f3561a = (!xd.class.desiredAssertionStatus());
    private final Provider<vr> f3562b;
    private final Provider<C1903a> f3563c;
    private final Provider<us> f3564d;
    private final Provider<vb> f3565e;

    public final /* synthetic */ void injectMembers(Object obj) {
        xb xbVar = (xb) obj;
        if (xbVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        xbVar.f817a = this.f3562b;
        xbVar.f3556b = (C1903a) this.f3563c.get();
        xbVar.f3557c = DoubleCheck.lazy(this.f3564d);
        xbVar.f3558d = DoubleCheck.lazy(this.f3565e);
    }

    private xd(Provider<vr> provider, Provider<C1903a> provider2, Provider<us> provider3, Provider<vb> provider4) {
        if (f3561a || provider != null) {
            this.f3562b = provider;
            if (f3561a || provider2 != null) {
                this.f3563c = provider2;
                if (f3561a || provider3 != null) {
                    this.f3564d = provider3;
                    if (f3561a || provider4 != null) {
                        this.f3565e = provider4;
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

    public static MembersInjector<xb> m2600a(Provider<vr> provider, Provider<C1903a> provider2, Provider<us> provider3, Provider<vb> provider4) {
        return new xd(provider, provider2, provider3, provider4);
    }
}
