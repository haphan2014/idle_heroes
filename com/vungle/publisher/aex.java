package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aex implements MembersInjector<aev> {
    static final /* synthetic */ boolean f1286a = (!aex.class.desiredAssertionStatus());
    private final Provider<C1730b> f1287b;
    private final Provider<C1778a> f1288c;
    private final Provider<aey> f1289d;
    private final Provider<C1747b> f1290e;

    public final /* synthetic */ void injectMembers(Object obj) {
        aev com_vungle_publisher_aev = (aev) obj;
        if (com_vungle_publisher_aev == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_aev.f1280a = (C1730b) this.f1287b.get();
        com_vungle_publisher_aev.f1281b = (C1778a) this.f1288c.get();
        com_vungle_publisher_aev.f1282c = (aey) this.f1289d.get();
        com_vungle_publisher_aev.f1283d = (C1747b) this.f1290e.get();
    }

    private aex(Provider<C1730b> provider, Provider<C1778a> provider2, Provider<aey> provider3, Provider<C1747b> provider4) {
        if (f1286a || provider != null) {
            this.f1287b = provider;
            if (f1286a || provider2 != null) {
                this.f1288c = provider2;
                if (f1286a || provider3 != null) {
                    this.f1289d = provider3;
                    if (f1286a || provider4 != null) {
                        this.f1290e = provider4;
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

    public static MembersInjector<aev> m1160a(Provider<C1730b> provider, Provider<C1778a> provider2, Provider<aey> provider3, Provider<C1747b> provider4) {
        return new aex(provider, provider2, provider3, provider4);
    }
}
