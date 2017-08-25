package com.vungle.publisher;

import android.content.Context;
import android.net.ConnectivityManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class re implements Factory<ConnectivityManager> {
    static final /* synthetic */ boolean f3058a = (!re.class.desiredAssertionStatus());
    private final ra f3059b;
    private final Provider<Context> f3060c;

    private re(ra raVar, Provider<Context> provider) {
        if (f3058a || raVar != null) {
            this.f3059b = raVar;
            if (f3058a || provider != null) {
                this.f3060c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<ConnectivityManager> m2384a(ra raVar, Provider<Context> provider) {
        return new re(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ((Context) this.f3060c.get()).getSystemService("connectivity");
        if (connectivityManager == null) {
            so.m2470a(3, "VungleDevice", "ConnectivityManager not available", null);
        }
        return (ConnectivityManager) Preconditions.checkNotNull(connectivityManager, "Cannot return null from a non-@Nullable @Provides method");
    }
}
