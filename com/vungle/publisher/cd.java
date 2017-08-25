package com.vungle.publisher;

import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cd implements MembersInjector<cc> {
    static final /* synthetic */ boolean f1444a = (!cd.class.desiredAssertionStatus());
    private final Provider<ce> f1445b;

    public final /* synthetic */ void injectMembers(Object obj) {
        cc ccVar = (cc) obj;
        if (ccVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        ccVar.f1443a = (ce) this.f1445b.get();
    }

    public static void m1240a(cc ccVar, Provider<ce> provider) {
        ccVar.f1443a = (ce) provider.get();
    }
}
