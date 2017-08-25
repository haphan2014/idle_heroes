package com.vungle.publisher;

import com.vungle.publisher.yt.C1921a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class zc implements MembersInjector<za> {
    static final /* synthetic */ boolean f3743a = (!zc.class.desiredAssertionStatus());
    private final Provider<vr> f3744b;
    private final Provider<C1921a> f3745c;
    private final Provider<yx> f3746d;

    public final /* synthetic */ void injectMembers(Object obj) {
        za zaVar = (za) obj;
        if (zaVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(zaVar, this.f3744b);
        zaVar.f3739b = (C1921a) this.f3745c.get();
        zaVar.f3740c = (yx) this.f3746d.get();
    }

    private zc(Provider<vr> provider, Provider<C1921a> provider2, Provider<yx> provider3) {
        if (f3743a || provider != null) {
            this.f3744b = provider;
            if (f3743a || provider2 != null) {
                this.f3745c = provider2;
                if (f3743a || provider3 != null) {
                    this.f3746d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<za> m2680a(Provider<vr> provider, Provider<C1921a> provider2, Provider<yx> provider3) {
        return new zc(provider, provider2, provider3);
    }
}
