package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class uu implements MembersInjector<us> {
    static final /* synthetic */ boolean f3392a = (!uu.class.desiredAssertionStatus());
    private final Provider<C1778a> f3393b;
    private final Provider<wa> f3394c;
    private final Provider<ce> f3395d;

    public final /* synthetic */ void injectMembers(Object obj) {
        us usVar = (us) obj;
        if (usVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        usVar.f800a = (C1778a) this.f3393b.get();
        usVar.f801b = (wa) this.f3394c.get();
        usVar.f805f = (ce) this.f3395d.get();
    }

    private uu(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3) {
        if (f3392a || provider != null) {
            this.f3393b = provider;
            if (f3392a || provider2 != null) {
                this.f3394c = provider2;
                if (f3392a || provider3 != null) {
                    this.f3395d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<us> m2530a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3) {
        return new uu(provider, provider2, provider3);
    }
}
