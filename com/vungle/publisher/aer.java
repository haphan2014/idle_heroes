package com.vungle.publisher;

import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aer implements MembersInjector<aep> {
    static final /* synthetic */ boolean f1240a = (!aer.class.desiredAssertionStatus());
    private final Provider<C1721b> f1241b;
    private final Provider<C1747b> f1242c;
    private final Provider<C1778a> f1243d;

    public final /* synthetic */ void injectMembers(Object obj) {
        aep com_vungle_publisher_aep = (aep) obj;
        if (com_vungle_publisher_aep == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_aep.f1235a = (C1721b) this.f1241b.get();
        com_vungle_publisher_aep.f1236b = (C1747b) this.f1242c.get();
        com_vungle_publisher_aep.f1237c = (C1778a) this.f1243d.get();
    }

    private aer(Provider<C1721b> provider, Provider<C1747b> provider2, Provider<C1778a> provider3) {
        if (f1240a || provider != null) {
            this.f1241b = provider;
            if (f1240a || provider2 != null) {
                this.f1242c = provider2;
                if (f1240a || provider3 != null) {
                    this.f1243d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<aep> m1153a(Provider<C1721b> provider, Provider<C1747b> provider2, Provider<C1778a> provider3) {
        return new aer(provider, provider2, provider3);
    }
}
