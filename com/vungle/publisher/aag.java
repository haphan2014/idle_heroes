package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aag implements MembersInjector<aae> {
    static final /* synthetic */ boolean f811a = (!aag.class.desiredAssertionStatus());
    private final Provider<C1778a> f812b;
    private final Provider<wa> f813c;
    private final Provider<ce> f814d;
    private final Provider<pu> f815e;

    public final /* synthetic */ void injectMembers(Object obj) {
        aae com_vungle_publisher_aae = (aae) obj;
        if (com_vungle_publisher_aae == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vn.m2548a(com_vungle_publisher_aae, this.f812b);
        vn.m2549b(com_vungle_publisher_aae, this.f813c);
        wj.m2576a(com_vungle_publisher_aae, this.f814d);
        com_vungle_publisher_aae.f808g = (pu) this.f815e.get();
    }

    private aag(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<pu> provider4) {
        if (f811a || provider != null) {
            this.f812b = provider;
            if (f811a || provider2 != null) {
                this.f813c = provider2;
                if (f811a || provider3 != null) {
                    this.f814d = provider3;
                    if (f811a || provider4 != null) {
                        this.f815e = provider4;
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

    public static MembersInjector<aae> m841a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3, Provider<pu> provider4) {
        return new aag(provider, provider2, provider3, provider4);
    }
}
