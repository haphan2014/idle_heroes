package com.vungle.publisher;

import com.vungle.publisher.kt.C1805a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class kx implements MembersInjector<kt> {
    static final /* synthetic */ boolean f2409a = (!kx.class.desiredAssertionStatus());
    private final Provider<cq> f2410b;
    private final Provider<C1805a> f2411c;

    public final /* synthetic */ void injectMembers(Object obj) {
        kt ktVar = (kt) obj;
        if (ktVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ktVar.f1551v = (cq) this.f2410b.get();
        ktVar.f2400e = (C1805a) this.f2411c.get();
    }

    private kx(Provider<cq> provider, Provider<C1805a> provider2) {
        if (f2409a || provider != null) {
            this.f2410b = provider;
            if (f2409a || provider2 != null) {
                this.f2411c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<kt> m2095a(Provider<cq> provider, Provider<C1805a> provider2) {
        return new kx(provider, provider2);
    }
}
