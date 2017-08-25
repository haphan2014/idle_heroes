package com.vungle.publisher;

import android.content.Context;
import android.telephony.TelephonyManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rn implements Factory<TelephonyManager> {
    static final /* synthetic */ boolean f3085a = (!rn.class.desiredAssertionStatus());
    private final ra f3086b;
    private final Provider<Context> f3087c;

    private rn(ra raVar, Provider<Context> provider) {
        if (f3085a || raVar != null) {
            this.f3086b = raVar;
            if (f3085a || provider != null) {
                this.f3087c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<TelephonyManager> m2393a(ra raVar, Provider<Context> provider) {
        return new rn(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        TelephonyManager telephonyManager = (TelephonyManager) ((Context) this.f3087c.get()).getSystemService("phone");
        if (telephonyManager == null) {
            so.m2470a(3, "VungleDevice", "TelephonyManager not avaialble", null);
        }
        return (TelephonyManager) Preconditions.checkNotNull(telephonyManager, "Cannot return null from a non-@Nullable @Provides method");
    }
}
