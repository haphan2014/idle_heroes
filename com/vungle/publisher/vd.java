package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class vd implements MembersInjector<vb> {
    static final /* synthetic */ boolean f3420a = (!vd.class.desiredAssertionStatus());
    private final Provider<C1778a> f3421b;
    private final Provider<wa> f3422c;
    private final Provider<ce> f3423d;

    public final /* synthetic */ void injectMembers(Object obj) {
        vb vbVar = (vb) obj;
        if (vbVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vbVar.f800a = (C1778a) this.f3421b.get();
        vbVar.f801b = (wa) this.f3422c.get();
        vbVar.f805f = (ce) this.f3423d.get();
    }

    private vd(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3) {
        if (f3420a || provider != null) {
            this.f3421b = provider;
            if (f3420a || provider2 != null) {
                this.f3422c = provider2;
                if (f3420a || provider3 != null) {
                    this.f3423d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<vb> m2543a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3) {
        return new vd(provider, provider2, provider3);
    }
}
