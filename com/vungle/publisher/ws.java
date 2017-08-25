package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ws implements MembersInjector<wo> {
    static final /* synthetic */ boolean f3532a = (!ws.class.desiredAssertionStatus());
    private final Provider<C1778a> f3533b;
    private final Provider<wa> f3534c;
    private final Provider<ce> f3535d;

    public final /* synthetic */ void injectMembers(Object obj) {
        wo woVar = (wo) obj;
        if (woVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        woVar.f800a = (C1778a) this.f3533b.get();
        woVar.f801b = (wa) this.f3534c.get();
        woVar.f805f = (ce) this.f3535d.get();
        woVar.f3525h = (C1778a) this.f3533b.get();
    }

    private ws(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3) {
        if (f3532a || provider != null) {
            this.f3533b = provider;
            if (f3532a || provider2 != null) {
                this.f3534c = provider2;
                if (f3532a || provider3 != null) {
                    this.f3535d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<wo> m2588a(Provider<C1778a> provider, Provider<wa> provider2, Provider<ce> provider3) {
        return new ws(provider, provider2, provider3);
    }
}
