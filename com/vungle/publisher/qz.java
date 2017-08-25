package com.vungle.publisher;

import android.content.Context;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class qz implements MembersInjector<qx> {
    static final /* synthetic */ boolean f3039a = (!qz.class.desiredAssertionStatus());
    private final Provider<Context> f3040b;

    public final /* synthetic */ void injectMembers(Object obj) {
        qx qxVar = (qx) obj;
        if (qxVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        qxVar.f3036a = (Context) this.f3040b.get();
    }

    private qz(Provider<Context> provider) {
        if (f3039a || provider != null) {
            this.f3040b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<qx> m2379a(Provider<Context> provider) {
        return new qz(provider);
    }
}
