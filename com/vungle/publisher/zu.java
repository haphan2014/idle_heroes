package com.vungle.publisher;

import com.vungle.publisher.zp.C1926a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zu implements MembersInjector<zs> {
    static final /* synthetic */ boolean f3812a = (!zu.class.desiredAssertionStatus());
    private final Provider<vr> f3813b;
    private final Provider<C1926a> f3814c;
    private final Provider<vb> f3815d;

    public final /* synthetic */ void injectMembers(Object obj) {
        zs zsVar = (zs) obj;
        if (zsVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(zsVar, this.f3813b);
        zsVar.f3808b = (C1926a) this.f3814c.get();
        zsVar.f3809c = (vb) this.f3815d.get();
    }

    private zu(Provider<vr> provider, Provider<C1926a> provider2, Provider<vb> provider3) {
        if (f3812a || provider != null) {
            this.f3813b = provider;
            if (f3812a || provider2 != null) {
                this.f3814c = provider2;
                if (f3812a || provider3 != null) {
                    this.f3815d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<zs> m2720a(Provider<vr> provider, Provider<C1926a> provider2, Provider<vb> provider3) {
        return new zu(provider, provider2, provider3);
    }
}
