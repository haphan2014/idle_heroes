package com.vungle.publisher;

import com.vungle.publisher.zg.C1924a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zo implements MembersInjector<zm> {
    static final /* synthetic */ boolean f3793a = (!zo.class.desiredAssertionStatus());
    private final Provider<vr> f3794b;
    private final Provider<C1924a> f3795c;
    private final Provider<zj> f3796d;

    public final /* synthetic */ void injectMembers(Object obj) {
        zm zmVar = (zm) obj;
        if (zmVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(zmVar, this.f3794b);
        zmVar.f3789b = (C1924a) this.f3795c.get();
        zmVar.f3790c = (zj) this.f3796d.get();
    }

    private zo(Provider<vr> provider, Provider<C1924a> provider2, Provider<zj> provider3) {
        if (f3793a || provider != null) {
            this.f3794b = provider;
            if (f3793a || provider2 != null) {
                this.f3795c = provider2;
                if (f3793a || provider3 != null) {
                    this.f3796d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<zm> m2711a(Provider<vr> provider, Provider<C1924a> provider2, Provider<zj> provider3) {
        return new zo(provider, provider2, provider3);
    }
}
