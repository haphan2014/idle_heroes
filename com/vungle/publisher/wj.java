package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class wj implements MembersInjector<wi> {
    static final /* synthetic */ boolean f3508a = (!wj.class.desiredAssertionStatus());
    private final Provider<C1778a> f3509b;
    private final Provider<wa> f3510c;
    private final Provider<ce> f3511d;

    public final /* synthetic */ void injectMembers(Object obj) {
        wi wiVar = (wi) obj;
        if (wiVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        wiVar.f800a = (C1778a) this.f3509b.get();
        wiVar.f801b = (wa) this.f3510c.get();
        wiVar.f805f = (ce) this.f3511d.get();
    }

    public static void m2576a(wi wiVar, Provider<ce> provider) {
        wiVar.f805f = (ce) provider.get();
    }
}
