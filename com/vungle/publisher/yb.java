package com.vungle.publisher;

import com.vungle.publisher.xt.C1915b;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yb implements MembersInjector<xz> {
    static final /* synthetic */ boolean f3649a = (!yb.class.desiredAssertionStatus());
    private final Provider<vr> f3650b;
    private final Provider<C1915b> f3651c;
    private final Provider<xw> f3652d;

    public final /* synthetic */ void injectMembers(Object obj) {
        xz xzVar = (xz) obj;
        if (xzVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(xzVar, this.f3650b);
        xzVar.f3645b = (C1915b) this.f3651c.get();
        xzVar.f3646c = this.f3652d;
    }

    private yb(Provider<vr> provider, Provider<C1915b> provider2, Provider<xw> provider3) {
        if (f3649a || provider != null) {
            this.f3650b = provider;
            if (f3649a || provider2 != null) {
                this.f3651c = provider2;
                if (f3649a || provider3 != null) {
                    this.f3652d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<xz> m2639a(Provider<vr> provider, Provider<C1915b> provider2, Provider<xw> provider3) {
        return new yb(provider, provider2, provider3);
    }
}
