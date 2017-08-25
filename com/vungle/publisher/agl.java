package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class agl implements MembersInjector<agj> {
    static final /* synthetic */ boolean f1410a = (!agl.class.desiredAssertionStatus());
    private final Provider<qx> f1411b;
    private final Provider<C1778a> f1412c;

    public final /* synthetic */ void injectMembers(Object obj) {
        agj com_vungle_publisher_agj = (agj) obj;
        if (com_vungle_publisher_agj == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_agj.f1406a = (qx) this.f1411b.get();
        com_vungle_publisher_agj.f1407b = (C1778a) this.f1412c.get();
    }

    private agl(Provider<qx> provider, Provider<C1778a> provider2) {
        if (f1410a || provider != null) {
            this.f1411b = provider;
            if (f1410a || provider2 != null) {
                this.f1412c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<agj> m1231a(Provider<qx> provider, Provider<C1778a> provider2) {
        return new agl(provider, provider2);
    }
}
