package com.vungle.publisher;

import com.vungle.publisher.aab.C1625a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aaj implements MembersInjector<aah> {
    static final /* synthetic */ boolean f822a = (!aaj.class.desiredAssertionStatus());
    private final Provider<vr> f823b;
    private final Provider<C1625a> f824c;
    private final Provider<aae> f825d;

    public final /* synthetic */ void injectMembers(Object obj) {
        aah com_vungle_publisher_aah = (aah) obj;
        if (com_vungle_publisher_aah == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(com_vungle_publisher_aah, this.f823b);
        com_vungle_publisher_aah.f818b = (C1625a) this.f824c.get();
        com_vungle_publisher_aah.f819c = (aae) this.f825d.get();
    }

    private aaj(Provider<vr> provider, Provider<C1625a> provider2, Provider<aae> provider3) {
        if (f822a || provider != null) {
            this.f823b = provider;
            if (f822a || provider2 != null) {
                this.f824c = provider2;
                if (f822a || provider3 != null) {
                    this.f825d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<aah> m845a(Provider<vr> provider, Provider<C1625a> provider2, Provider<aae> provider3) {
        return new aaj(provider, provider2, provider3);
    }
}
