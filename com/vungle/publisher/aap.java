package com.vungle.publisher;

import com.vungle.publisher.aak.C1627a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aap implements MembersInjector<aan> {
    static final /* synthetic */ boolean f840a = (!aap.class.desiredAssertionStatus());
    private final Provider<vr> f841b;
    private final Provider<C1627a> f842c;
    private final Provider<vb> f843d;

    public final /* synthetic */ void injectMembers(Object obj) {
        aan com_vungle_publisher_aan = (aan) obj;
        if (com_vungle_publisher_aan == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(com_vungle_publisher_aan, this.f841b);
        com_vungle_publisher_aan.f836b = (C1627a) this.f842c.get();
        com_vungle_publisher_aan.f837c = (vb) this.f843d.get();
    }

    private aap(Provider<vr> provider, Provider<C1627a> provider2, Provider<vb> provider3) {
        if (f840a || provider != null) {
            this.f841b = provider;
            if (f840a || provider2 != null) {
                this.f842c = provider2;
                if (f840a || provider3 != null) {
                    this.f843d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<aan> m854a(Provider<vr> provider, Provider<C1627a> provider2, Provider<vb> provider3) {
        return new aap(provider, provider2, provider3);
    }
}
